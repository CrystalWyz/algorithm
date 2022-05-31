package leetcode;

import java.util.HashMap;
import java.util.Map;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> psMap = new HashMap<>();
        Map<String, Character> spMap = new HashMap<>();

        String[] split = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (split.length != chars.length) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            if (psMap.containsKey(chars[i])) {
                if (!psMap.get(chars[i]).equals(split[i])) {
                    return false;
                }
            } else if (spMap.containsKey(split[i])){
                if (!spMap.get(split[i]).equals(chars[i])) {
                    return false;
                }
            } else {
                psMap.put(chars[i], split[i]);
                spMap.put(split[i], chars[i]);
            }
        }

        return true;
    }
}