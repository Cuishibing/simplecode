package cui.shibing.simplecode.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class SimpleCodeParser {

    private final Deque<String> loadedWords = new LinkedList<>();

    private final BufferedReader reader;

    public SimpleCodeParser(InputStream sourceStream) {
        this.reader = new BufferedReader(new InputStreamReader(sourceStream));
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            // ignore
        }
    }

    public Token getToken() {
        if (loadedWords.size() <= 0) {
            try {
                getWord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (loadedWords.size() <= 0) {
            return null;
        }
        String word = loadedWords.removeFirst();

        return Token.parseToken(word);
    }

    public void backToken(Token t) {
        if (t == null) {
            return;
        }
        loadedWords.addFirst(t.getValue());
    }

    private void getWord() throws IOException {
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
                        loadedWords.addLast(tokenBuilder.toString());
                    }
                    loadedWords.addLast(String.valueOf((char) read));
                    return;
                }

                case ' ':
                case '\r':
                case '\n': {
                    if (tokenBuilder.length() > 0) {
                        loadedWords.addLast(tokenBuilder.toString());
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
            loadedWords.addLast(tokenBuilder.toString());
        }
    }
}