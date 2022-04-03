package study.zuo_algorithm.class13;

import java.util.ArrayList;
import java.util.List;

public class Code04_MaxHappy {

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }
    }

    public static int maxHappy(Employee boss) {
        if (boss == null) {
            return 0;
        }
        return process(boss, false);
    }

    private static int process(Employee employee, boolean up) {
        // 上级来
        if (up) {
            int ans = 0;
            for (Employee next : employee.nexts) {
                ans += process(next, false);
            }
            return ans;
        } else {
            // 上级不来
            int curCome = employee.happy;
            int curUncome = 0;
            for (Employee next : employee.nexts) {
                curCome += process(next, true);
                curUncome += process(next, false);
            }
            return Math.max(curCome, curUncome);
        }
    }
}
