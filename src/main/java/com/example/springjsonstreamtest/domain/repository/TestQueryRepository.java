package com.example.springjsonstreamtest.domain.repository;

import com.example.springjsonstreamtest.presentation.converter.TestRecordConverter;
import com.example.springjsonstreamtest.presentation.response.NormalResponse;

public interface TestQueryRepository {

    Integer getRecordCount();

    NormalResponse getNormalResponse();

    Integer generateStreamResponse(TestRecordConverter testRecordConverter);

}
