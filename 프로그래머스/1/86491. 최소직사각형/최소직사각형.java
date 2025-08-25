class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for(int[] s : sizes) {
            int width = Math.max(s[0], s[1]);
            int height = Math.min(s[0], s[1]);
            maxW = Math.max(maxW, width);
            maxH = Math.max(maxH, height);
        }
        
        return maxW * maxH;
    }
}