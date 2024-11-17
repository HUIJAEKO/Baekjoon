class Solution {
    public String solution(int[] food) {
        StringBuilder br = new StringBuilder();
        
        int[] foodCount = new int[food.length];
        for(int i=1; i<food.length; i++){
            foodCount[i] = food[i] / 2;
        }
        
        for(int i=1; i<foodCount.length; i++){
            br.append(String.valueOf(i).repeat(foodCount[i]));
        }
        
        br.append(0);
            
        for(int i=foodCount.length-1; i>=1; i--){
            br.append(String.valueOf(i).repeat(foodCount[i]));
        }    
        
        return br.toString();
    }
}