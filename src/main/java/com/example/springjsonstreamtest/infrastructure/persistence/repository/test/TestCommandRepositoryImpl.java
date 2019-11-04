package com.example.springjsonstreamtest.infrastructure.persistence.repository.test;

import com.example.springjsonstreamtest.domain.model.test.RegistTestData;
import com.example.springjsonstreamtest.domain.repository.TestCommandRepository;
import com.example.springjsonstreamtest.infrastructure.persistence.doma.dao.TestDataDao;
import com.example.springjsonstreamtest.infrastructure.persistence.doma.entity.TestData;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TestCommandRepositoryImpl implements TestCommandRepository {

    private final TestDataDao testDataDao;

    private final ModelMapper modelMapper;

    @Override
    public int[] batchInsert(List<RegistTestData> registTestDatas) {
        final List<TestData> testData = registTestDatas.stream()
                .map(registTestData -> modelMapper.map(registTestData, TestData.class))
                .collect(Collectors.toList());
        return testDataDao.batchInsert(testData);
    }

}
