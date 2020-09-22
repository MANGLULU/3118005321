package calculate;


import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Text {

    /**
     * 读取txt文件
     * @param filePath 需要读取的文件名
     * @return 返回去掉符号的字符串
     * @throws IOException
     */
    public String FileToString(String filePath) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line=reader.readLine())!=null){
            builder.append(line);
        }
        reader.close();
        return builder.toString();
    }

    /***
     * 保存文件
     * @param text 保存的文本
     * @param filePath 文件路径
     * @throws IOException 文件输出异常
     */
    public void SaveStringToFile(String text,String filePath) throws IOException{
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }
//
//    /**
//     *
//     * @param str 需要处理的字符串
//     * @return 返回去除符号的字符串
//     */
//    public String RemoveLebel(String str) {
//        str = Jsoup.clean(str, Whitelist.none());
//        str = StringUtils.lowerCase(str);
//        String[] strings = { " ", "\n", "\r", "\t", "\\r", "\\n", "\\t", "&nbsp;", ",", "。" };
//        for(String index: strings) {
//            str = str.replaceAll(index, "");
//        }
//        return str;
//    }
}
