package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;
import net.msgnetconomy.travel.data.MealType;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class ExampleDTO implements Serializable {

    private String firstname;
    private String lastname;
    private Map<MealType, Integer> meals;
}
