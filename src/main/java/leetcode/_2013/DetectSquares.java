package leetcode._2013;

import java.util.HashMap;

class DetectSquares {

    HashMap<Node, Integer> map = new HashMap();

    class Node {
        int x, y;
        Node(int... point) {
            x = point[0];
            y = point[1];
        }
        public boolean equals(Object obj) {
            Node o = (Node)obj;
            return this.x == o.x && this.y == o.y;
        }
        public int hashCode() {
            return x * y;
        }
    }

    public DetectSquares() {

    }

    public void add(int[] point) {
        Node n = new Node(point);
        map.put(n, map.getOrDefault(n, 0) + 1);
    }

    public int count(int[] point) {
        int cnt = 0;
        for(var e : map.entrySet()) {
            for(int i = 0, sign = -1; e.getKey().y == point[1] && e.getKey().x != point[0] && i < 2; i++, sign *= -1) {
                int k = e.getValue();
                int len = Math.abs(point[0] - e.getKey().x);
                k *= map.getOrDefault(new Node(e.getKey().x, point[1] + sign * len), 0);
                k *= map.getOrDefault(new Node(point[0], point[1] + sign * len), 0);
                cnt += k;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        DetectSquares ds = new DetectSquares();
        ds.add(new int[]{3, 10});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{3, 2});
        System.out.println(ds.count(new int[]{11, 10}));
        System.out.println(ds.count(new int[]{14, 8}));
        ds.add(new int[]{11, 2});
        System.out.println(ds.count(new int[]{11, 10}));
    }
}

class DetectSquares1 {

    HashMap<Node, Integer> map = new HashMap();

    class Node {
        int x, y;
        Node(int... point) {
            x = point[0];
            y = point[1];
        }
        public boolean equals(Object obj) {
            Node o = (Node)obj;
            return this.x == o.x && this.y == o.y;
        }
        public int hashCode() {
            return x * y;
        }
    }

    public void add(int[] point) {
        Node n = new Node(point);
        map.put(n, map.getOrDefault(n, 0) + 1);
    }

    public int count(int[] point) {
        int cnt = 0;
        for(var e : map.entrySet()) {
            if(e.getKey().y != point[1] && Math.abs(e.getKey().y - point[1]) == Math.abs(e.getKey().x - point[0])) {
                int k = e.getValue();
                k *= map.getOrDefault(new Node(e.getKey().x, point[1]), 0);
                k *= map.getOrDefault(new Node(point[0], e.getKey().y), 0);
                cnt += k;
            }
        }
        return cnt;
    }
}