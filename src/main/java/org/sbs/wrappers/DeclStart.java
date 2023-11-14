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

public class DeclStart extends Part{
    @Override
    public Token IsWork(ArrayList<Token> tokens) {
        Token token = new Token("DefinitionHeader", TokenType.DefinitionHeader);
        try {
            if (tokens.get(tokens.size()-1).getType() != TokenType.EndDeclaration) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-1));
            if (tokens.get(tokens.size()-2).getType() != TokenType.DeclarationIdentifier) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-2));
            if (tokens.get(tokens.size()-3).getType() != TokenType.StartDeclaration) {
                return null;
            }
            token.getTokens().add(tokens.get(tokens.size()-3));
        }
        catch (Exception ex) {
            return null;
        }
        tokens.remove(tokens.size()-1);
        tokens.remove(tokens.size()-1);
        tokens.remove(tokens.size()-1);
        return token;
    }
}
