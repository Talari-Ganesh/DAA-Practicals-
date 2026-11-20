
import java.util.*;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (source destination weight):");

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u][v] = w;
            graph[v][u] = w;
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int total = 0;

        System.out.println("Minimum Spanning Tree:");

        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int x = -1, y = -1;

            for (int u = 0; u < n; u++) {
                if (visited[u]) {
                    for (int v = 0; v < n; v++) {
                        if (!visited[v] && graph[u][v] > 0
                                && graph[u][v] < min) {
                            min = graph[u][v];
                            x = u;
                            y = v;
                        }
                    }
                }
            }

            if (x == -1) {
                System.out.println("Graph is disconnected!");
                return;
            }

            System.out.println(x + " - " + y + " : " + min);
            visited[y] = true;
            total += min;
        }

        System.out.println("Total Minimum Cost: " + total);
        sc.close();
    }
}
