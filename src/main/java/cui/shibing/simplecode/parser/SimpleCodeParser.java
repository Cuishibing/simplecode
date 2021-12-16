package cui.shibing.simplecode.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class SimpleCodeParser {

    private final InputStream sourceStream;

    private final Deque<String> loadedToken = new LinkedList<>();

    private final BufferedReader reader;

    public SimpleCodeParser(InputStream sourceStream) {
        this.sourceStream = sourceStream;
        this.reader = new BufferedReader(new InputStreamReader(sourceStream));
    }

    public String getToken() {
        if (loadedToken.size() <= 0) {
            try {
                getTokenFromInput();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (loadedToken.size() <= 0) {
            return "";
        }
        return loadedToken.removeFirst();
    }

    public void backToken(String token) {
        loadedToken.addFirst(token);
    }

    private void getTokenFromInput() throws IOException {
        StringBuilder tokenBuilder = new StringBuilder();
        int read;
        while ((read = reader.read()) > -1) {
            switch (read) {
                case ';':
                case ',':
                case '(':
                case ')':
                case '{':
                case '}': {
                    if (tokenBuilder.length() > 0) {
                        loadedToken.addLast(tokenBuilder.toString());
                    }
                    loadedToken.addLast(String.valueOf((char) read));
                    return;
                }

                case ' ':
                case '\r':
                case '\n': {
                    if (tokenBuilder.length() > 0) {
                        loadedToken.addLast(tokenBuilder.toString());
                        return;
                    }
                }
                break;

                default: {
                    tokenBuilder.append((char) read);
                }
                break;
            }

        }
        if (tokenBuilder.length() > 0) {
            loadedToken.addLast(tokenBuilder.toString());
        }
    }

}
