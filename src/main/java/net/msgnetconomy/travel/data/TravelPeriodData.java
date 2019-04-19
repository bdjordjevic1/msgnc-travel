package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TravelPeriodData implements Serializable {

    private LocalDateTime start;
    private LocalDateTime end;
    private int days;
    private int hours;
    private int minutes;
    private double amountOfDailyRates;
    private double dailyRate;
    private double dailyRateTotal;
    private double breakfastIncluded;
    private double lunchIncluded;
    private double dinnerIncluded;
}
