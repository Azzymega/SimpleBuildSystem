package org.sbs;

import org.sbs.analyzers.StackMachine;
import org.sbs.analyzers.Tokenizer;

public class Main {
    public static void main(String[] args) {
        BuildConfiguration buildConfiguration = new BuildConfiguration("D:\\IntelliJ IDEA Community Edition 2022.3.1\\projects\\SimpleBuildSystem\\src\\main\\java\\org\\sbs\\test.xml");
        XMLLoader loader = new XMLLoader();
        StackMachine machine = new StackMachine();
        WordParser parser = new WordParser();
        Tokenizer tokenizer = new Tokenizer();
        loader.Resolve(buildConfiguration);
        parser.Resolve(buildConfiguration);
        tokenizer.AnalyzeResolve(buildConfiguration);
        machine.AnalyzeResolve(buildConfiguration);
    }
}