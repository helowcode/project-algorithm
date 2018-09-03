package util.common;

import java.util.Objects;

public class CpfUtilArr {

	public static void main(String[] args) {
		int[] arr2 = { 8,  2, 22, 97, 38, 15,  0, 40,  0, 75,  4,  5,  7, 78, 52, 12, 50, 77, 91,  8};
		int ii = getMaxProductInArr(arr2, 4);
		System.out.println(ii);
	}
	
	/**
	 * ��ȡһά����������number���������˻�
	 * 
	 * @param arr
	 * @param number
	 * @return
	 * throw new RuntimeException (arr.length < number)
	 */
	public static int getMaxProductInArr(int[] arr, int number){
		int len = arr.length;
		if (len < number){
			throw new RuntimeException("arr̫С!");
		}
		int[] num = new int[number];
		int i = 0;
		for (; i < number; i++) {
			num[i] = arr[i];
		}
		int product = getProductInArr(num);
		int cur = 0;
		int tmpProdect;
		for (; i < len; i ++) {
			num[cur] = arr[i];
			tmpProdect = getProductInArr(num);
			if (tmpProdect > product) {
				product = tmpProdect;
			}
			cur ++;
			cur = cur % number;
		}
		return product;
	}
	
    /**
     * ��ȡarr�����еĳ˻�
     * @param arr
     * @return
     */
    public static int getProductInArr(int[] arr) {
    	Objects.requireNonNull(arr);
    	int product = 1;
		for (int len = arr.length, i = 0; i < len; i ++) {
			product *= arr[i];
		}
		return product;
	}
    
    public static int getSumInArr(int[] arr) {
    	Objects.requireNonNull(arr);
    	int sum = 0;
		for (int len = arr.length, i = 0; i < len; i ++) {
			sum += arr[i];
		}
		return sum;
	}

    public static int getMaxValueInArr(int[] arr) {
        Objects.requireNonNull(arr);
        int max = 0;
        for (int len = arr.length, i = 0; i < len; i ++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
	
	/**
	 * ת�þ���, ��������Ƿ��ξ���
	 * @param matrix
	 */
	public static void transposeMatrix(Object[][] matrix){
		if (matrix.length != matrix[0].length){
			throw new RuntimeException("matrix.length != matrix[0].length");
		}
		int length = matrix.length;
		Object tmp;
		for (int i = 0; i < length; i ++){
			for (int j = 0; j < i; j++){
				tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
	
	public static void transposeMatrix(int[][] matrix){
		if (matrix.length != matrix[0].length){
			throw new RuntimeException("matrix.length != matrix[0].length");
		}
		int length = matrix.length;
		int tmp;
		for (int i = 0; i < length; i ++){
			for (int j = 0; j < i; j++){
				tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
	
	
	/**
	 * ��һ���ַ�������ת��Ϊint����
	 * @param strarr
	 * @return
	 */
	public static int[] transStrArrToIntArr(String[] strarr){
		int len = strarr.length;
		int[] intarr = new int[len];
		for (int i = 0; i < len; i++){
			intarr[i] = Integer.parseInt(strarr[i]);
		}
		return intarr;
	}
	
	
}
