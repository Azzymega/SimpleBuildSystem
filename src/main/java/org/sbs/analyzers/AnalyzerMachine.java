package org.sbs.analyzers;

import org.sbs.BuildConfiguration;

public class AnalyzerMachine implements IAnalyzeConflict<AnalyzerMachine, BuildConfiguration> {
    private final HeaderAnalyzer headerAnalyzer = new HeaderAnalyzer();
    @Override
    public AnalyzerMachine AnalyzeResolve(BuildConfiguration Object) {
        headerAnalyzer.AnalyzeResolve(Object);
        return null;
    }
}
