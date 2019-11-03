package com.example.springjsonstreamtest.presentation.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class StreamResponse {

    private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Integer id;

    @Getter(AccessLevel.NONE)
    private LocalDateTime createDate;

    public String getCreateDate() {
        return createDate.format(DTF);
    }

    private String firstName;

    private String lastName;

    private String fullName;

    private String dummy1;

    private String dummy2;

    private String dummy3;

    private String dummy4;

    private String dummy5;

    private String dummy6;

    private String dummy7;

    private String dummy8;

    private String dummy9;

    private String dummy10;

    private String dummy11;

    private String dummy12;

    private String dummy13;

    private String dummy14;

    private String dummy15;

    private String dummy16;

    private String dummy17;

    private String dummy18;

    private String dummy19;

    private String dummy20;

}
