package cn.cpf.commons.utils.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class CPFIOUtil
{
    
    public static String getOulerFilePath(String filename){
        URL resource = CPFIOUtil.class.getResource("/");
        return resource.getPath() + "/ouler/" + filename;
    }

    public static String readFile(String filepath){
        String str = null;
        File file = new File(filepath);
        try {
            if (!file.exists()){
                throw new FileNotFoundException(filepath);
            }
            @SuppressWarnings("resource")
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            str = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }
    
    public static void readFileByLines(String fileName) {   
        File file = new File(fileName);   
        BufferedReader reader = null;   
        try {   
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");   
            reader = new BufferedReader(new FileReader(file));   
            String tempString = null;   
            int line = 1;   
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����   
            while ((tempString = reader.readLine()) != null) {   
                // ��ʾ�к�   
                System.out.println("line " + line + ": " + tempString);   
                line++;   
            }   
            reader.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        } finally {   
            if (reader != null) {   
                try {   
                    reader.close();   
                } catch (IOException e1) {   
                }   
            }   
        }   
    }   
    
}
