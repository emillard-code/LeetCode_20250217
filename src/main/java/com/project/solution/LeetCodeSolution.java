package com.project.solution;

import java.util.HashSet;
import java.util.Set;

public class LeetCodeSolution {

    public static void main(String[] args) {

        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
        System.out.println(numTilePossibilities("V"));

    }

    public static int numTilePossibilities(String tiles) {

        Set<String> sequences = new HashSet<>();
        int len = tiles.length();
        boolean[] used = new boolean[len];

        // Generate all possible sequences including empty string
        generateSequences(tiles, "", used, sequences);

        // Subtract 1 to exclude empty string from count
        return sequences.size() - 1;

    }

    public static void generateSequences(String tiles, String current, boolean[] used, Set<String> sequences) {

        // Add current sequence to set
        sequences.add(current);

        // Try adding each unused character to current sequence
        for (int pos = 0; pos < tiles.length(); pos++) {

            if (!used[pos]) {

                used[pos] = true;
                generateSequences(tiles,current + tiles.charAt(pos), used, sequences);
                used[pos] = false;

            }

        }

    }

}
