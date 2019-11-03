package com.example.springjsonstreamtest.presentation.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NormalResponseRecord {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

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
