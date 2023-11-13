package org.sbs.analyzers;

import org.sbs.BuildConfiguration;

public class AssemblyAnalyzer implements IAnalyzeConflict<AssemblyAnalyzer, BuildConfiguration> {
    @Override
    public AssemblyAnalyzer AnalyzeResolve(BuildConfiguration Object) {
        for (int x = 6; x < Object.getWords().size(); x++) {
            // дописать
        }
        return null;
    }
}
