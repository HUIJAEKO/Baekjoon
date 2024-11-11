class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int score = 0;
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                score += index(name, photo[i][j], yearning);
            }
            answer[i] = score;
            score = 0;
        }
        return answer;
    }
    
    public static int index(String[] arr, String name, int[] yearning){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(name)){
                sum += yearning[i];
            }
        }
        return sum;
    }
}