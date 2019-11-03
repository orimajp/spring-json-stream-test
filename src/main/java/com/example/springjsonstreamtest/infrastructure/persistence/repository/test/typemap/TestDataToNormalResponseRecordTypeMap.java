package com.example.springjsonstreamtest.infrastructure.persistence.repository.test.typemap;

import com.example.springjsonstreamtest.infrastructure.persistence.doma.entity.TestData;
import com.example.springjsonstreamtest.presentation.response.NormalResponseRecord;
import com.github.rozidan.springboot.modelmapper.TypeMapConfigurer;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class TestDataToNormalResponseRecordTypeMap extends TypeMapConfigurer<TestData, NormalResponseRecord> {

    @Override
    public void configure(TypeMap<TestData, NormalResponseRecord> typeMap) {
        typeMap.setPreConverter( context -> {
            final TestData source = context.getSource();
            final NormalResponseRecord destination = context.getDestination();
            destination.setFullName(String.format("%s %s", source.getLastName(), source.getFirstName()));
            return context.getDestination();
        });
    }

}
