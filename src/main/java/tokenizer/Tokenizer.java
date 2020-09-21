package tokenizer;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.ArrayList;
import java.util.List;

/**
 * 分词
 */
public class Tokenizer {

    private JiebaSegmenter segmenter = new JiebaSegmenter();

    /**
     * 对文本进行分词
     * @param context 文本内容
     * @return 返回分词后的List集合
     */
    public List<String> getTokenizer(String context) {
        List<SegToken> process = segmenter.process(context, JiebaSegmenter.SegMode.INDEX);
        List<String> list = new ArrayList<>();
        for (SegToken segToken : process) {
            list.add(segToken.word);
        }
        return list;
    }
}
