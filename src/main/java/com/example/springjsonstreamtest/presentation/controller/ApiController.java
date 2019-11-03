package com.example.springjsonstreamtest.presentation.controller;

import com.example.springjsonstreamtest.application.service.TestService;
import com.example.springjsonstreamtest.presentation.converter.TestConverter;
//import com.example.springjsonstreamtest.presentation.converter.TestRecordConverter;
import com.example.springjsonstreamtest.presentation.response.CountResponse;
import com.example.springjsonstreamtest.presentation.response.NormalResponse;
//import com.fasterxml.jackson.core.JsonFactory;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final TestService testService;

//    private final ObjectMapper objectMapper;

    private final TestConverter testConverter;

    @PostMapping("regist")
    public ResponseEntity regist() {
        testService.registTestData();
        final CountResponse response = testService.getRecordCount();
        return ResponseEntity.ok(response);
    }

    @GetMapping("count")
    public ResponseEntity count() {
        final CountResponse response = testService.getRecordCount();
        return ResponseEntity.ok(response);
    }

    @GetMapping("normal")
    public ResponseEntity normal() {
        final NormalResponse response = testService.getNormalResponse();
        return ResponseEntity.ok(response);
    }

    @GetMapping("stream")
    public ResponseEntity<StreamingResponseBody> stream(final HttpServletResponse response) {
        response.setContentType("application/json");
        final StreamingResponseBody responseBody = testConverter::convert;

/*
        final JsonFactory jsonFactory = objectMapper.getFactory();
        final StreamingResponseBody responseBody = outputStream -> {
            try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(outputStream)) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName("records");
                jsonGenerator.writeStartArray();
                final int count = testService.generateStreamResponse(new TestRecordConverter(jsonGenerator));
                jsonGenerator.writeEndArray();
                jsonGenerator.writeNumberField("count", count);
                jsonGenerator.writeEndObject();
            }
        };
*/

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

}
