package com.example.mvcdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate membershipDate;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations;
}
