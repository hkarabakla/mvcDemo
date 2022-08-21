package com.example.mvcdemo.controller;

import com.example.mvcdemo.controller.dto.BookDto;
import com.example.mvcdemo.controller.dto.MemberDto;
import com.example.mvcdemo.controller.dto.ReservationCreateDto;
import com.example.mvcdemo.controller.dto.ReservationDto;
import com.example.mvcdemo.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("reservation")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservation(@RequestBody ReservationCreateDto dto) {
        reservationService.createReservation(dto);
    }

    @GetMapping("reservations")
    public Page<ReservationDto> getAll(Pageable pageable) {
        return reservationService.getAllByPage(pageable)
                .map(reservationDto -> ReservationDto.builder()
                        .id(reservationDto.getId())
                        .reservationOn(reservationDto.getReservationOn())
                        .member(MemberDto.builder()
                                .surname(reservationDto.getMember().getSurname())
                                .name(reservationDto.getMember().getName())
                                .membershipDate(reservationDto.getMember().getMembershipDate())
                                .birthDate(reservationDto.getMember().getBirthDate())
                                .id(reservationDto.getMember().getId())
                                .build())
                        .books(reservationDto.getBooks().stream()
                                .map(book -> BookDto.builder()
                                        .id(book.getId())
                                        .name(book.getName())
                                        .authors(book.getAuthors())
                                        .pageCount(book.getPageCount())
                                        .build())
                                .collect(Collectors.toList()))
                        .build());
    }
}
