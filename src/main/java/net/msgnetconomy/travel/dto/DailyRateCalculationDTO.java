package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;
import net.msgnetconomy.travel.data.MealType;
import net.msgnetconomy.travel.data.TravelPeriodData;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class DailyRateCalculationDTO implements Serializable {

    private TravelPeriodDTO travelPeriod;
    private double dailyRate;
    private Map<MealType, Integer> meals;
}
