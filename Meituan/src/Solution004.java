
import java.util.Arrays;
import java.util.Scanner;

public class Solution004 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int j = 0; j < N; j++) {
               nums[j] = sc.nextInt();
            }
            Arrays.sort(nums);
            if(N == 1 || N == 2){
                ret[i] = nums[N-1];
                continue;
            }
            int res = 0;
            boolean flag = false;
            if (N % 2 == 0){
                flag = true;
            }

            int count = 2;
            int basic = nums[0] + nums[1] * 2;
            for (int j = 3; j < N; j += 2) {
                   if (nums[count] < basic){
                       res += nums[j] + nums[count];
                       count++;
                   }else {
                       res += nums[j] + basic;
                   }
            }
            while (count != 2){
                int tmp = 2;
                for (int j = 3; j < count; j += 2) {
                    if (nums[tmp] < basic){
                        res += nums[j] + nums[tmp];
                        tmp++;
                    }else {
                        res += nums[j] + basic;
                    }
                }
                count  = tmp;
            }
            if (!flag){
                res += nums[0] +nums[1] + nums[N - 1];
            }else {
                res += nums[1];
            }
            ret[i] = res;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ret[i]);
        }
    }
}
