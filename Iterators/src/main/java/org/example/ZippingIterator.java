package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class ZippingIterator<A, B, C> implements Iterator<C> {

    private final Iterator<A> a;
    private final Iterator<B> b;
    private final BiFunction<A, B, C> c;

    public ZippingIterator(Iterator<A> a, Iterator<B> b, BiFunction<A, B, C> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean hasNext() {
        return a.hasNext() && b.hasNext();
    }

    @Override
    public C next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        A aNext = a.next();
        B bNext = b.next();
        return c.apply(aNext, bNext);
    }
}
