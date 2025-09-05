import java.util.*;

public class MaxReachableNodes {
    static class Edge {
        int to, weight;
        Edge(int t, int w) { to = t; weight = w; }
    }

    public static int reachableNodes(int[][] edges, int n, int maxMoves) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Edge(v, w + 1)); // subdivided edge weight
            graph.get(v).add(new Edge(u, w + 1));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            if (d > dist[node]) continue;

            for (Edge e : graph.get(node)) {
                int newDist = d + e.weight;
                if (newDist < dist[e.to]) {
                    dist[e.to] = newDist;
                    pq.add(new int[]{e.to, newDist});
                }
            }
        }

        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves) ans++;
        }

        // count subdivided nodes
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int fromU = dist[u] > maxMoves ? 0 : maxMoves - dist[u];
            int fromV = dist[v] > maxMoves ? 0 : maxMoves - dist[v];
            ans += Math.min(w, fromU + fromV);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        int[][] edges = new int[m][3];
        System.out.println("Enter edges as u v subdividedCount:");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        System.out.print("Enter maxMoves: ");
        int maxMoves = sc.nextInt();

        int result = reachableNodes(edges, n, maxMoves);
        System.out.println("Maximum reachable nodes: " + result);
    }
}
