import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();

        for (String record : records) {
            String[] arr = record.split(" ");

            int time = convert(arr[0]);
            String car = arr[1];
            String type = arr[2];

            if (type.equals("IN")) {
                inTime.put(car, time);
            } else {
                int diff = time - inTime.get(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + diff);
                inTime.remove(car);
            }
        }

        for (String car : inTime.keySet()) {
            int diff = convert("23:59") - inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + diff);
        }

        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            int time = totalTime.get(cars.get(i));
            answer[i] = calculateFee(time, fees);
        }

        return answer;
    }

    private int convert(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private int calculateFee(int time, int[] fees) {

        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) return baseFee;
        return baseFee + (int)Math.ceil((time - baseTime) / (double)unitTime) * unitFee;
    }
}