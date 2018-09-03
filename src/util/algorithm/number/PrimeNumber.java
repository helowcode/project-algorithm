package util.algorithm.number;

public class PrimeNumber
{

    /**
     * �ж�����n�Ƿ�Ϊ����
     * 
     * @param n
     * @return ��Ϊ������return true����֮return false
     */
    public static boolean isprime(int n) {
        if (n <= 1) { // �ų�С��2����
            return false;
        }
        if (n <= 3) { // 2, 3
            return true;
        }
        // ����3�������������� (6n +- 1)
        int remainder = n % 6;
        if (remainder != 1 && remainder != 5) {
            return false;
        }
        if (n % 3 == 0) {
            return false;
        }
        // ��5, 7��ʼ, ÿ�μ�6
        for (int i = 5, j = 7, sqrt = (int) Math.sqrt(n); i <= sqrt || j <= sqrt; i += 6, j += 6) {
            if (n % i == 0 || n % j == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * �ж�����n�Ƿ�Ϊ����
     * 
     * @param n
     * @return ��Ϊ������return true����֮return false
     */
    public static boolean isprime2(int n) {
        if (n <= 1) { // �ų�С��2����
            return false;
        }
        if (n <= 3) { // 2, 3
            return true;
        }
        // ����3�������������� (6n +- 1)
        int remainder = n % 6;
        if (remainder != 1 && remainder != 5) {
            return false;
        }
        if (n % 3 == 0) {
            return false;
        }
        // ��5, 7��ʼ, ÿ�μ�6
        for (int i = 5, j = 7, sqrt = (int) Math.sqrt(n); j <= sqrt || i <= sqrt; i += 6, j += 6) {
            if (n % i == 0 || n % j == 0) {
                return false;
            }
        }
        return true;
    }
    
}
