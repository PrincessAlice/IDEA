package frank.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import frank.model.Article;
import frank.model.Result;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONUtil {

    public static String DATE_PATTERN;

    //反序列化操作
    public static <T> T deserialize(String json,Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        //
        mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
        try{
            return mapper.readValues(json,clazz);
        }catch(Exception e){

        }

    }

    public static boolean serialize(Result result) {

    }

    public static Article deserialize(InputStream is, Class<Article> articleClass) {
    }
}
