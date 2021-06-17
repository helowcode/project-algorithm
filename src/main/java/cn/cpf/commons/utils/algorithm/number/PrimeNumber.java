package cn.cpf.commons.utils.algorithm.number;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class PrimeNumber
{

    /**
     * 判断一个数是否是质数(简单优化)
     *
     * @param n
     * @return
     */
    public static boolean isPrime1(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isprime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) { // 2, 3
            return true;
        }
        int remainder = n % 6;
        if (remainder != 1 && remainder != 5) {
            return false;
        }
        if (n % 3 == 0) {
            return false;
        }
        for (int i = 5, j = 7, sqrt = (int) Math.sqrt(n); i <= sqrt || j <= sqrt; i += 6, j += 6) {
            if (n % i == 0 || n % j == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 输出一定范围内的质数
     */
    @Test
    public void main() {
        int number = 10000;
        boolean[] arr = new boolean[number];
        for (int i = 2; i < number; i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i << 1; j < number; j = j + i) {
                arr[j] = true;
            }
        }
        for (int i = 2; i < number; i++) {
            if (!arr[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static long t1;
    private static long t2;
    @Before
    public void before() {
        t1 = System.currentTimeMillis();
    }
    @After
    public void after() {
        t2 = System.currentTimeMillis();
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t2 - t1);
    }


    // 给定8个线程, 要求最快输出质数
    public static void main(String[] args){
        Runnable runnable = new primeRunnable();
        for (int i = 0; i < 8; i++) {
            new Thread(runnable).start();
        }
    }


    private static class primeRunnable implements Runnable {

        private static final int len = 100000;
        private static final boolean[] arr = new boolean[len];
        private static AtomicInteger curDispose = new AtomicInteger(2);
        private static AtomicInteger curPrint = new AtomicInteger(2);

        @Override
        public void run() {
            for (int i = curDispose.getAndIncrement(); i < len; i = curDispose.getAndIncrement()) {
                if (arr[i]) {
                    continue;
                }
                for (int j = i << 1; j < len; j += i) {
                    arr[j] = true;
                }
            }
            for (int i = curPrint.getAndIncrement(); i < len; i = curPrint.getAndIncrement()) {
                if (!arr[i]) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
