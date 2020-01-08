package thread_learning4;

import java.io.File;

public class FileOperator {

    private volatile File file;  //保证读的安全（可见性）
    public  void read(){
        //String = file.read
    }

    public synchronized void write(){   //保证写的安全
        //file.write(String)
    }

    public static void main(String[] args) {
        FileOperator operator = new FileOperator();
        for(int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    operator.write();
                }
            }).start();
        }

        for(int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    operator.read();
                }
            }).start();
        }

    }
}
