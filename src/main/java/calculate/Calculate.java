package calculate;

import java.util.*;

public class Calculate {
    private HashMap<String, Integer> map  = null;
    public void getDict(List<String> list1, List<String> list2) {
//        HashMap<String, Integer> map = new HashMap<>();
        map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();
        list.addAll(list1);
        list.addAll(list2);
        for(int i = 0,j = 0; i < list.size(); i++) {
            if(map.containsKey(list.get(i))) {
                continue;
            }
            map.put(list.get(i),j);
            j++;
        }
//        int word_frequency[] = new int[map.size()];
//        for(int i = 0; i < list1.size(); i++) {
//            if(map.containsKey(list1.get(i))) {
//                word_frequency[map.get(list1.get(i))] += 1;
//            }
//        }
    }

    public int[] getWordFrequency(List<String> list) {
        int word_frequency[] = new int[map.size()];
        for(int i = 0; i < list.size(); i++) {
            if(map.containsKey(list.get(i))) {
                word_frequency[map.get(list.get(i))] += 1;
            }
        }
        return word_frequency;
    }

    public Double getCosine(List<String> list1,List<String> list2) {
        int[] wordFrequency1 = getWordFrequency(list1);
        int[] wordFrequency2 = getWordFrequency(list2);
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
