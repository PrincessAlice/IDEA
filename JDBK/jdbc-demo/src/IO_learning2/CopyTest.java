package IO_learning2;

import java.io.File;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest {
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            try {
                File files = new File("D:\\比特笔记\\JAVAWeb\\JavaWeb课件.zip");
                fis = new FileInputStream(files);
                File dest = new File("D:\\比特笔记\\JAVAWeb\\1.zip");
                fos = new FileOutputStream(dest);
                byte[] bytes = new byte[1024];
                int len = 0;
                while((len=fis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                }
            } finally {
                if(fis!=null){
                    fis.close();
                }
                if(fos!=null){
                    fos.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
