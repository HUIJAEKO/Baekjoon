class Solution {
    public int solution(int number, int limit, int power) {
        int totalIronWeight = 0;

        for (int i = 1; i <= number; i++) {
            int divisorCount = countDivisors(i);

            if (divisorCount > limit) {
                totalIronWeight += power;
            } else {
                totalIronWeight += divisorCount;
            }
        }

        return totalIronWeight;
    }

    private static int countDivisors(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++; 
                if (i != num / i) {
                    count++;
                }
            }
        }
        return count;
    }
}