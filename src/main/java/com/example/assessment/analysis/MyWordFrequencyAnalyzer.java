package main.java.com.example.assessment.analysis;

import main.java.com.example.assessment.domains.WordFrequency;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyWordFrequencyAnalyzer implements WordFrequencyAnalyzer{

    public HashMap<String, Integer> getWordMap(String text){
        String lowerCaseText = text.toLowerCase();
        String[] allWords = lowerCaseText.split("[^a-z]+");

        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

        for (String word : allWords){
            if (wordMap.containsKey(word)) {
                Integer currentCount = wordMap.get(word);
                wordMap.replace(word, currentCount + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
    }

    public WordFrequency[] getSortedWords(HashMap<String, Integer> unsortedMap){
        WordFrequency[] sortedWords = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(entry -> new MyWordFrequency(entry.getKey(), entry.getValue()))
                .toArray(WordFrequency[]::new);

        return sortedWords;
    }

    public int calculateHighestFrequency(String text){
        HashMap<String, Integer> wordMap = getWordMap(text);

    }
    public int calculateFrequencyForWord (String text, String word){
        HashMap<String, Integer> wordMap = getWordMap(text);

        return wordMap.get(word);
    }
    public WordFrequency[] calculateMostFrequentNWords (String text, int n);

}
