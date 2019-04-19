package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TravelData implements Serializable {

    private TravelOrderData travelOrder;
    private TravelReportData travelReport;
}
