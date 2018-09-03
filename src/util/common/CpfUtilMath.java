package util.common;

import java.math.BigInteger;

public class CpfUtilMath {

    /**
     * ��� from �� to �����еĳ˻�
     * 
     * @param from
     * @param to
     * @return
     */
    public static BigInteger getProductFromTo(int from, int to) {
		if (from > to){
			int tmp = from;
			from = to;
			to = tmp;
		}
		BigInteger product = new BigInteger(Integer.valueOf(from).toString());
		for (int i = from + 1; i <= to; i ++) {
			product = product.multiply(new BigInteger(Integer.valueOf(i).toString()));
		}
		return product;
	}
    
    public static BigInteger factorial(int n){
        if (n==0){
            return new BigInteger("1");
        }
    	return getProductFromTo(1, n);
    }
    
    
    /**
     * ���ʼ��� : �� up ����ͬ�¼����� down ���¼�����,���ж�������� A(up down)
     * 
     * @param up
     * @param down
     * @return
     */
    public static BigInteger probability_A(int up, int down){
    	if (up >= down) {
    		throw new RuntimeException("C��ͷ�����������ҪС���������");
    	}
    	BigInteger result = getProductFromTo(down - up + 1 , down);
    	return result;
    }
    
    /**
     * ���ʼ��� : �� up ����ͬ�¼����� down ���¼�����,���ж�������� C(up down)
     * 
     * @param up
     * @param down
     * @return
     */
    public static BigInteger probability_C(int up, int down){
    	BigInteger upp = probability_A(up, down);
    	BigInteger dop = factorial(up);
    	BigInteger[] result = upp.divideAndRemainder(dop);
    	if (result[1].intValue() != 0){
    		throw new RuntimeException("this situation can never happen!");
    	}
    	return result[0];
    }
    
}
