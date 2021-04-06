import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TengXun001 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        boolean[]  mark = new boolean[n];
        int res = n;
        boolean flag = false;
        int x= 0;
        while (flag || x==0){
            flag = false;
            x=1;
            int m1 = 0;
            for (int i = 0; i < n; i++) {
                if (!mark[i]){
                    m1 = i;
                    break;
                }
            }
            while (m1 < n && m1 != -1){
                int m2 = Next(mark,m1);
                if (m2 != -1){
                    if (s.charAt(m2) + s.charAt(m1) == 10 + '0'+'0'){
                        res -= 2;
                        flag = true;
                        mark[m1] = true;
                        mark[m2] = true;
                        m1 = Next(mark,m2);
                    }else {
                        m1 = m2;
                    }
                }else {
                    break;
                }
            }
        }
        System.out.println(res);
    }
    public  static  int Next(boolean[] mark, int start){
        for (int i = start + 1; i < mark.length; i++) {
            if (!mark[i]){
                return i;
            }
        }
        return -1;
    }
}
