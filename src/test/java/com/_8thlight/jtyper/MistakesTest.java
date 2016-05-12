package com._8thlight.jtyper;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MistakesTest {

    @Test
    public void noMistakes100PercentAccuracy() {
        Mistakes mistakes = new Mistakes(new ArrayList<>());
        assertEquals(100, mistakes.accuracy());
    }
}
