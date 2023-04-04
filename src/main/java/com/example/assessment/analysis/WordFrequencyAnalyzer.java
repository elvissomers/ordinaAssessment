package main.java.com.example.assessment.analysis;

import main.java.com.example.assessment.domains.WordFrequency;

public interface WordFrequencyAnalyzer {
    int calculateHighestFrequency(String text);
    int calculateFrequencyForWord (String text, String word);
    WordFrequency[] calculateMostFrequentNWords (String text, int n);
}