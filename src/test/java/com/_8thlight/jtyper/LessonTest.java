package com._8thlight.jtyper;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class LessonTest {

    @Test
    public void runsSingleLineLesson() throws IOException {
        String lessonText = "test run";
        String inputText = "test run";
        InputStream in = new ByteArrayInputStream(toBytes(inputText));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);

        Lesson lesson = new Lesson(in, ps, lessonText);
        lesson.run();

        assertEquals(lessonText + "\n" + lessonText, out.toString());
    }

    @Test
    public void stopsReadingOnceLessonComplete() throws IOException {
        String lessonText = "test run";
        String inputText = "test runnnnn";
        InputStream in = new ByteArrayInputStream(toBytes(inputText));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);

        Lesson lesson = new Lesson(in, ps, lessonText);
        lesson.run();

        assertEquals(lessonText + "\n" + lessonText, out.toString());

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
