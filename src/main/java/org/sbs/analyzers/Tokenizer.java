package org.sbs.analyzers;

import org.sbs.BuildConfiguration;
import org.sbs.Token;
import org.sbs.TokenType;

public class Tokenizer implements IAnalyzeConflict<Tokenizer, BuildConfiguration> {

    @Override
    public Tokenizer AnalyzeResolve(BuildConfiguration Object) {
        for (int x = 0; x < Object.getWords().size(); x++) {
            switch (Object.getWords().get(x)) {
                case "<" -> {
                    Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.StartDeclaration));
                }
                case ">" -> {
                    if (Object.getWords().get(x - 2) == "</") {
                        Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.EndEndDeclaration));
                    } else {
                        Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.EndDeclaration));
                    }
                }
                case "?xml" -> {
                    Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.XML));
                }
                case "?" -> {
                }
                case "," -> {
                    Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.Comma));
                }
                case "</" -> {
                    Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.StartEndDeclaration));
                }
                default -> {
                    if (Object.getTokens().get(Object.getTokens().size() - 1).getType() == TokenType.StartDeclaration) {
                        Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.DeclarationIdentifier));
                    } else if (Object.getTokens().get(Object.getTokens().size() - 1).getType() == TokenType.StartEndDeclaration) {
                        Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.DeclarationIdentifier));
                    } else if (Object.getWords().get(x).contains("version=")) {
                        Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.Version));
                    } else if (Object.getWords().get(x).contains("encoding=")) {
                        Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.Encoding));
                    } else {
                        Object.getTokens().add(new Token(Object.getWords().get(x), TokenType.Identifier));
                    }
                }
            }
        }
        return null;
    }
}
