import calculate.Calculate;
import org.junit.Test;
import readTxt.ReadText;
import tokenizer.Tokenizer;

import java.io.IOException;
import java.util.List;

public class test {
    @Test
    public void test1() throws IOException {
        ReadText readText = new ReadText();
        String s1 = readText.FileToString("testfiles//orig.txt");
        String s2 = readText.FileToString("testfiles//orig_0.8_dis_15.txt");
        List<String> tokenizer1 = new Tokenizer().getTokenizer(s1);
        List<String> tokenizer2 = new Tokenizer().getTokenizer(s2);
//        List<String> tokenizer1 = new Tokenizer().getTokenizer("这只皮鞋号码大了。那只号码合适。");
//        List<String> tokenizer2 = new Tokenizer().getTokenizer("这只皮鞋号码不小，那只更合适。");
        Calculate calculate = new Calculate();
        calculate.getDict(tokenizer1,tokenizer2);
        Double cosine = calculate.getCosine(tokenizer1, tokenizer2);
        System.out.println(String.format("%.2f",cosine));
    }

}
