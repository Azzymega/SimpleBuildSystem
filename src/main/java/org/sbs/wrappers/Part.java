package org.sbs.wrappers;

import org.sbs.Token;
import org.sbs.Tree;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Part {
    public abstract boolean IsWork(Stack<Token> tokens, Token token);
}
