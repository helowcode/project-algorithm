package cn.cpf.exercise.ouler;

import java.util.Arrays;

/**
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 *
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 * analysis : x 和 6x 的位数是一样的。对于一个5位数来说，x最大不会超过16666
 *
 */
public class Q52 {

    public static void main(String[] args) {

        ss : for (int digits_num = 3; digits_num < 7; digits_num++) {
            int n = (int) Math.pow(10, digits_num);
            int limit = n * 10 / 6;
            for (; n <= limit ; n++) {
                char[] chars = String.valueOf(n).toCharArray();
                Arrays.sort(chars);
                for (int i = 2; i <= 6; i++) {
                    int x = n * i;
                    char[] charsN = String.valueOf(x).toCharArray();
                    Arrays.sort(charsN);
                    if (!compareChars(chars, charsN)) {
                        break;
                    }
                    if (i == 6) {
                        for (int j = 1; j <= 6; j++) {
                            System.out.println(n * j);
                        }
                        break ss;
                    }
                }
            }
        }

        System.out.printf("end");

    }

    public static boolean compareChars(char[] chars1, char[] chars2) {
        if (chars1 == null || chars2 == null) {
            return false;
        }
        int len = chars1.length;
        if (chars2.length != len) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

}
