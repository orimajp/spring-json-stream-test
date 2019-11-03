package com.example.springjsonstreamtest.presentation.converter;

@FunctionalInterface
public interface RecordConverter<T, V> {

    V toJson(T t);

}
