package com.example.adventurefall22.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int ageLimit;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<Equipment> equipmentList = new ArrayList<>();

    @ManyToOne
    private Reservation reservation;

    public void addEquipment(Equipment equipment){
        equipmentList.add(equipment);
        equipment.setActivity(this);
    }



}
