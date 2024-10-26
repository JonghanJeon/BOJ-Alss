import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int number;
        int dist;
        Set<Integer> link;
        
        Node(int number) {
            this.number = number;
            dist = 0;
            link = new HashSet<>();
        }
        
        @Override
        public int compareTo(Node o) {
            return o.dist - this.dist;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new Node(i));
        }
        
        for (int[] arr : edge) {
            int number = arr[0];
            int next = arr[1];
            nodes.get(number).link.add(next);
            nodes.get(next).link.add(number);
        }
        
        Queue<Node> que = new LinkedList<>();
        que.add(nodes.get(1));
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            
            if (cur.link.size() == 0) continue;
            
            for (Integer number : cur.link) {
                if (visited[number]) continue;
                
                visited[number] = true;
                Node next = nodes.get(number);
                next.dist = cur.dist + 1;
                que.add(next);
            }
        }
        
        Collections.sort(nodes);
        
        int max = nodes.get(0).dist;
        
        for (Node x : nodes) {
            if (x.dist == max) answer++;
            else break;
        }
        
        return answer;
    }
}