package study.zuo_algorithm.class16;

import java.util.*;

/**
 * @author wnx
 */
public class Code04_Kruskal {

    public static class UnionFind {
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void  makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node node) {
            Stack<Node> stack = new Stack<>();
            while (node != fatherMap.get(node)) {
                stack.push(node);
                node = fatherMap.get(node);
            }

            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), node);
            }

            return node;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if (aFather != bFather) {
                int aSize = sizeMap.get(a);
                int bSize = sizeMap.get(b);
                if (aSize <= bSize) {
                    fatherMap.put(aFather, bFather);
                    sizeMap.put(bFather, aSize + bSize);
                    sizeMap.remove(aFather);
                } else {
                    fatherMap.put(bFather, aFather);
                    sizeMap.put(aFather, aSize + bSize);
                    sizeMap.remove(bFather);
                }
            }
        }

        public static class EdgeComparator implements Comparator<Edge> {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        }

        public static Set<Edge> kruskalMST(Graph graph) {
            UnionFind unionFind = new UnionFind();
            unionFind.makeSets(graph.nodes.values());
            // 从小的边到大的边，依次弹出，小根堆！
            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
            for (Edge edge : graph.edges) { // M 条边
                priorityQueue.add(edge);  // O(logM)
            }
            Set<Edge> result = new HashSet<>();
            while (!priorityQueue.isEmpty()) { // M 条边
                Edge edge = priorityQueue.poll(); // O(logM)
                if (!unionFind.isSameSet(edge.from, edge.to)) { // O(1)
                    result.add(edge);
                    unionFind.union(edge.from, edge.to);
                }
            }
            return result;
        }
    }
}
