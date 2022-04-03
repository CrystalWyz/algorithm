package study.zuo_algorithm.class15;

import java.util.*;

public class Code02_NumberOfIslands {

    public int numIslands(char[][] grid) {
        int landNum = 0;
        if (grid == null) {
            return landNum;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    landNum++;
                    infect(grid, i, j);
                }
            }
        }

        return landNum;
    }

    private void infect(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }


    public static int numIslands1(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        Dot[][] dots = new Dot[row][col];
        List<Dot> dotList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1') {
                    dots[i][j] = new Dot();
                    dotList.add(dots[i][j]);
                }
            }
        }
        UnionFind1<Dot> uf = new UnionFind1<>(dotList);
        for (int j = 1; j < col; j++) {
            if (board[0][j - 1] == '1' && board[0][j] == '1') {
                uf.union(dots[0][j - 1], dots[0][j]);
            }
        }
        for (int i = 1; i < row; i++) {
            if (board[i - 1][0] == '1' && board[i][0] == '1') {
                uf.union(dots[i - 1][0], dots[i][0]);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == '1') {
                    if (board[i][j - 1] == '1') {
                        uf.union(dots[i][j - 1], dots[i][j]);
                    }
                    if (board[i - 1][j] == '1') {
                        uf.union(dots[i - 1][j], dots[i][j]);
                    }
                }
            }
        }
        return uf.sets();
    }

    public static class Dot {

    }

    private static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    private static class UnionFind1<V> {
        Map<V, Node<V>> nodes;
        Map<Node<V>, Node<V>> parents;
        Map<Node<V>, Integer> size;

        public UnionFind1(List<V> values) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.size = new HashMap<>();

            for (V value : values) {
                Node<V> vNode = new Node<>(value);
                this.nodes.put(value, vNode);
                this.parents.put(vNode, vNode);
                this.size.put(vNode, 1);
            }
        }

        public Node<V> findFather(Node<V> value) {
            Stack<Node<V>> stack = new Stack<>();

            while (value != parents.get(value)) {
                stack.push(value);
                value = parents.get(value);
            }

            while (!stack.isEmpty()) {
                parents.put(stack.pop(), value);
            }

            return value;
        }

        public void union(V a, V b) {
            Node<V> aFather = findFather(nodes.get(a));
            Node<V> bFather = findFather(nodes.get(b));

            if (aFather != bFather) {
                int aSize = size.get(aFather);
                int bSize = size.get(bFather);
                Node<V> big = aSize >= bSize ? aFather : bFather;
                Node<V> small = big == aFather ? bFather : aFather;

                parents.put(small, big);
                size.put(big, aSize + bSize);
                size.remove(small);
            }
        }

        public int sets() {
            return size.size();
        }
    }

    public static int numIslands2(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        UnionFind2 uf = new UnionFind2(board);
        for (int j = 1; j < col; j++) {
            if (board[0][j - 1] == '1' && board[0][j] == '1') {
                uf.union(0, j - 1, 0, j);
            }
        }
        for (int i = 1; i < row; i++) {
            if (board[i - 1][0] == '1' && board[i][0] == '1') {
                uf.union(i - 1, 0, i, 0);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == '1') {
                    if (board[i][j - 1] == '1') {
                        uf.union(i, j - 1, i, j);
                    }
                    if (board[i - 1][j] == '1') {
                        uf.union(i - 1, j, i, j);
                    }
                }
            }
        }
        return uf.sets();
    }

    public static class UnionFind2 {
        private int[] parent;
        private int[] size;
        private int[] help;
        private int col;
        private int sets;

        public UnionFind2(char[][] board) {
            col = board[0].length;
            sets = 0;
            int row = board.length;
            int len = row * col;
            parent = new int[len];
            size = new int[len];
            help = new int[len];
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (board[r][c] == '1') {
                        int i = index(r, c);
                        parent[i] = i;
                        size[i] = 1;
                        sets++;
                    }
                }
            }
        }

        // (r,c) -> i
        private int index(int r, int c) {
            return r * col + c;
        }

        // 原始位置 -> 下标
        private int find(int i) {
            int hi = 0;
            while (i != parent[i]) {
                help[hi++] = i;
                i = parent[i];
            }
            for (hi--; hi >= 0; hi--) {
                parent[help[hi]] = i;
            }
            return i;
        }

        public void union(int r1, int c1, int r2, int c2) {
            int i1 = index(r1, c1);
            int i2 = index(r2, c2);
            int f1 = find(i1);
            int f2 = find(i2);
            if (f1 != f2) {
                if (size[f1] >= size[f2]) {
                    size[f1] += size[f2];
                    parent[f2] = f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                sets--;
            }
        }

        public int sets() {
            return sets;
        }

    }
}
