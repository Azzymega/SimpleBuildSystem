package org.sbs.analyzers;

public interface IEventConflict<T,J> {
    T EventResolve(J Object);
}
