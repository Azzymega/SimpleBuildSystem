package org.sbs.analyzers;

import org.sbs.BuildConfiguration;
import org.sbs.Token;
import org.sbs.TokenType;
import org.sbs.wrappers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StackMachine implements IAnalyzeConflict<StackMachine, BuildConfiguration> {
    private ArrayList<Part> parts = new ArrayList<>();
    public StackMachine() {
        parts.add(new XMLHeader());
        parts.add(new DeclEnd());
        parts.add(new DeclStart());
        parts.add(new Block());
        parts.add(new XML());
    }
    @Override
    public StackMachine AnalyzeResolve(BuildConfiguration Object) {
        ArrayList<Token> tokens = new ArrayList<>();
        ArrayList<Token> clone = new ArrayList<>();
        for (Token tkn : Object.getTokens()) {
            tokens.add(tkn);
            clone = (ArrayList<Token>) tokens.clone();
            for (Part part : parts) {
                Token token = part.IsWork(tokens);
                if (token == null) {
                    tokens = (ArrayList<Token>) clone.clone();
                }
                else {
                    tokens.add(token);
                    clone = (ArrayList<Token>) tokens.clone();
                }
            }
        }
        Object.getTree().addAll(tokens);
        return null;
    }
}
