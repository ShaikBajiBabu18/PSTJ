import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Function<Integer, Integer> transform = salary -> (int)(salary * 1.10);

        for (int i = 0; i < n; i++) {
            int salary = sc.nextInt();
            System.out.print(transform.apply(salary));

            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}