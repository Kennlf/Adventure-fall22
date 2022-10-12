package com.example.adventurefall22.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Customer {

    @Id
    private int phoneNumber;
    @NonNull
    private String name;
    @NonNull
    private String email;

    private int cvr;

    private int companyName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    public Customer(@NonNull int phoneNumber, @NonNull String name, @NonNull String email) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
    }

    public Customer(int phoneNumber, @NonNull String name, @NonNull String email, int cvr, int companyName) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.cvr = cvr;
        this.companyName = companyName;
    }
}
