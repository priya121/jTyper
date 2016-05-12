package com._8thlight.jtyper;

import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LessonTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void runsSingleLineLesson() throws IOException {
        String lessonText = "test run";
        String typistInput = "test run";

        buildLesson(typistInput, lessonText).run();

        assertEquals(lessonText + "\n" + lessonText, out.toString());
    }

    @Test
    public void stopsReadingOnceLessonComplete() throws IOException {
        String lessonText = "test run";
        String typistInput = "test runnnnn";

        buildLesson(typistInput, lessonText).run();

        assertEquals(lessonText + "\n" + lessonText, out.toString());
    }

    @Test
    public void forcesTypistToCorrectMistake() throws IOException {
        String lessonText = "test run";
        String typistInput = "testabc run";

        buildLesson(typistInput, lessonText).run();

        String expectedOutput = lessonText + "\n" + "testa\bb\bc\b run";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void returnsErrors() throws IOException {
        String lessonText = "test run";
        String typistInput = "testabc run";

        Lesson lesson = buildLesson(typistInput, lessonText);
        lesson.run();

        List<Mistake> mistakes = lesson.mistakes().getMistakes();
        assertEquals(3, mistakes.size());
        assertEquals(new Mistake(4, 'a'), mistakes.get(0));
        assertEquals(new Mistake(4, 'b'), mistakes.get(1));
        assertEquals(new Mistake(4, 'c'), mistakes.get(2));

    }

    private Lesson buildLesson(String typistInput, String lessonText) {
        InputStream in = new ByteArrayInputStream(toBytes(typistInput));
        PrintStream ps = new PrintStream(out);
        return new Lesson(in, ps, lessonText);
    }

    private byte[] toBytes(String text) {
        try {
            return text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
