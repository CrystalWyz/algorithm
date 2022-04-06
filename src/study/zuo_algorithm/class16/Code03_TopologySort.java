package study.zuo_algorithm.class16;

import java.util.*;

/**
 * @author wnx
 */
public class Code03_TopologySort {

    public static List<Node> sortedTopology(Graph graph) {
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.offer(node);
            }
        }

        List<Node> res = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            res.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.offer(next);
                }
            }
        }

        return res;
    }
}
