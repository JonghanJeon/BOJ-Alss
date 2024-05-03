import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        int[] arr = new int[col];
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (land[r][c] == 0) {
                    continue;
                }
                
                Queue<int[]> que = new ArrayDeque<>();
                Set<Integer> cols = new HashSet<>();
                que.add(new int[]{r, c});
                cols.add(c);
                land[r][c] = 0;
                int cnt = 1;
                
                while (!que.isEmpty()) {
                    int[] tmp = que.poll();
                    int a = tmp[0];
                    int b = tmp[1];
                    
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if ((i * j) != 0) {
                                continue;
                            }
                            
                            int newRow = a + i;
                            int newCol = b + j;
                            
                            if (!(0 <= newRow && newRow < row && 0 <= newCol && newCol < col)) {
                                continue;
                            }
                            
                            if (land[newRow][newCol] == 0) {
                                continue;
                            }
                            
                            cnt++;
                            land[newRow][newCol] = 0;
                            que.add(new int[]{newRow, newCol});
                            cols.add(newCol);
                            
                        }
                    }    
                }
                
                for (int idx : cols) {
                    arr[idx] += cnt;
                }
                
            }
        }
        
        Arrays.sort(arr);
        return arr[col - 1];
    }
}