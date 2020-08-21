package com.example.demo.threadlocal;

public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static Long getId() {
        return requestHolder.get();
    }

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static void remove() {
        requestHolder.remove();
    }
}
