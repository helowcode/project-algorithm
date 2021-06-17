package cn.cpf.commons.utils.common;

public class CpfUtilDate {

	/**
	 * �ж�һ���Ƿ�Ϊ���� : �ܱ�400���� �����ǲ��ܱ�100�������ܱ�4���������������
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
	}

}
