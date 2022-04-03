package study.zuo_algorithm.class14;

import java.util.HashSet;

/**
 * @author wnx
 */
public class Code01_Light {
    public static int minLight(String road) {
        char[] str = road.toCharArray();

        int i = 0, lightNum = 0;
        while (i < str.length) {
            if (str[i] == 'X') {
                i++;
            } else {
                lightNum++;
                if (i + 1 == str.length) {
                    break;
                } else {
                    if (str[i + 1] == 'X') {
                        i += 2;
                    } else {
                        i += 3;
                    }
                }
            }
        }
        return lightNum;
    }
}
