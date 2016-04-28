import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Lesson {
    private final InputStream in;
    private final PrintStream out;
    private final String lessonText;
    private int charactersEntered = 0;

    public Lesson(InputStream in, PrintStream out, String lessonText) {
        this.in = in;
        this.out = out;
        this.lessonText = lessonText;
    }

    public void run() throws IOException {
        out.println(lessonText);
        int c;
        while (notComplete() && (c = getNextCharacter()) != -1) {
            out.print(String.valueOf((char) c));
        }
    }

    private int getNextCharacter() throws IOException {
        int c = in.read();
        charactersEntered++;
        return c;
    }

    private boolean notComplete() {
        return charactersEntered != lessonText.length();
    }
}
