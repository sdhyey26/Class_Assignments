package com.tss.main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountByFirstChar {
	public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");

        Map<Character, Long> countMap = words.stream()
            .collect(Collectors.groupingBy(
                word -> word.charAt(0),     
                Collectors.counting()       
            ));

        countMap.forEach((ch, count) -> 
            System.out.println(ch + " = " + count));
    }
}
