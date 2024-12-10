class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        for(int i=0; i<=9; i++){
            if(!find(numbers, i)){
               sum+=i;
            }
        }
        return sum;
    }
    
    static boolean find(int[] num, int n){
        for(int i=0; i<num.length; i++){
            if(num[i] == n){
                return true;
            }
        }
        return false;
    }
}