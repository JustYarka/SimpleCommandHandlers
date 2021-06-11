package com.cloudflame.sch.template;

@FunctionalInterface
public interface HandlerInstance<S, A, R> {

    R apply(S sender, A args);
}
