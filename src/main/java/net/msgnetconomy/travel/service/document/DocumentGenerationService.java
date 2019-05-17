package net.msgnetconomy.travel.service.document;

import net.msgnetconomy.travel.data.TravelData;

public interface DocumentGenerationService {

    void generatePdf(TravelData travelData);
}
