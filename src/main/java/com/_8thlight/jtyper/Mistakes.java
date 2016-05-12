package com._8thlight.jtyper;

import java.util.List;

public class Mistakes {

    private final List<Mistake> mistakes;

    public Mistakes(List<Mistake> mistakes) {
        this.mistakes = mistakes;
    }

    public List<Mistake> getMistakes() {
        return mistakes;
    }

    public int accuracy() {
        return 100;
    }
}
