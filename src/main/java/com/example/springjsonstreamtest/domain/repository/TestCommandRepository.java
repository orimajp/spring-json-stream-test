package com.example.springjsonstreamtest.domain.repository;

import com.example.springjsonstreamtest.domain.model.test.RegistTestData;

import java.util.List;

public interface TestCommandRepository {

    int[] batchInsert(List<RegistTestData> registTestData);

}
