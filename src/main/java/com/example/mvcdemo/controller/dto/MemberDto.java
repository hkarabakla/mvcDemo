package com.example.mvcdemo.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MemberDto {

    private long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate membershipDate;
}
