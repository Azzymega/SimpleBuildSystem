package org.sbs.wrappers;

import org.sbs.Token;
import org.sbs.TokenType;

import java.util.Collections;
import java.util.Stack;

public class Block extends Part {

    @Override
    public boolean IsWork(Stack<Token> tokens, Token token) {
        token = new Token("Block", TokenType.Block);
        try {
            if (tokens.peek().getType() != TokenType.DefinitionHeaderEnd) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            while (tokens.peek().getType() != TokenType.DefinitionHeader) {
                token.getTokens().add(tokens.peek());
                tokens.pop();
            }
            if (tokens.peek().getType() != TokenType.DefinitionHeader) {
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
