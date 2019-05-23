package net.msgnetconomy.travel.service.report;

import net.msgnetconomy.travel.data.TravelData;

public interface ReportService {

    void generatePdf(TravelData travelData);
}
