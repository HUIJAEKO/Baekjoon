import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String myString) {
        char[] ch = myString.toCharArray();
        
        for(int i=0; i<ch.length; i++){
            if(ch[i]>'A' && ch[i]<='Z'){
                ch[i]=(char)(ch[i]+32);
            }else if(ch[i] == 'a'){
                ch[i] = 'A';
            }
        }
        return new String(ch);
    }
}

