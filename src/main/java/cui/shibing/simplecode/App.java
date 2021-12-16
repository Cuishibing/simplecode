package cui.shibing.simplecode;

import cui.shibing.simplecode.parser.SimpleCodeParser;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleCodeParser parser = new SimpleCodeParser(App.class.getResourceAsStream("/demo.code"));

        System.out.println(parser.getToken());
    }
}
