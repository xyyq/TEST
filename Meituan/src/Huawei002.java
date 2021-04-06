import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class Huawei002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s =br.readLine().split(" ");
        int n = s.length;
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
            sum += nums[i];
        }

        int[] dp =new int[1<<n];

        for (int i = 0; i < 1<<n; i++) {
            int x = 0;
            for (int j = 0; j < n; j++) {

                if (((1<<j)&i)!=0){
                    x += nums[j];
                }
            }
           dp[i] = x;
        }
        for (int i = (1<<n) -2 ; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (dp[i] == dp[j]){
                   int t = i;
                   int o = j;
                   while (t!=0 ){
                        if (t % 2 != 0 && o % 2 != 0) {
                          break;
                        }
                        t = t/2;
                        o = o/2;
                    }
                   if (t==0 && o==0){
                       System.out.println(dp[i]);
                       return;
                   }
                }
            }
        }
        System.out.println(0);
     }
}
