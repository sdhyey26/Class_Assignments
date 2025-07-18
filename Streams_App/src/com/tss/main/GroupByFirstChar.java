package com.tss.main;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByFirstChar {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");

        Map<Character, List<String>> grouped = words.stream()
            .collect(Collectors.groupingBy((word) -> word.charAt(0)));

        grouped.forEach((ch, list) -> 
            System.out.println(ch + " = " + list));
    }
}
