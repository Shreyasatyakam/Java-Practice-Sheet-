import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class HttpClientDemo {
    public static void main(String[] args) {
        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Define request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .build();

        try {
            // Send request and get response as String
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print status and body
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body:");
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
