package org.learning.dsa.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords692 {
    public static void main(String[] args) {

    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> data = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String word : words){
            data.put(word, data.getOrDefault(word, 0) + 1);
        }

        for(String word : data.keySet()){
            if(data.getOrDefault(word,0) == k){
                result.add(word);
            }
        }

        return result;
    }
}
