package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class DailyRateCalculationData implements Serializable {

    private TravelPeriodData travelPeriod;
    private double amountOfDailyRates;
    private double dailyRate;
    private double dailyRateTotal;
    private Map<MealType, Integer> meals;
}
