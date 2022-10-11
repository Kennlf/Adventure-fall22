package com.example.adventurefall22.entity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    public Customer(@NonNull int phoneNumber, @NonNull String name, @NonNull String email) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
    }
}
