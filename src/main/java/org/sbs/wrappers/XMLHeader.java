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

public class XMLHeader extends Part{

    @Override
    public Token IsWork(ArrayList<Token> tokens) {
        Token token = new Token("",TokenType.XMLHeader);
        try {
            if (tokens.get(tokens.size()-1).getType() != TokenType.EndDeclaration) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-1));
            if (tokens.get(tokens.size()-2).getType() != TokenType.Encoding) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-2));
            if (tokens.get(tokens.size()-3).getType() != TokenType.Version) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-3));
            if (tokens.get(tokens.size()-4).getType() != TokenType.XML) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-4));
            if (tokens.get(tokens.size()-5).getType() != TokenType.StartDeclaration) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-5));
        }
        catch (Exception ex) {
            return null;
        }
        tokens.remove(tokens.size()-1);
        tokens.remove(tokens.size()-1);
        tokens.remove(tokens.size()-1);
        tokens.remove(tokens.size()-1);
        tokens.remove(tokens.size()-1);
        return token;
    }
}
