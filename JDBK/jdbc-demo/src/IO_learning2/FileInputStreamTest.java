package IO_learning2;

import org.junit.Test;

import java.io.*;

public class FileInputStreamTest {
    @Test
    public void test1(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File file = new File("F:\\idea代码\\jdbc-demo\\test1.txt");
            System.out.println(file.exists());
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes))!= -1){
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File file = new File("F:\\idea代码\\jdbc-demo\\test1.txt");
            System.out.println(file.exists());
            FileReader fr = new FileReader(file);
            char[] chars = new char[1024];
            int len = 0;
            while ((len = fr.read(chars))!= -1){
                String s = new String(chars,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test4(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File file = new File("F:\\idea代码\\jdbc-demo\\test1.txt");
            System.out.println(file.exists());
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s;
           while((s=br.readLine())!=null){
               System.out.println(s);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File file = new File("F:\\idea代码\\jdbc-demo\\test1.txt");
            System.out.println(file.exists());
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            //手动换行\n
            bw.write("1=123\n");
            bw.write("唐诗");
            //换行写入
            bw.newLine();
            bw.write("宋词");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
