package com.example.springjsonstreamtest.presentation.converter;

import com.example.springjsonstreamtest.presentation.response.StreamResponse;
import com.fasterxml.jackson.core.JsonGenerator;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class TestRecordConverter implements RecordConverter<StreamResponse, Integer> {

    private final JsonGenerator jsonGenerator;

    @Override
    public Integer toJson(StreamResponse streamResponse) {
        try {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeNumberField("id", streamResponse.getId());
            jsonGenerator.writeStringField("createDate", streamResponse.getCreateDate());
            jsonGenerator.writeStringField("firstName", streamResponse.getFirstName());
            jsonGenerator.writeStringField("lastName", streamResponse.getLastName());
            jsonGenerator.writeStringField("fullName", streamResponse.getFullName());
            jsonGenerator.writeStringField("dummy1", streamResponse.getDummy1());
            jsonGenerator.writeStringField("dummy2", streamResponse.getDummy2());
            jsonGenerator.writeStringField("dummy3", streamResponse.getDummy3());
            jsonGenerator.writeStringField("dummy4", streamResponse.getDummy4());
            jsonGenerator.writeStringField("dummy5", streamResponse.getDummy5());
            jsonGenerator.writeStringField("dummy6", streamResponse.getDummy6());
            jsonGenerator.writeStringField("dummy7", streamResponse.getDummy7());
            jsonGenerator.writeStringField("dummy8", streamResponse.getDummy8());
            jsonGenerator.writeStringField("dummy9", streamResponse.getDummy9());
            jsonGenerator.writeStringField("dummy10", streamResponse.getDummy10());
            jsonGenerator.writeStringField("dummy11", streamResponse.getDummy11());
            jsonGenerator.writeStringField("dummy12", streamResponse.getDummy12());
            jsonGenerator.writeStringField("dummy13", streamResponse.getDummy13());
            jsonGenerator.writeStringField("dummy14", streamResponse.getDummy14());
            jsonGenerator.writeStringField("dummy15", streamResponse.getDummy15());
            jsonGenerator.writeStringField("dummy16", streamResponse.getDummy16());
            jsonGenerator.writeStringField("dummy17", streamResponse.getDummy17());
            jsonGenerator.writeStringField("dummy18", streamResponse.getDummy18());
            jsonGenerator.writeStringField("dummy19", streamResponse.getDummy19());
            jsonGenerator.writeStringField("dummy20", streamResponse.getDummy20());

            jsonGenerator.writeEndObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return 1;
    }

}
