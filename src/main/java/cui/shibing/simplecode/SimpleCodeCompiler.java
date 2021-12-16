package cui.shibing.simplecode;

import cui.shibing.simplecode.parser.SimpleCodeParser;

public class SimpleCodeCompiler {

    private final SimpleCodeParser parser;

    public SimpleCodeCompiler(SimpleCodeParser parser) {
        this.parser = parser;
    }

    public Command compile() {
        String token;
        switch ((token = parser.getToken())) {
            case "dto": {
                DtoCommand command = new DtoCommand();
                String dtoName = parser.getToken();
                command.addOperand();
            }
            break;
            case "class": {
            }
            break;
        }
    }
}
