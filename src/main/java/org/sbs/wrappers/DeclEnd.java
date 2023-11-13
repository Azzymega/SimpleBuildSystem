package org.sbs.wrappers;

import org.sbs.Token;
import org.sbs.TokenType;

import java.util.Collections;
import java.util.Stack;

public class DeclEnd extends Part {
    @Override
    public boolean IsWork(Stack<Token> tokens, Token token) {
        token = new Token("DefinitionHeader", TokenType.DefinitionHeaderEnd);
        try {
            if (tokens.peek().getType() != TokenType.EndEndDeclaration) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            if (tokens.peek().getType() != TokenType.DeclarationIdentifier) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            if (tokens.peek().getType() != TokenType.StartEndDeclaration) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
        }
        catch (Exception ex) {
            return false;
        }
        Collections.reverse(token.getTokens());
        tokens.push(token);
        return true;
    }
}
