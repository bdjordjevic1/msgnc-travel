package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TravelPeriodDTO implements Serializable {

    private LocalDateTime start;
    private LocalDateTime end;
}
