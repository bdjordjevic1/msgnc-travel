package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class DailyRateCalculationData implements Serializable {

    private List<TravelPeriodData> travelPeriod;
    private double dailyRateTotal;
}
