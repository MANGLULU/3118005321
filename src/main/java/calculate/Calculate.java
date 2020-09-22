package calculate;

import java.util.*;

public class Calculate {

    private HashMap<String, Integer> map  = null;

    /**
     * 获得查重字典
     * @param originalText 原文
     * @param contrastText 对比文
     */
    public void getDict(List<String> originalText, List<String> contrastText) {
        map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();
        list.addAll(originalText);
        list.addAll(contrastText);
        for(int i = 0,j = 0; i < list.size(); i++) {
            if(map.containsKey(list.get(i))) {
                continue;
            }
            map.put(list.get(i),j);
            j++;
        }
    }

    /**
     * 计算词频
     * @param text 需要查词频的文章list集合
     * @return 返回词频数组
     */
    public int[] getWordFrequency(List<String> text) {
        int word_frequency[] = new int[map.size()];
        for(int i = 0; i < text.size(); i++) {
            if(map.containsKey(text.get(i))) {
                word_frequency[map.get(text.get(i))] += 1;
            }
        }
        return word_frequency;
    }

    /**
     * 计算查重率
     * @param originalText 原文
     * @param contrastText 需要查重的文章
     * @return 返回查重率
     */
    public Double getCosine(List<String> originalText,List<String> contrastText) {
        int[] wordFrequency1 = getWordFrequency(originalText);
        int[] wordFrequency2 = getWordFrequency(contrastText);
        int sum = 0;
        int square_numbers1 = 0;
        int square_numbers2 = 0;
        Double result = 0.0;
        for (int i = 0; i < wordFrequency1.length; i++) {
            sum += wordFrequency1[i] * wordFrequency2[i];
            square_numbers1 += wordFrequency1[i] * wordFrequency1[i];
            square_numbers2 += wordFrequency2[i] * wordFrequency2[i];
        }
        result = sum / (Math.sqrt(square_numbers1) * Math.sqrt(square_numbers2));
        return result;
    }
}
