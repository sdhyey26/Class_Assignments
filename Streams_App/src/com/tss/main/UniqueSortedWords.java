package com.tss.main;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class UniqueSortedWords {
    public static void main(String[] args) {
        Set<String> sentences = new HashSet<>();
        sentences.add("Hello world");
        sentences.add("hello Java");
        sentences.add("Stream API");

        Set<String> uniqueWords = sentences.stream()
            .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
            .map(String::toLowerCase)
            .distinct() 
            .sorted()
            .collect(Collectors.toSet()); 

        System.out.println(uniqueWords);
    }
}
