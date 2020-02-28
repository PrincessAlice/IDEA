package app;

import util.PinyinUtil;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class FileMeta {

    private String name;
    private String path;
    private Boolean isDirectory;
    private Long size;
    private Timestamp lastModified;

    private String pinyin;
    private String pinyinFirst;

    //通过文件设置属性
    public FileMeta(File file){
        this(file.getName(),file.getParent(),file.length(),new Date((file.isDirectory())));
    }

    //通过数据获取的数据设置FileMeta
    public FileMeta(String name,String path,Long size,Boolean isDirectory,Timestamp lastModified,Date date){
        this.name = name;
        this.path = path;
        this.size = size;
        this.lastModified = lastModified;
        if(PinyinUtil.containsChinese(name)){
            String[] pinyins = PinyinUtil.get(name);
            pinyin = pinyins[0];
            pinyinFirst = pinyins[1];

        }

    }

    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null||getClass()!= o.getClass())return false;
        FileMeta meta = (FileMeta) o;
        return Objects.equals(name,meta.name)&&
                Objects.equals(path,meta.path)&&
                Objects.equals(isDirectory,meta.isDirectory);
    }


    @Override
    public int hashCode(){
        return Objects.hash(name,path,isDirectory);
    }

    public Boolean getDirectory(){
        return isDirectory;
    }

}
