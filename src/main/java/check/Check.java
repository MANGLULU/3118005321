package check;

import calculate.Calculate;
import calculate.Text;
import calculate.Tokenizer;

import java.io.IOException;
import java.util.List;

public class Check {

    public static void getAnswer(String path1, String path2 , String answerPath) throws IOException {
        Text text = new Text();
        String s1 = text.FileToString(path1);
        String s2 = text.FileToString(path2);
        List<String> tokenizer1 = new Tokenizer().getTokenizer(s1);
        List<String> tokenizer2 = new Tokenizer().getTokenizer(s2);
        Calculate calculate = new Calculate();
        calculate.getDict(tokenizer1,tokenizer2);
        Double cosine = calculate.getCosine(tokenizer1, tokenizer2);
        String str = new String();
        str += "FirstPath:" + path1 + "\n";
        str += "secondPath:" + path2 + "\n";
        str += "answer:" + String.format("%.2f",cosine);
//        buffer.append("FirstPath:" + path1);
//        buffer.append("secondPath:" + path2);
//        buffer.append("answer:" + String.format("%.2f",cosine));
        System.out.println(str);
        text.SaveStringToFile(str, answerPath);
    }
}
