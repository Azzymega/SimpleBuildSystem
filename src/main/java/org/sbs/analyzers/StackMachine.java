/*
 *
 *  *
 *  *  * PROJECT:    Simple Build System
 *  *  * LICENSE:     GPL - See COPYING in the top level directory
 *  *  * PROGRAMMER:  Maltsev Daniil <brickexberiment@lenta.ru>
 *  *
 *
 */

package org.sbs.analyzers;

import org.sbs.BuildConfiguration;
import org.sbs.Token;
import org.sbs.wrappers.*;

import java.util.ArrayList;

public class StackMachine implements IAnalyzeConflict<StackMachine, BuildConfiguration> {
    private final ArrayList<Part> parts = new ArrayList<>();
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
        ArrayList<Token> clone;
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
