import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            currentMax += num;

            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
            }

            if (currentMax < 0) {
                currentMax = 0;
            }
        }

        System.out.println(maxSoFar);

        sc.close();
    }
}