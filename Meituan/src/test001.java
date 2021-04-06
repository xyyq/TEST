import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test001 {
    public static void main(String[] args) throws IOException {
        int left = 0;
        int right = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =br.readLine();
        int n = s.length();
        int res = 0;
        while (left < n){
            char c = s.charAt(left);
            while (right < n && s.charAt(right) == c){
                right++;
            }
            int l = right - left;
            res += l * (l + 1) / 2;
            left = right;
        }
        System.out.println( res);
    }
}
