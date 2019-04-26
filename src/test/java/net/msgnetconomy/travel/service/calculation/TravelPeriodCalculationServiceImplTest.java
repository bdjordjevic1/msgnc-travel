package net.msgnetconomy.travel.service.calculation;

import net.msgnetconomy.travel.data.TravelPeriodData;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TravelPeriodCalculationServiceImplTest {

    @InjectMocks
    TravelPeriodCalculationServiceImpl travelPeriodCalculationService;

    private static final double AT_DAILY_RATE = 58d;

    @Test
    public void calculate() {
        TravelPeriodData travelPeriodData = new TravelPeriodData();
        travelPeriodData.setStart(LocalDateTime.of(2019, 2, 19, 0, 0));
        travelPeriodData.setEnd(LocalDateTime.of(2019, 2, 22, 17, 30));
        travelPeriodData.setDailyRate(AT_DAILY_RATE);
        travelPeriodData.setBreakfastIncluded(true);

        travelPeriodData = travelPeriodCalculationService.calculate(travelPeriodData);
        assertThat(travelPeriodData.getDailyRateTotal(), Matchers.is(208.8d));
    }
}