import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        String boom = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(String str1 : str){
            sb.append(str1);

            if(sb.length() >= boom.length()
                    && sb.substring(sb.length() - boom.length()).equals(boom)){
               sb.delete(sb.length() - boom.length(), sb.length());
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }
    }
}
