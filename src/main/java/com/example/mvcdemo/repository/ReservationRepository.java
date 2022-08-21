package com.example.mvcdemo.repository;

import com.example.mvcdemo.model.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {
}
