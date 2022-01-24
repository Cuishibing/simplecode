package cui.shibing.simplecode.parser;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public enum TokenType {
    TYPE("[A-Z][a-z|A-Z]+"),
    METHOD("method"),
    AUTO_WIRED("autowired"),
    CONVERTER("dto_convert"),
    EQUAL("="),
    OPEN_BRACE("\\{"),
    CLOSE_BRACE("\\}"),
    COMMA("\\,"),
    SEMICOLON(";"),
    OPEN_PAREN("\\("),
    CLOSE_PAREN("\\)"),
    GEN("gen"),
    GEN_PAC("gen_package"),
    IDENTIFIER("[a-z|A-Z]+"),
    VALUE("'.+'");


    private final String pattern;
    private final Pattern compiledPattern;

    TokenType(String pattern) {
        if (StringUtils.isBlank(pattern)) {
            throw new IllegalArgumentException("pattern is blank");
        }
        this.pattern = "^" + pattern + "$";
        this.compiledPattern = Pattern.compile(this.pattern);
    }

    public String getPattern() {
        return pattern;
    }

    public Pattern getCompiledPattern() {
        return compiledPattern;
    }
}
