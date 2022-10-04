package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Activity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityResponse {

    private int id;

    private String name;

    private int price;
    private int maxParticipant;
    private int ageLimit;


    public ActivityResponse(Activity activity){
        this.id = activity.getId();
        this.name = activity.getName();
        this.price = activity.getPrice();
        this.maxParticipant = activity.getMaxParticipant();
        this.ageLimit = activity.getAgeLimit();
    }

}
