package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Activity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityResponse {

    private String name;

    private int price;

    private String instructorName;

    public ActivityResponse(Activity activity){
        this.name = activity.getName();
        this.price = activity.getPrice();
        this.instructorName = activity.getInstructorName();
    }

}
