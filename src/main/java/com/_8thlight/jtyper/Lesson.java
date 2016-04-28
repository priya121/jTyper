package com._8thlight.jtyper;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Lesson {
    public static final char BACKSPACE = '\b';
    private final InputStream in;
    private final PrintStream out;
    private final String lessonText;
    private int correctCharactersEntered = 0;

    public Lesson(InputStream in, PrintStream out, String lessonText) {
        this.in = in;
        this.out = out;
        this.lessonText = lessonText;
    }

    public void run() throws IOException {
        out.println(lessonText);
        int c;
        while (notComplete() && (c = in.read()) != -1) {
            char ch = (char)c;
            out.print(ch);
            if (isCorrectCharacter(ch)) {
                correctCharactersEntered++;
            } else {
                out.write(BACKSPACE);
            }
        }
    }

    private boolean isCorrectCharacter(char ch) {
        return lessonText.charAt(correctCharactersEntered) == ch;
    }

    private boolean notComplete() {
        return correctCharactersEntered != lessonText.length();
    }
}
