package cui.shibing.simplecode.parser;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token {

    private TokenType type;

    private String value;

    public static Token parseToken(String t) {
        if (StringUtils.isBlank(t)) {
            throw new IllegalArgumentException("token is blank");
        }

        for (TokenType type : TokenType.values()) {
            Pattern pattern = type.getCompiledPattern();
            Matcher matcher = pattern.matcher(t);
            if (matcher.find(0)) {
                return new Token(type, t);
            }
        }
        throw new IllegalArgumentException("not parsed token:" + t);
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
