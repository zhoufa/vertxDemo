package com.zhoufa.demo.reactor.rxJava;

import java.math.BigInteger;
import java.util.Iterator;

public class GenerateNumbersIterator implements Iterator {

    private BigInteger current = BigInteger.ZERO;

    private final BigInteger num;

    public GenerateNumbersIterator(BigInteger num) {
        this.num = num;
    }

    @Override
    public boolean hasNext() {
        return current.compareTo(num) < 0;
    }

    @Override
    public Object next() {
        current  = current.add(BigInteger.ONE);
        return current;
    }

    public static void main(String[] args) {
        GenerateNumbersIterator iterator = new GenerateNumbersIterator(BigInteger.valueOf(10L));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
