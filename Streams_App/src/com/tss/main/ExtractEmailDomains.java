package com.tss.main;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExtractEmailDomains {
	public static void main(String[] args) {
        List<String> emails = Arrays.asList("dhyey@gmail.com", "harshad@yahoo.com", "deep@gmail.com");

        Set<String> domains = emails.stream()
            .map(email -> email.substring(email.indexOf('@') + 1)) 
            .collect(Collectors.toSet());

        System.out.println(domains);
    }
}
