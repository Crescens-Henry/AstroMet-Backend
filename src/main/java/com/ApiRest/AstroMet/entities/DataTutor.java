package com.ApiRest.AstroMet.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "data_tutor")
@Getter
@Setter
public class DataTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;

    @OneToOne
    private User user;
}
