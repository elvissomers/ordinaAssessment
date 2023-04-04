package test;

import main.java.com.example.assessment.analysis.MyWordFrequencyAnalyzer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyWordFrequencyAnalyzerTest {

    @Test
    public void ordinaExampleCalculateHighestFrequency(){
        MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
        String testString = "The sun shines over the lake";
        assertEquals(2, myWordFrequencyAnalyzer.calculateHighestFrequency(testString));
    }

    @Test
    public void ordinaExampleCalculateFrequencyForSun(){
        MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
        String testString = "The sun shines over the lake";
        assertEquals(1, myWordFrequencyAnalyzer.calculateFrequencyForWord(testString,"sun"));
    }

    @Test
    public void ordinaExampleCalculateFrequencyForThe(){
        MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
        String testString = "The sun shines over the lake";
        assertEquals(2, myWordFrequencyAnalyzer.calculateFrequencyForWord(testString,"the"));
    }

    @Test
    public void ordinaExampleCalculateFrequencyForTheAllCap(){
        MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
        String testString = "The sun shines over the lake";
        assertEquals(2, myWordFrequencyAnalyzer.calculateFrequencyForWord(testString,"THE"));
    }

    @Test
    public void ordinaExampleCalculateFrequencyForSunSpongeCase(){
        MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
        String testString = "The sun shines over the lake";
        assertEquals(1, myWordFrequencyAnalyzer.calculateFrequencyForWord(testString,"sUn"));
    }

    @Test
    public void ordinaExampleCalculateMostFrequentOneWords(){
        MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
        String testString = "The sun shines over the lake";
        int wordAmount = 1;

        assertEquals("the",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testString,1)[0].getWord());
        assertEquals(2,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testString,1)[0].getFrequency());
    }

    @Test
    public void ordinaExampleCalculateMostFrequentThreeWords(){
        MyWordFrequencyAnalyzer myWordFrequencyAnalyzer = new MyWordFrequencyAnalyzer();
        String testString = "The sun shines over the lake";
        int wordAmount = 3;

        assertEquals("the",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testString,wordAmount)[0].getWord());
        assertEquals(2,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testString,wordAmount)[0].getFrequency());

        assertEquals("lake",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testString,wordAmount)[1].getWord());
        assertEquals(1,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testString,wordAmount)[1].getFrequency());

        assertEquals("over",myWordFrequencyAnalyzer.calculateMostFrequentNWords(testString,wordAmount)[2].getWord());
        assertEquals(1,myWordFrequencyAnalyzer.calculateMostFrequentNWords(testString,wordAmount)[2].getFrequency());
    }
}