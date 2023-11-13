package org.sbs.analyzers;

import org.sbs.BuildConfiguration;
import org.sbs.Token;
import org.sbs.TokenType;
import org.sbs.wrappers.*;

import java.util.ArrayList;
import java.util.Stack;

public class StackMachine implements IAnalyzeConflict<StackMachine, BuildConfiguration> {
    private ArrayList<Part> parts = new ArrayList<>();
    public StackMachine() {
        parts.add(new XMLHeader());
        parts.add(new XML());
        parts.add(new Block());
        parts.add(new DeclEnd());
        parts.add(new DeclStart());
    }
    @Override
    public StackMachine AnalyzeResolve(BuildConfiguration Object) {
        Stack<Token> tokens = new Stack<Token>();
        Stack<Token> clone = new Stack<Token>();
        for (Token tkn : Object.getTokens()) {
            tokens.add(tkn);
            clone = (Stack<Token>) tokens.clone();
            for (Part part : parts) {
                Token token = new Token("sadf",TokenType.XMLHeader);
                if (part.IsWork(clone,token)) {
                    tokens = clone;
                }
            }
        }
        Object.getTree().add(tokens.peek());
        return null;
    }
}
