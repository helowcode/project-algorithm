package cn.cpf.exercise.ouler;

import cn.cpf.commons.utils.algorithm.number.PrimeNumber;

public class Q6 {

    private static char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        for (int n = 0; n < 1000_000; n ++)   {
            if (computer(n)) {
                System.err.println(n);
                break;
            }
        }

    }

    public static boolean judge012(int n){
        while(n > 0){
            if (n % 10  <=2 ){
                return true;
            }
            n /= 10;
        }
        return false;
    }

    public static boolean computer(int n){
        if (! judge012(n)){
            return false;
        }
        String str = String.valueOf(n);
        for (int i = 0; i < 3; i++) {
            if (str.contains(String.valueOf(chars[i]))){
                if (swapComp(str, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean swapComp(String str, int i){
        char ch = chars[i];
        int min = 2 - i;
        while (min >= 0) {
            String s = str.replace(ch, chars[i++]);
            if (PrimeNumber.isprime(Integer.parseInt(s))) {
                if (i > 9) {
                    return true;
                }
            } else {
                min --;
            }
        }
        return false;
    }


}