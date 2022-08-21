package com.example.mvcdemo.service;

import com.example.mvcdemo.NotFountException;
import com.example.mvcdemo.controller.dto.ReservationCreateDto;
import com.example.mvcdemo.controller.dto.ReservationDto;
import com.example.mvcdemo.model.Book;
import com.example.mvcdemo.model.Member;
import com.example.mvcdemo.model.Reservation;
import com.example.mvcdemo.repository.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberService memberService;
    private final BookService bookService;

    public ReservationService(ReservationRepository reservationRepository, MemberService memberService, BookService bookService) {
        this.reservationRepository = reservationRepository;
        this.memberService = memberService;
        this.bookService = bookService;
    }

    public void createReservation(ReservationCreateDto dto) {

        Optional<Member> memberOptional = memberService.getMemberById(dto.getMemberId());

        Member member = memberOptional.orElseThrow(() -> new NotFountException("Member with id: " + dto.getMemberId() + " is not found"));

        if (dto.getBookIds().size() > 3) {
            throw new IllegalArgumentException("Allowed number of books per reservation is 3");
        }

        List<Book> existingBookList = dto.getBookIds().stream()
                .map(id -> bookService.getById(id))
                .filter(bookOptional -> bookOptional.isPresent())
                .map(bookOptional -> bookOptional.get())
                .collect(Collectors.toList());

        if (existingBookList.size() != dto.getBookIds().size()) {
            throw new NotFountException("Some of the book ids doesn't exist");
        }

        reservationRepository.save(
                Reservation.builder().books(existingBookList)
                        .member(member)
                        .reservationOn(LocalDate.now())
                        .build());
    }

    public Page<Reservation> getAllByPage(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }
}
