package cn.cpf.commons.utils.algorithm.number;

import cn.cpf.commons.utils.algorithm.api.IRegularNumber;

public class PalindromeNumber implements IRegularNumber
{

    @Override
    public boolean isRegular(int number) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * �ж�����Ĳ����Ƿ��ǻ�����
     * 
     * @param number
     * @return
     */
    public static boolean isPalindrome(int number) {
        return isPalindrome(Integer.valueOf(number).toString());
    }

    /**
     * �ж�����Ĳ����Ƿ��ǻ�����
     * 
     * @param number
     * @return
     */
    public static boolean isPalindrome(String number) {
        char[] intchar = number.toCharArray();
        int length = intchar.length;
        for (int i = length / 2 - 1; i >= 0; i-- ){
            if (intchar[i] != intchar[length - 1 - i]){
                return false;
            }
        }
        return true;
    }

}
