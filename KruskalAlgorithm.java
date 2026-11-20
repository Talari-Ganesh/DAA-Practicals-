
import java.util.*;

public class KruskalAlgorithm {

    static int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent, parent[x]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter the edges: ");
        int e = sc.nextInt();
        int[][] edges = new int[e][3];
        System.out.println("Enter edges:");

        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int total = 0;
        int count = 0;
        System.out.println("Minimum Spanning Tree:");

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int rootU = find(parent, u);
            int rootV = find(parent, v);
            if (rootU != rootV) {
                System.out.println(u + " - " + v + " : " + w);

                parent[rootU] = rootV;
                total += w;
                count++;
                if (count == n - 1)
                    break;
            }
        }
        if (count == n - 1) {
            System.out.println("Total Minimum Cost: " + total);
        } else {
            System.out.println("Graph is disconnected!");
        }

        sc.close();
    }
}