package org.sbs.wrappers;

import org.sbs.Token;
import org.sbs.TokenType;

import java.util.Collections;
import java.util.Stack;

public class DeclStart extends Part{
    @Override
    public boolean IsWork(Stack<Token> tokens, Token token) {
        token = new Token("DefinitionHeader", TokenType.DefinitionHeader);
        try {
            if (tokens.peek().getType() != TokenType.EndDeclaration) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            if (tokens.peek().getType() != TokenType.DeclarationIdentifier) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            if (tokens.peek().getType() != TokenType.StartDeclaration) {
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
