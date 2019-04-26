package net.msgnetconomy.travel.service.travel;

import net.msgnetconomy.travel.data.CountryData;
import net.msgnetconomy.travel.data.TravelData;
import net.msgnetconomy.travel.service.calculation.TravelPeriodCalculationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("travelService")
public class TravelServiceImpl implements TravelService {

    @Resource
    private TravelPeriodCalculationService travelPeriodCalculationService;

    @Override
    public TravelData populateTravelPeriod(TravelData travelData) {
        if (travelData.getTravelReport() != null && travelData.getTravelReport().getDailyRateCalculation() != null) {
            new ArrayList<>(travelData.getTravelReport().getDailyRateCalculation().getTravelPeriod()).stream()
                    .forEach(travelPeriod -> {
                        travelPeriod.setDailyRate(getDailyRate(travelData));
                        travelPeriodCalculationService.calculate(travelPeriod);
                    });
        }
        return travelData;
    }

    private double getDailyRate(TravelData travel) {
        CountryData destCountry = travel.getTravelReport().getCountryTo();
        return destCountry != null ? destCountry.getDailyRate() : 0;
    }

}
