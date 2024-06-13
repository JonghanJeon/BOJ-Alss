import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int rowStart = (int) (left / n) + 1;
        int colStart = (int) (left % n) + 1;

        int rowEnd = (int) (right / n) + 1;
        int colEnd = (int) (right % n) + 1;

        int[] answer = new int[(int) (right - left + 1)];
        int idx = 0;

        if (rowStart == rowEnd) {
            for (int col = colStart; col <= colEnd; col++) {
                if (col <= rowStart) {
                    answer[idx++] = rowStart;
                } else {
                    answer[idx++] = col;
                }
            }
        } else {
            for (int col = colStart; col <= n; col++) {
                if (col <= rowStart) {
                    answer[idx++] = rowStart;
                } else {
                    answer[idx++] = col;
                }
            }

            for (int row = rowStart + 1; row <= rowEnd; row++) {

                if (row == rowEnd) {
                    for (int col = 1; col <= colEnd; col ++) {
                        if (col <= rowEnd) {
                            answer[idx++] = rowEnd;
                        } else {
                            answer[idx++] = col;
                        }
                    }
                } else {
                    for (int col = 1; col <= n; col++) {
                        if (col <= row) {
                            answer[idx++] = row;
                        } else {
                            answer[idx++] = col;
                        }
                    }
                }

            }
        }
        return answer;
    }
}