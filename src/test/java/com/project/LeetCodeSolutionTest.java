package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void numTilePossibilitiesTest() {

        assertEquals(8, LeetCodeSolution.numTilePossibilities("AAB"));
        assertEquals(188, LeetCodeSolution.numTilePossibilities("AAABBC"));
        assertEquals(1, LeetCodeSolution.numTilePossibilities("V"));

    }

}
