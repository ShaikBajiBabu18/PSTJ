import java.util.*;

class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                answer.add(word);
            }
        }

        return answer;
    }

    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (wordToPattern.containsKey(w) && wordToPattern.get(w) != p) {
                return false;
            }

            if (patternToWord.containsKey(p) && patternToWord.get(p) != w) {
                return false;
            }

            wordToPattern.put(w, p);
            patternToWord.put(p, w);
        }

        return true;
    }
}
