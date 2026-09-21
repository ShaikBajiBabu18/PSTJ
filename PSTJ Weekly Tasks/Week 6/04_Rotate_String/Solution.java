class Solution {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // Every rotation of s appears as a substring of s + s.
        return (s + s).contains(goal);
    }
}
