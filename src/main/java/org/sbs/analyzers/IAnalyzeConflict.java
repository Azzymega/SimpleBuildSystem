package org.sbs.analyzers;

public interface IAnalyzeConflict<T,J> {
    T AnalyzeResolve(J Object);
}
