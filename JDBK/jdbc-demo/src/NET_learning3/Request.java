package NET_learning3;

import java.util.HashMap;
import java.util.Map;

//请求
public class Request {
    //请求方法
    private String method;
    //请求
    private String url;
    //请求
    private String version;
    //请求头
    private Map<String,String>headers = new HashMap<>();
    //请求参数
    private Map<String,String> parameters = new HashMap<>();
    //添加请求头
    public void addHeader(String key,String value){
        headers.put(key,value);
    }
    //获取某个请求头
    public String getHeader(String key){
        return  headers.get(key);
    }
    //解析请求参数
    public void parseParameters(String parameters){
        String[] ps = parameters.split("&");
        for(String p : ps){

        }
    }
    //添加请求参数
    public void addParameter(String key,String value){
        parameters.put(key,value);
    }
    //获取请求参数
    public String getParameters(String key){
        return parameters.get(key);
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
