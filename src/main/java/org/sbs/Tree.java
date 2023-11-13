package org.sbs;

import java.util.ArrayList;

public class Tree {
    private Token token;
    private ArrayList<Tree> tokens;

    public Tree(Token token) {
        this.token = token;
        this.tokens = new ArrayList<>();
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public ArrayList<Tree> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Tree> tokens) {
        this.tokens = tokens;
    }
}
