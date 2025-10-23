package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BufferingIterator<T> implements Iterator<List<T>> {

    private final Iterator<T> iterator;
    private final int size;

    public BufferingIterator(Iterator<T> iterator, int size) {
        this.iterator = iterator;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public List<T> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        List<T> batch = new ArrayList<>(size);
        int count = 0;

        while (count < size && iterator.hasNext()) {
            batch.add(iterator.next());
            count++;
        }
        return batch;
    }
}
