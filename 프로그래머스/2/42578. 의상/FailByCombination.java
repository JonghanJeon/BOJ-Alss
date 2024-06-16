import java.util.HashMap;

/**
 * 조합을 사용하여 문제 풀이시 n = 30 일경우 시간 초과가 발생하여 조합으로 풀이할 수 없음.
 * 이에 따라 각 분류별 개수에 "미착용" 이라는 것을 하나씩 전부 추가하여 조합의 경우의 수를 계산한 뒤,
 * 모든 분류가 "미착용" 일 때 만 제외해 주면 단 하나라도 의상을 착용하고 있는 것이기 때문에
 * 위와 같은 방식으로 풀이해야함.
 */
public class FailByCombination {
    class Solution {

        public int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        public int solution(String[][] clothes) {
            for (String[] row : clothes) {
                if (!map.containsKey(row[1])) {
                    map.put(row[1], 1);
                    continue;
                }
                map.put(row[1], map.get(row[1]) + 1);
            }
            String[] arr = map.keySet().toArray(new String[0]);
            boolean[] visited = new boolean[arr.length];
            for (int i = 1; i <= arr.length; i++) {
                combination(arr, visited, 0, arr.length, i);
            }
            return answer;
        }

        public void combination(String[] arr, boolean[] visited, int start, int n, int r) {
            if (r == 0) {
                calculate(arr, visited, n);
                return;
            }

            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }

        public void calculate(String[] arr, boolean[] visited, int n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {

                    if (sum == 0) {
                        sum += map.get(arr[i]);
                        continue;
                    }
                    sum *= map.get(arr[i]);
                }
            }
            answer += sum;
        }
    }
}
