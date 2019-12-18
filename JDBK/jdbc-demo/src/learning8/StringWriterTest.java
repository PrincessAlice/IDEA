package learning8;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringWriterTest {

    @Test
    public void test(){
        try {
            throw new RuntimeException("出错了");
        } catch (RuntimeException e) {
       //     e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            System.out.println(pw);
            e.printStackTrace(pw);
            System.out.println(sw.toString());
        }

    }
}
