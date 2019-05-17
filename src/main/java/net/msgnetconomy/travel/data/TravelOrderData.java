package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class TravelOrderData implements Serializable {

    private LocalDate dateOfSubmission;
    private String includedExpenses;
    private String purposeOfTravel;
}
