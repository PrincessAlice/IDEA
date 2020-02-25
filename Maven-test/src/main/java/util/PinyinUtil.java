package util;
import net.sourceforge.pinyin4j.format.HanyuPinyinFormat;

public class PinyinUtil {
    private static final HanyuPinOutpuFormat FORMAT = new HanyuPinOutputFormat();

    static{
        FORMAT.setCaseType(HanyuPinyinCaseType.LOW  )
    }

    /* *
    * 通过文件名来获取全拼+拼音首字母
    * 中华人民共和国---->zhonghuarenmingongheguo/zhrmghg
    * @param name 文件名
    * @return 拼音全品字符串+拼音首字母字符串  数组
    * */

    public static String[] get(String name){
        //PinyinHelper.toHanyuPinyinStringArray(c,format);

    }

    public static boolean containsChinese(String name) {
        return name.matches(".*");
    }
}
