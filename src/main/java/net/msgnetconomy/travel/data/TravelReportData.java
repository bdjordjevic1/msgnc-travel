package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TravelReportData implements Serializable {

    private LocalDateTime dateOfSubmission;
    private String firstName;
    private String lastName;
    private CountryData countryFrom;
    private CountryData countryTo;
    private DailyRateCalculationData dailyRateCalculation;
    private TransportationType transportationType;
    private AdditionalExpenseData additionalExpense;
    private List<PayoutData> totalPayout;
}
