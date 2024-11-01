import java.util.*;

class Solution {
    
    class File implements Comparable<File>{
        int idx;
        String head;
        String number;
        String tail;
        
        File(String head, String number, String tail, int idx) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(File o) {
            if (this.head.equalsIgnoreCase(o.head)) {
                if (Integer.parseInt(this.number) == Integer.parseInt(o.number)) {
                    return this.idx - o.idx;
                }
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }
            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }
    
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            boolean isTail = false;
            
            for (int j = 0; j < file.length(); j++) {
                char c = file.charAt(j);
                if ('0' <= c && c <= '9') {
                    number.append(c);
                    isTail = true;
                } else {
                    if (!isTail) head.append(c);
                    else {
                        tail.append(file.substring(j));
                        break;
                    }
                }
                
            }
            
            list.add(new File(head.toString(), number.toString(), tail.toString(), i));
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            File file = list.get(i);
            answer[i] = file.head + file.number + file.tail;
        }
        return answer;
    }
}