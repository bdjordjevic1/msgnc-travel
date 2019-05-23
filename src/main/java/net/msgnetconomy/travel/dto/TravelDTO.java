package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TravelDTO implements Serializable {

    private TravelReportDTO travelReport;
    private TravelOrderDTO travelOrder;
}
