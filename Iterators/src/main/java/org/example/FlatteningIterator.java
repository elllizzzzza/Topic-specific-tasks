package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatteningIterator<T> implements Iterator<T> {

    private final Iterator<Iterator<T>> iterators;
    private Iterator<T> current;

    @SafeVarargs
    public FlatteningIterator(Iterator<T>... iterators) {
        this.iterators = List.of(iterators).iterator();
        this.current = null;
        advanceToNextNonEmpty();
    }

    private void advanceToNextNonEmpty() {
        while ((current == null || !current.hasNext()) && iterators.hasNext()) {
            current = iterators.next();
        }
    }

    @Override
    public boolean hasNext() {
        advanceToNextNonEmpty();
        return current != null && current.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return current.next();
    }
}
