package com.project.attempt;

import java.util.HashSet;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(letterTilePossibilities("AAB"));
        System.out.println(letterTilePossibilities("AAABBC"));
        System.out.println(letterTilePossibilities("V"));

    }
    
    public static int letterTilePossibilities(String tiles) {

        HashSet<String> words = new HashSet<>();
        int length = tiles.length();

        return wordPermutations(words, tiles, length, "").size();

    }

    private static HashSet<String> wordPermutations(HashSet<String> words, String tiles, int length, String word) {

        if (wordCheck(tiles, word)) {
            words.add(word);
        }

        if (length == 0) {
            return words;
        }

        for (int i = 0; i < tiles.length(); i++) {

            words = wordPermutations(words, tiles, length - 1, word + tiles.charAt(i));

        }

        return words;

    }

    private static boolean wordCheck(String tiles, String word) {

        if (word.isEmpty()) { return false; }

        StringBuilder tilesBuilder = new StringBuilder(tiles);
        StringBuilder wordBuilder = new StringBuilder(word);

        boolean change = true;

        while (change) {

            change = false;

            for (int i = 0; i < tilesBuilder.length(); i++) {

                for (int j = 0; j < wordBuilder.length(); j++) {

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

        return wordBuilder.length() == 0;

    }

}
