import java.util.*;

public class NaivePatternMatching {

    /*
     * Returns all starting indices where pattern occurs in text.
     *
     * Example:
     * text    = "AABAACAADAABAABA"
     * pattern = "AABA"
     * output  = [0, 9, 12]
     */
    public static List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();

        if (pattern.length() == 0 || pattern.length() > text.length()) {
            return positions;
        }

        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            if (j == m) {
                positions.add(i);
            }
        }

        return positions;
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";

        System.out.println(search(text, pattern));
    }
}
