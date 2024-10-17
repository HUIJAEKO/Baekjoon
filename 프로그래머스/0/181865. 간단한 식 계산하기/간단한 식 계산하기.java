class Solution {
    public int solution(String binomial) {
        String[] str = binomial.split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[2]);
        String op = str[1];
        switch(op){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
        }
        return 0;
    }
}