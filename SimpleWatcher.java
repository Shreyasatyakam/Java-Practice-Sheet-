import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class SimpleWatcher {
    public static void main(String[] args) throws Exception {
        // Directory to watch (change path if needed)
        Path dir = Paths.get("testdir");

        // Create WatchService
        WatchService watcher = FileSystems.getDefault().newWatchService();

        // Register directory for create, delete, modify
        dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        System.out.println("Watching directory: " + dir);

        while (true) {
            // Wait for events
            WatchKey key = watcher.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.kind() + " -> " + event.context());
            }

            // Reset key to receive further events
            key.reset();
        }
    }
}
