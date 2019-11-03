package com.example.springjsonstreamtest.presentation.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class NormalResponse {

    private final List<NormalResponseRecord> records;

    public int getCount() {
        return records.size();
    }

}
