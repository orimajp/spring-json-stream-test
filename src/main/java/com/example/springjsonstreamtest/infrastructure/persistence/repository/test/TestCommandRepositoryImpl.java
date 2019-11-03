package com.example.springjsonstreamtest.infrastructure.persistence.repository.test;

import com.example.springjsonstreamtest.domain.model.test.RegistTestData;
import com.example.springjsonstreamtest.domain.repository.TestCommandRepository;
import com.example.springjsonstreamtest.infrastructure.persistence.doma.dao.TestDataDao;
import com.example.springjsonstreamtest.infrastructure.persistence.doma.entity.TestData;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestCommandRepositoryImpl implements TestCommandRepository {

    private final TestDataDao testDataDao;

    private final ModelMapper modelMapper;

    @Override
    public int[] batchInsert(List<RegistTestData> registTestData) {
        final Type listType = new TypeToken<List<TestData>>() {}.getType();
        final List<TestData> testData = modelMapper.map(registTestData, listType);
        return testDataDao.batchInsert(testData);
    }

}
