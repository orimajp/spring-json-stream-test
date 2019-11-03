package com.example.springjsonstreamtest.infrastructure.persistence.doma.dao;

import com.example.springjsonstreamtest.infrastructure.persistence.doma.entity.TestData;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@Dao
@ConfigAutowireable
public interface TestDataDao {

    @Select
    Integer selectCount();

    @Select
    List<TestData> selectAll();

    @Select(strategy = SelectType.STREAM)
    Integer selsctFuntionAll(Function<Stream<TestData>, Integer> mapper);

    @BatchInsert
    int[] batchInsert(List<TestData> testData);

}
