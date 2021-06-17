package cn.cpf.commons.utils.algorithm.number;

public class CpfUtilInt
{

    /**
     * ��ȡһ�����ĳ���������
     * eg : 28�ĳ���  1,2,4,7,14,28 ����6��
     * @param number (> 1)
     * @return
     */
    public static int getDivisorsCount(int number) {
        if (number <= 1) {
            throw new RuntimeException("err");
        }
        // ������2��( 1 & ������)
        int count = 2;
        Double sqrt = Math.sqrt(number);
        int sqrtInt = sqrt.intValue();
        if (sqrtInt == sqrt) {
            count --;
        }
        for (int i = 2; i <= sqrtInt; i++) {
            if (number % i == 0) {
            	// ������ �� ���� i & number/i
                count += 2;
            }
        }
        return count;
    }
    
    /**
     * ��ȡһ�����ĳ����ĺ�(������������)
     * eg : 28�ĳ���  {1,2,4,7,14} ���Ϊ 28
     * @param number
     * @return
     */
    public static int getSumOfDivisors(int number) {
        if (number <= 1) {
            throw new RuntimeException("err");
        }
        // ������������� 1
        int sum = 1;
        Double sqrt = Math.sqrt(number);
        int sqrtInt = sqrt.intValue();
        if (sqrtInt == sqrt) {
        	sum = sum - sqrtInt;
        }
        for (int i = 2; i <= sqrtInt; i++) {
            if (number % i == 0) {
            	sum = sum + i + number / i; 
            }
        }
        return sum;
    }

    
//    /**
//     * ��ȡһ����������Ϊ�����ĳ���������(������������)
//     * eg : 28���ʳ���  {7} �� 1 ��
//     * @param number
//     * @return
//     */
//    public static int getPrimeDivisorCount(int number) {
//        if (number <= 1) {
//            throw new RuntimeException("err");
//        }
//        // ������������� 1
//        int count = 0;
//        Double sqrt = Math.sqrt(number);
//        int sqrtInt = sqrt.intValue();
//        for (int i = 2,j; i <= sqrtInt; i++) {
//            if (number % i == 0) {
//            	if (PrimeNumber.isprime(i)) {
//            		count ++;
//            	}
//            	j = number / i; 
//            	if (i != j && PrimeNumber.isprime(j)) {
//            		count ++;
//            	}
//            }
//        }
//        return count;
//    }

    
    /**
     * ��ȡһ����������Ϊ�����ĳ���������(������������)
     * eg : 28���ʳ���  {7} �� 1 ��
     * @param number
     * @return
     */
    public static int getPrimeDivisorCount(int number) {
        if (number <= 1) {
            throw new RuntimeException("err");
        }
        // ������������� 1
        Double sqrt = Math.sqrt(number);
        int sqrtInt = sqrt.intValue();
        int cnt = 0;
        int n = number;
        boolean isprime = true;
        for (int i = 2; i <= sqrtInt; i++) {
            if (n % i == 0) {
            	if (PrimeNumber.isprime(i)) {
            		cnt ++;
            		while (n % i == 0) {
						n = n / i;
//						System.out.print(i + "\t");
					}
                    sqrt = Math.sqrt(n);
                    sqrtInt = sqrt.intValue();
                    continue;
            	} else {
            		return -1;
            	}
            }
        }
        if (n == 1){
//            System.out.println();
            return cnt;
        }
//        System.out.println(n);
        return cnt + 1;
    }

}
