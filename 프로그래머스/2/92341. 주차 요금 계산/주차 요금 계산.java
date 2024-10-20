import java.util.*;

class Solution {
    
    class Car implements Comparable<Car>{
        int in;
        int out;
        int parking;
        int fee;
        int number;
        
        Car(int hour, int min, int number) {
            in = 60 * hour + min;
            out = -1;
            parking = 0;
            fee = 0;
            this.number = number;
        }
        
        void init(int hour, int min) {
            in = 60 * hour + min;
            out = -1;
        }
        
        void cal(int hour, int min) {
            this.out = hour * 60 + min;
            parking += out - in;
        }
        
        @Override
        public int compareTo(Car o) {
            return this.number - o.number;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> map = new HashMap<>();
        for (String record : records) {
            int hour = Integer.parseInt(record.substring(0, 2));
            int min = Integer.parseInt(record.substring(3, 5));
            String number = record.substring(6, 10);
            String type = record.substring(11, record.length());
            if (type.equals("IN")) {
                if (!map.containsKey(number)) {
                    map.put(number, new Car(hour, min, Integer.parseInt(number)));
                } else {
                    map.get(number).init(hour, min);
                }
            } else {
                map.get(number).cal(hour, min);
            }
        }
        
        List<Car> list = new ArrayList<>();
        for (String key : map.keySet()) {
            Car car = map.get(key);
            if (car.out == -1) {
                car.cal(23, 59);
            }
            if (car.parking <= fees[0]) {
                car.fee = fees[1];
            } else {
                int result = fees[1];
                int over = car.parking - fees[0];
                if ((over % fees[2] == 0)) {
                    result += (over / fees[2]) * fees[3];
                } else {
                    result += ((over / fees[2]) + 1) * fees[3];
                }
                car.fee = result;
            }
            list.add(car);
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).fee;
        }
        return answer;
    }
}