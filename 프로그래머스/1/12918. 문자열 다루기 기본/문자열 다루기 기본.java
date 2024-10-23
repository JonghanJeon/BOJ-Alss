class Solution {
    public boolean solution(String s) {
        if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        }
        String str = s.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'a';
            if (0 <= num && num <= 25) {
                return false;
            }
        }
        return true;
    }
}