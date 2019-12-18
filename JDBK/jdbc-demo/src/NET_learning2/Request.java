package NET_learning2;

import java.util.HashMap;
import java.util.Map;

public class Request {
    //请求方法
    private String method;
    //请求路径
    private String url;
    //请求的http的版本
    private String version;
    //请求头
    private Map<String,String> headers = new HashMap<>();

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }

    //根据请求头获取值
    public void addHeader(String key,String value){
        headers.put(key,value);
    }

    //根据
    public String getHeader(String key){
        return headers.get(key);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
