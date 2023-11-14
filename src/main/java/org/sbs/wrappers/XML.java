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

public class XML extends Part {

    @Override
    public Token IsWork(ArrayList<Token> tokens) {
        Token token = new Token("XML", TokenType.XMLFile);
        try {
            if (tokens.get(tokens.size()-1).getType() != TokenType.Block) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-1));
            if (tokens.get(tokens.size()-2).getType() != TokenType.XMLHeader) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-2));
        }
        catch (Exception ex) {
            return null;
        }
        tokens.remove(tokens.size()-1);
        tokens.remove(tokens.size()-1);
        return token;
    }
}
