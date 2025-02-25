package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void letterTilePossibilitiesTest() {

        assertEquals(8, LeetCodeAttempt.letterTilePossibilities("AAB"));
        assertEquals(188, LeetCodeAttempt.letterTilePossibilities("AAABBC"));
        assertEquals(1, LeetCodeAttempt.letterTilePossibilities("V"));

    }

}
