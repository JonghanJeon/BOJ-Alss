import java.util.*;

class Solution {
    
    Map<String, String> dic = new HashMap<>();
    
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        StringTokenizer st;
        for (String order : record) {
            st = new StringTokenizer(order);
            String type = st.nextToken();
            String id = st.nextToken();
            
            if (type.equals("Enter") || type.equals("Change")) {
                String nickname = st.nextToken();
                dic.put(id, nickname);
            }
        }
        
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            String type = st.nextToken();
            String id = st.nextToken();
            if (type.equals("Enter")) {
                answer.add(dic.get(id) + "님이 들어왔습니다.");
            } else if (type.equals("Leave")) {
                answer.add(dic.get(id) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}