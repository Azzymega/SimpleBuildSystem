/*
 *
 *  *
 *  *  * PROJECT:    Simple Build System
 *  *  * LICENSE:     GPL - See COPYING in the top level directory
 *  *  * PROGRAMMER:  Maltsev Daniil <brickexberiment@lenta.ru>
 *  *
 *
 */

package org.sbs.wrappers;

import org.sbs.Token;
import org.sbs.TokenType;

import java.util.ArrayList;

public class Block extends Part {

    @Override
    public Token IsWork(ArrayList<Token> tokens) {
        Token token = new Token("Block", TokenType.Block);
        try {
            if (tokens.get(tokens.size()-1).getType() != TokenType.DefinitionHeaderEnd) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-1));
            tokens.remove(tokens.size()-1);
            while (tokens.get(tokens.size()-1).getType() != TokenType.DefinitionHeader) {
                token.getTokens().add(tokens.get(tokens.size()-1));
                tokens.remove(tokens.size()-1);
            }
            if (tokens.get(tokens.size()-1).getType() != TokenType.DefinitionHeader) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-1));
            tokens.remove(tokens.size()-1);
        }
        catch (Exception ex) {
            return null;
        }
        return token;
    }
}
