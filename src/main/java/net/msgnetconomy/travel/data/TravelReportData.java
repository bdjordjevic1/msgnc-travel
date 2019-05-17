package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
public class TravelReportData implements Serializable {

    private LocalDate dateOfSubmission;
    private String firstName;
    private String lastName;
    private LocationData locationFrom;
    private LocationData locationTo;
    private DailyRateCalculationData dailyRateCalculation;
    private TransportationType transportationType;
    private AdditionalExpenseData additionalExpense;
    private Map<CurrencyData, Double> totalPayout;
}
