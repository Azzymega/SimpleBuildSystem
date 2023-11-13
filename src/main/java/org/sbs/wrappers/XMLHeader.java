package org.sbs.wrappers;

import org.sbs.Token;
import org.sbs.TokenType;
import org.sbs.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class XMLHeader extends Part{

    @Override
    public boolean IsWork(Stack<Token> tokens, Token token) {
        token = new Token("Header",TokenType.XMLHeader);
        try {
            if (tokens.peek().getType() != TokenType.EndDeclaration) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            if (tokens.peek().getType() != TokenType.Encoding) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            if (tokens.peek().getType() != TokenType.Version) {
                return false;
            }
            token.getTokens().add(tokens.peek());
            tokens.pop();
            if (tokens.peek().getType() != TokenType.XML) {
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
