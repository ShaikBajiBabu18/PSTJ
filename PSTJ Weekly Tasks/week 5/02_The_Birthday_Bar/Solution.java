import java.io.*;
import java.util.*;

public class Solution {

    public static int birthday(List<Integer> s, int d, int m) {
        if (m > s.size()) {
            return 0;
        }

        int sum = 0;
        int count = 0;

        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        if (sum == d) {
            count++;
        }

        for (int i = m; i < s.size(); i++) {
            sum += s.get(i);
            sum -= s.get(i - m);

            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        List<Integer> s = new ArrayList<>();

        for (String part : parts) {
            s.add(Integer.parseInt(part));
        }

        String[] dm = br.readLine().trim().split("\\s+");
        int d = Integer.parseInt(dm[0]);
        int m = Integer.parseInt(dm[1]);

        System.out.println(birthday(s, d, m));
    }
}
