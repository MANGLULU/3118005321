package calculate;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import java.util.ArrayList;
import java.util.List;

/**
 * 分词
 */
public class Tokenizer {

    /**
     * 对文本进行分词
     * @param context 文本内容
     * @return 返回分词后的List集合
     */
    public List<String> getTokenizer(String context) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < context.length();) {
            if(i+2 > context.length()){
                break;
            }
            list.add(context.substring(i, i+2));
            i += 2;
        }
        return list;


//        JiebaSegmenter segmenter = new JiebaSegmenter();
//        List<String> list = new ArrayList<>();
//        for(SegToken token : segmenter.process(context, JiebaSegmenter.SegMode.INDEX)){
//            list.add(token.word);
//        }
//        return list;
    }
}
