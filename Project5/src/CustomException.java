package Exception异常;

public class CustomException extends Exception{
    public CustomException(){
    }

    public CustomException(String message){
        super(message);
    }

    public CustomException(Throwable cause){
        super(cause);
    }

    public CustomException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
