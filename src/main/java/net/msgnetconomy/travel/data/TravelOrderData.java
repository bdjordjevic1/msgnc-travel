package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TravelOrderData implements Serializable {

    private LocalDateTime dateOfSubmission;
    private String description;
    private String includedExpenses;
}
