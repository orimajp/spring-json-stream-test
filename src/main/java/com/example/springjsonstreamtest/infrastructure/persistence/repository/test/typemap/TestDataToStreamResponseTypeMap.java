package com.example.springjsonstreamtest.infrastructure.persistence.repository.test.typemap;

import com.example.springjsonstreamtest.infrastructure.persistence.doma.entity.TestData;
import com.example.springjsonstreamtest.presentation.response.StreamResponse;
import com.github.rozidan.springboot.modelmapper.TypeMapConfigurer;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class TestDataToStreamResponseTypeMap extends TypeMapConfigurer<TestData, StreamResponse> {

    @Override
    public void configure(TypeMap<TestData, StreamResponse> typeMap) {
        typeMap.setPreConverter(context -> {
            final TestData source = context.getSource();
            final StreamResponse destination = context.getDestination();
            destination.setFullName(String.format("%s %s", source.getLastName(), source.getFirstName()));
            return context.getDestination();
        });
    }

}
