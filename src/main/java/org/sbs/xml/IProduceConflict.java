package org.sbs.xml;

public interface IProduceConflict<T,J> {
    T ProduceResolve(J Object);
}
