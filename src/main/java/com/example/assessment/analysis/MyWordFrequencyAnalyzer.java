package main.java.com.example.assessment.analysis;

import main.java.com.example.assessment.domains.MyWordFrequency;
import main.java.com.example.assessment.domains.WordFrequency;

import java.util.*;

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
        WordFrequency[] sortedWords = getSortedWords(wordMap);

        return sortedWords[0].getFrequency();
    }
    public int calculateFrequencyForWord (String text, String word){
        HashMap<String, Integer> wordMap = getWordMap(text);

        return wordMap.get(word);
    }
    public WordFrequency[] calculateMostFrequentNWords (String text, int n){
        HashMap<String, Integer> wordMap = getWordMap(text);
        WordFrequency[] sortedWords = getSortedWords(wordMap);

        return Arrays.copyOfRange(sortedWords, 0, n);
    }



}
