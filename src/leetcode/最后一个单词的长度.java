package leetcode;

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");
        return split[split.length - 1].length();
    }
}