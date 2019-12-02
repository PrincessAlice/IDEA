package IO_learning1;

import org.junit.Test;
import thread_learning4.FileOperator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileTest {
    @Test
    public void test1(){
        File file = new File("F:\\idea代码\\jdbc-demo\\jdbc-demo.iml");
        System.out.println(file.exists());
        //创建文件不建议创建到相对路径下，建议创建到绝对路径下

        File d = new File("d:/");
        //返回的是file类型的数组
        for(File f:d.listFiles()){
            System.out.println(f.getPath());
        }
    }

    //实现一个方法，把自己某个目录下的所有子文件夹和子文件获取并打印
    @Test
    public  void test2(){
        File dir = new File("D:\\比特笔记\\JAVAWeb");
        List<File> files = listFiles(dir);
       // files.stream().forEach(System.out::println); //直接获取每一行数据并打印出来（file打印）
        //file类型的数据 获取所有并打印
        files.stream().forEach((f)->{
            System.out.println(f.getPath());
        });
    }

    //递归
    public List<File> listFiles(File file){
        //用数组返回
        List<File> list = new ArrayList<>();
        list.add(file);
        //System.out.println(file.getPath());
        //判断是否为文件夹
        if(file.isDirectory()){
            for (File f : file.listFiles()) {
                //list.add(f); 这里添加就会重复添加文件夹
                if (f.isDirectory()) {
                    //fileFiles(文件夹)
                    listFiles(f);
                }else {
                    //文件未添加，需添加
                    list.add(f);
                   // System.out.println(f.getPath());
                }
            }
        }
        return list;
    }


}
