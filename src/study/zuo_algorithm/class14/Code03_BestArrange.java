package study.zuo_algorithm.class14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wnx
 */
public class Code03_BestArrange {

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(Program[] programs) {
        Arrays.sort(programs, Comparator.comparingInt(o -> o.end));
        int timeLine = 0;
        int result = 0;
        // 依次遍历每一个会议，结束时间早的会议先遍历
        for (Program program : programs) {
            if (timeLine <= program.start) {
                result++;
                timeLine = program.end;
            }
        }
        return result;
    }
}
