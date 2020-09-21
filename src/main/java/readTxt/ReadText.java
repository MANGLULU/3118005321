package readTxt;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadText {

    /**
     * 读取txt文件
     * @param filePath 需要读取的文件名
     * @return
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
}
