package main;

import java.io.CharArrayReader;

public class StringManipulator {

    // input: ExAmPLE => output: ELPmAxE
    public String reverse(String input) {
        // Check if the input is null or empty
        if (input == null || input.isEmpty()) {
            return input; // Return as-is for null or empty
        }

        // Reverse the string using StringBuilder
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        // Check for null or empty string
        if (input == null || input.isEmpty()) {
            return false; // not palindrome();
        }

        // Compare the input string with its reversed version
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    public boolean isContained(String input, String part) {
        if (input == null || part == null) {
            return false; // If either string is null, return false
        }
        return input.contains(part);
        // Check if the input contains part
    }

    public String numberRemoved(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("[0-9]", "");
    }

    public String upperString(String input) {
        if (input == null) {
            return null;
        }
        return input.toUpperCase();
    }

    // input: ExAmPLE => output: example
    public String lowerString(String input) {
        if (input == null) {
            return null;
        }
        return input.toLowerCase();
    }

    public String capitalString(String input) {
        if (input == null) {
            return null;
        }

        String[] words = input.split(" ");

        StringBuilder capitalizedString = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                capitalizedString.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return capitalizedString.toString().trim();
    }

    public int countVowels(String input) {
        if (input == null) {
            return 0; // Return 0 for null input
        }
        String vowels = "aeiou";
        input = input.toLowerCase();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(input.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        String[] words = sentence.trim().split("\\s+");

        return words.length;
    }

    public int findSubstringIndex(String input, String substring) {
        if (input == null || substring == null) {
            return -1;
        }
        return input.indexOf(substring);
    }

    public String reverseWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]);
            if (i > 0) {
                reversedSentence.append(" ");
            }
        }

        return reversedSentence.toString();
    }

}
