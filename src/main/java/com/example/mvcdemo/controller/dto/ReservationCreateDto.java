package com.example.mvcdemo.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ReservationCreateDto {

    private long memberId;
    private Set<Long> bookIds;
}
