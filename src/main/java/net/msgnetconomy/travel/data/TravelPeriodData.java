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
    private long days;
    private long hours;
    private long minutes;
}
