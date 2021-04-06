
/*
* 两数相除

给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
*/

public class Huawei003 {
    public static void main(String[] args)  {
        System.out.println(div(-9,3));
    }
    public static  int posDiv(int dividend, int divisor){
        int res = 0;
        while (dividend >= divisor){
            dividend -= divisor;
            res++;
        }
        return res;
    }
    public static int div(int dividend, int divisor){
       if (dividend< 0 && divisor > 0){
           return -posDiv(-dividend,divisor);
       }else if (dividend > 0 && divisor < 0){
           return -posDiv(dividend,-divisor);
       }else if (dividend > 0 && divisor > 0){
           return posDiv(dividend,divisor);
       }else  {
           return posDiv(-dividend,-divisor);
       }
    }
}
