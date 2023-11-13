package org.sbs;

public interface ILoadConflict<T,J> {
    T Resolve(J Object);
}
