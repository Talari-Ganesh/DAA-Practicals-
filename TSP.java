import java.util.Scanner;

public class TSP {

    static int n;
    static int[][] cost;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    static void tsp(int city, int count, int totalCost) {

        if (count == n) {
            if (cost[city][0] != 0) {
                minCost = Math.min(minCost, totalCost + cost[city][0]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i] && cost[city][i] != 0) {

                visited[i] = true;

                tsp(i, count + 1, totalCost + cost[city][i]);

                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        cost = new int[n][n];
        visited = new boolean[n];

        System.out.println("Enter cost matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        visited[0] = true;

        tsp(0, 1, 0);

        if (minCost == Integer.MAX_VALUE) {
            System.out.println("No possible tour.");
        } else {
            System.out.println("Minimum travelling cost: " + minCost);
        }

        sc.close();
    }
}
