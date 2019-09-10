package com.j4fan.springsecuritydemo.converter;

public interface DTOConvert<S, T> {
    T doForward(S s);

    S doBackward(T t);
}
