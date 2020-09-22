import calculate.Calculate;
import check.Check;
import exception.NullFileException;
import org.junit.Test;
import calculate.Tokenizer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class test {
    @Test
    public void test1() throws IOException {
        File f = new File("testfiles");
        String[] files = f.list();
        int i = 1;
        for(String file: files) {
                File Content = new File("testfiles//" + file);
                if(Content.length() == 3) {  //UTF-8空文本字节为3
                    try{
                        throw new NullFileException("这是空文本！");
                    }catch(NullFileException e){
                        e.printStackTrace();
                    }
            } else {
                    new Check().getAnswer("testfiles/orig.txt", "testfiles/" + file, "answer/answer" + i + ".txt");
                }
            i++;
        }
    }
}
