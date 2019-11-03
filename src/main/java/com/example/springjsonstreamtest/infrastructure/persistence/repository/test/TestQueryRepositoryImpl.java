package com.example.springjsonstreamtest.infrastructure.persistence.repository.test;

import com.example.springjsonstreamtest.domain.repository.TestQueryRepository;
import com.example.springjsonstreamtest.infrastructure.persistence.doma.dao.TestDataDao;
import com.example.springjsonstreamtest.infrastructure.persistence.doma.entity.TestData;
import com.example.springjsonstreamtest.presentation.converter.TestRecordConverter;
import com.example.springjsonstreamtest.presentation.response.NormalResponse;
import com.example.springjsonstreamtest.presentation.response.NormalResponseRecord;
import com.example.springjsonstreamtest.presentation.response.StreamResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TestQueryRepositoryImpl implements TestQueryRepository {

    private final TestDataDao testDataDao;

    private final ModelMapper modelMapper;

    private final static Type normalResponseRecordType = new TypeToken<List<NormalResponseRecord>>() {}.getType();

    @Override
    public Integer getRecordCount() {
        return testDataDao.selectCount();
    }

    @Override
    public NormalResponse getNormalResponse() {
        // リストコピーを行っても速くならず、むしろわずかに遅くなる
/*
        final List<TestData> testDatas = testDataDao.selectAll();
        final List<NormalResponseRecord> records = modelMapper.map(testDatas, normalResponseRecordType);
        return new NormalResponse(records);
*/
        final List<TestData> testDatas = testDataDao.selectAll();
        final List<NormalResponseRecord> records = testDatas.stream()
                .map(this::createNormalResponse)
                .collect(Collectors.toList());
        return new NormalResponse(records);
    }

    @Override
    public Integer generateStreamResponse(TestRecordConverter testRecordConverter) {
        // データをリストで取得する方が微妙に速くなる
/*        final List<TestData> testDatas = testDataDao.selectAll();
        return testDatas.stream()
                .map(this::createStreamResponse)
                .map(testRecordConverter::toJson)
                .mapToInt(value -> value)
                .sum();
*/

        return testDataDao.selsctFuntionAll(testDataStream -> testDataStream
                .map(this::createStreamResponse)
                .map(testRecordConverter::toJson)
                .mapToInt(value -> value)
                .sum());
    }

    private NormalResponseRecord createNormalResponse(TestData testData) {
        return modelMapper.map(testData, NormalResponseRecord.class);
    }

    private StreamResponse createStreamResponse(TestData testData) {
        return modelMapper.map(testData, StreamResponse.class);
    }

}
