package org.sbs.wrappers;

import org.sbs.Token;
import org.sbs.TokenType;

import java.util.Collections;
import java.util.Stack;

public class XML extends Part {
    @Override
    public boolean IsWork(Stack<Token> tokens, Token token) {
        token = new Token("XML", TokenType.XMLFile);
        try {
            if (tokens.peek().getType() != TokenType.Block) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            if (tokens.peek().getType() != TokenType.XMLHeader) {
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
