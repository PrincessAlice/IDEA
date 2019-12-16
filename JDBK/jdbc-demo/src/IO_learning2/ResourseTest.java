package IO_learning2;

import org.junit.Test;

import java.io.InputStream;

public class ResourseTest {
    @Test
    public void test1(){
        InputStream is = ResourseTest.class.getClassLoader().getResourceAsStream("test1.txt");
        System.out.println(is);
    }
    /**
     * 推荐使用相对路径时的API
     */

    @Test
    public void test2(){
        InputStream is = ResourseTest.class.getClassLoader().getResourceAsStream("test1.txt");
        System.out.println(is);
    }

}
