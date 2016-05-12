package com._8thlight.jtyper;

public class Mistake {
    private final int position;
    private final char error;

    public Mistake(int position, char error) {
        this.position = position;
        this.error = error;
    }

    public int getPosition() {
        return position;
    }

    public char getError() {
        return error;
    }

    public boolean equals(Object o) {
        if (o instanceof Mistake) {
            Mistake m = (Mistake)o;
            return m.getPosition() == this.getPosition()
                    && m.getError() == this.getError();
        }
        return false;
    }

}
