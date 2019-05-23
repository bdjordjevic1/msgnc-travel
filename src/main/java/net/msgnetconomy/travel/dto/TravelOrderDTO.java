package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class TravelOrderDTO implements Serializable {

    private LocalDate dateOfSubmission;
    private String includedExpenses;
    private String purposeOfTravel;
}
