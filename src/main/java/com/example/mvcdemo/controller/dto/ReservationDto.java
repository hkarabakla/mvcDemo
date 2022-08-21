package com.example.mvcdemo.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ReservationDto {

    private long id;
    private LocalDate reservationOn;
    private MemberDto member;
    private List<BookDto> books;
}
