import java.util.*;

class Solution {
    static int sortIndex = -1;
    
    public ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> arr = new ArrayList<>();
        
        int extIndex = 0;
        switch (ext) {
            case "code": extIndex = 0; break;
            case "date": extIndex = 1; break;
            case "maximum": extIndex = 2; break;
            case "remain": extIndex = 3; break;
        }

        switch (sort_by) {
            case "code": sortIndex = 0; break;
            case "date": sortIndex = 1; break;
            case "maximum": sortIndex = 2; break;
            case "remain": sortIndex = 3; break;
        }

        for (int[] row : data) {
            if (row[extIndex] < val_ext) {
                arr.add(row);
            }
        }

        arr.sort((o1, o2) -> Integer.compare(o1[sortIndex], o2[sortIndex]));

        return arr;
    }
}
