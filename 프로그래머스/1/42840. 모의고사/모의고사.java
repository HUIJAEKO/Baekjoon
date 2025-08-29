import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) {
                score[0]++;
            }
            if (answers[i] == b[i % b.length]) {
                score[1]++;    
            }
            if (answers[i] == c[i % c.length]) {
                score[2]++;    
            }
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<score.length; i++) {
            if(score[i] == max) {
                arr.add(i+1);
            }
        }          
       
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }
}