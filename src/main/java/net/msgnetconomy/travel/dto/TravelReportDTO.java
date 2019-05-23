package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;
import net.msgnetconomy.travel.data.TransportationType;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class TravelReportDTO implements Serializable {

    private LocalDate dateOfSubmission;
    private String firstName;
    private String lastName;
    private LocationDTO locationFrom;
    private LocationDTO locationTo;
    private DailyRateCalculationDTO dailyRateCalculation;
    private TransportationType transportationType;
    private AdditionalExpenseDTO additionalExpense;
}
