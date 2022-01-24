package cui.shibing.simplecode;

import cui.shibing.simplecode.parser.SimpleCodeParser;
import cui.shibing.simplecode.parser.Token;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleCodeParser parser = new SimpleCodeParser(App.class.getResourceAsStream("/demo.code"));

        Token token;
        while ((token = parser.getToken()) != null) {
            System.out.println(token.getType() + ":" + token.getValue());
        }

        parser.close();
    }
}
