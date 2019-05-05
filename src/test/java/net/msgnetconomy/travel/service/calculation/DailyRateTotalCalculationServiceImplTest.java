package net.msgnetconomy.travel.service.calculation;

import net.msgnetconomy.travel.data.DailyRateCalculationData;
import net.msgnetconomy.travel.data.TravelPeriodData;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.DailyRateTotalCalculationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DailyRateTotalCalculationServiceImplTest {

    @InjectMocks
    private DailyRateTotalCalculationServiceImpl dailyRateTotalCalculationService;

    @Test
    public void calculateDailyRateTotal() {
        DailyRateCalculationData dailyRateCalculationData = new DailyRateCalculationData();
        TravelPeriodData travelPeriod1 = new TravelPeriodData();
        travelPeriod1.setDailyRateTotal(29d);
        TravelPeriodData travelPeriod2 = new TravelPeriodData();
        travelPeriod2.setDailyRateTotal(208.8d);
        dailyRateCalculationData.setTravelPeriod(Arrays.asList(travelPeriod1, travelPeriod2));

        dailyRateTotalCalculationService.calculate(dailyRateCalculationData);

        assertThat(dailyRateCalculationData.getDailyRateTotal(), is(237.8d));
    }
}