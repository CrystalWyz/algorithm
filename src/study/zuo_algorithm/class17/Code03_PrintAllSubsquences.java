package study.zuo_algorithm.class17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wnx
 */
public class Code03_PrintAllSubsquences {

    public static List<String> subs(String s) {
        char[] chars = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(chars, 0, ans, path);
        return ans;
    }

    private static void process1(char[] chars, int i, List<String> ans, String path) {
        if (i == chars.length) {
            ans.add(path);
        }
        process1(chars, i + 1, ans, path);
        process1(chars, i + 1, ans, path + chars[i]);
    }

    public static Iterable<String> subsNoRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<>();
        process2(str, 0, set, path);
        return set;
    }

    public static void process2(char[] str, int index, HashSet<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }
        process2(str, index + 1, set, path);
        process2(str, index + 1, set, path + str[index]);
    }
}
