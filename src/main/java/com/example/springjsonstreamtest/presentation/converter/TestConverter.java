package com.example.springjsonstreamtest.presentation.converter;

import com.example.springjsonstreamtest.application.service.TestService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

@Component
@RequiredArgsConstructor
public class TestConverter {

    private final TestService testService;

    private final ObjectMapper objectMapper;

    public void convert(OutputStream outputStream) throws IOException {
        final JsonFactory jsonFactory = objectMapper.getFactory();
        try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(outputStream)) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("records");
            jsonGenerator.writeStartArray();
            final int count = testService.generateStreamResponse(new TestRecordConverter(jsonGenerator));
            jsonGenerator.writeEndArray();
            jsonGenerator.writeNumberField("count", count);
            jsonGenerator.writeEndObject();
        }
    }

}
