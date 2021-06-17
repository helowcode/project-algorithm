package cn.cpf.commons.utils.common;

import org.apache.commons.lang3.StringUtils;

public class CpfUtilString {


	/**
	 *  ���ֽ�����ȡ�ַ���
	 * @param str 
	 * @param number ����
	 * @return
	 */
	public static String[] splitBylength(String str, int number){
		if (number < 1){
			throw new RuntimeException("err");
		}
		int strlen = str.length();
		int index = strlen % number;
		int arrlen = strlen / number;
		if (index != 0){
			arrlen ++ ;
		} else {
			index = number;
		}
		String[] arr = new String[arrlen];
		arr[0] = str.substring(0, index);
		for (int i = 1; i < arrlen; i ++){
			arr[i] = str.substring(index + number * (i - 1), index + number * i);
		}
		return arr;
	}
	
	
}
