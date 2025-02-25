package com.project.attempt;

import java.util.HashSet;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(letterTilePossibilities("AAB"));
        System.out.println(letterTilePossibilities("AAABBC"));
        System.out.println(letterTilePossibilities("V"));

    }

    // Returns the number of valid substrings that can be made from string tiles.
    public static int letterTilePossibilities(String tiles) {

        // As Sets only allow unique entries, we will use a HashSet to store
        // valid substrings that fulfill the conditions of the challenge specifications.
        HashSet<String> words = new HashSet<>();

        // We will pass the length of the original string tiles into our recursive method.
        // This will help the recursive method build strings of the correct length.
        int length = tiles.length();

        // We then call the recursive method that will return all the valid substrings
        // that can be made from string tiles that follow the challenge specifications.
        // We then call the .size() method on it in order to get the number of these substrings.
        return wordPermutations(words, tiles, length, "").size();

    }

    // This method uses recursion to generate all possible valid substrings from string tiles.
    private static HashSet<String> wordPermutations(HashSet<String> words, String tiles, int length, String word) {

        // At the start of each call of this method, we call a helper method to see
        // if string word is a valid substring that follows challenge specifications.
        // If yes, we add it to hashset words.
        if (wordCheck(tiles, word)) {
            words.add(word);
        }

        // We then check if int length is 0 or not. If yes, we return hashset words
        // as it is without further logic. We do this because each call of this method
        // will decrement int length by 1 as we recursively build possible substrings.
        // Once we reach an int length of 0, that means string word has reached its
        // maximum size, and we do not want to append any further characters onto it.
        if (length == 0) {
            return words;
        }

        // We go through all characters in string tiles and try testing each of them to be
        // in the substring. We append the character to string words and perform a recursive
        // call where we decrement int length by 1 so that the recursive calls will eventually
        // stop when we want them to. This way, we can test all characters at all positions and
        // our helper method from earlier will allow us to only add the substrings that are valid
        // as per challenge specifications.
        for (int i = 0; i < tiles.length(); i++) {

            words = wordPermutations(words, tiles, length - 1, word + tiles.charAt(i));

        }

        // At the end of the loop, we return hashset words.
        return words;

    }

    // This helper method checks whether a certain String is a valid substring
    // that follows the constraints outlined by the challenge specifications.
    private static boolean wordCheck(String tiles, String word) {

        // The challenge specifications stated we only count non-empty strings.
        // Hence, we return false if string word is empty.
        if (word.isEmpty()) { return false; }

        // We create StringBuilder versions of string tiles and string word to easier work with them.
        StringBuilder tilesBuilder = new StringBuilder(tiles);
        StringBuilder wordBuilder = new StringBuilder(word);

        // This boolean will check for whether any changes have been made inside the while-loop.
        // We will exit the while-loop when it's been detected that no more changes can be performed.
        boolean change = true;

        // This while-loop will check whether string word is a substring of string tiles.
        // It will remove the same characters from string word and string tiles until there
        // are no more characters left in string word or no more changes can be made.
        // If all characters in string word can be removed, then it means it is a substring
        // of string tiles as string tiles has all the characters contained in string word.
        while (change) {

            // Boolean change will be set to false initially.
            change = false;

            for (int i = 0; i < tilesBuilder.length(); i++) {

                for (int j = 0; j < wordBuilder.length(); j++) {

                    // We loop through both strings and check for character equality
                    // at each index. If the same character is found, we delete both
                    // of them and exit the for-loops. We set boolean change to true
                    // to indicate change has been performed.
                    if (tilesBuilder.charAt(i) == wordBuilder.charAt(j)) {
                        tilesBuilder.deleteCharAt(i);
                        wordBuilder.deleteCharAt(j);
                        change = true;
                        break;
                    }

                }

                if (change) { break; }

            }

        }

        // At the end of the loops, if string word is empty, we return true
        // as that indicates it is a valid substring of string tiles.
        return wordBuilder.length() == 0;

    }

}
