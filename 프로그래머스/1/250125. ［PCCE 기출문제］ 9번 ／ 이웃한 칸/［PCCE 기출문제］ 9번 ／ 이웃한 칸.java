class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int size = board.length;
        
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for(int i=0; i<4; i++){
            int y = h + dh[i];
            int x = w + dw[i];
            
            if(y>=0 && y<size && x>=0 && x<size){
                if(board[y][x].equals(board[h][w])){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}