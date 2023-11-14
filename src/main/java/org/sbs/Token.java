/*
 *
 *  *
 *  *  * PROJECT:    Simple Build System
 *  *  * LICENSE:     GPL - See COPYING in the top level directory
 *  *  * PROGRAMMER:  Maltsev Daniil <brickexberiment@lenta.ru>
 *  *
 *
 */

package org.sbs;

import java.util.ArrayList;

public class Token {
    private String value;
    private TokenType type;
    private ArrayList<Token> tokens = new ArrayList<>();

    @Override
    public String toString() {
        return type.toString() + "                     :                   " + value;
    }

    public Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }
    public Token() {

    }
    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }
}
