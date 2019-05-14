package net.msgnetconomy.travel.service.calculation;

import net.msgnetconomy.travel.data.TravelPeriodData;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.TravelPeriodCalculationServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TravelPeriodCalculationServiceImplTest {

    @InjectMocks
    TravelPeriodCalculationServiceImpl travelPeriodCalculationService;

    @Test
    public void calculate() {
        TravelPeriodData travelPeriodData = new TravelPeriodData();
        travelPeriodData.setStart(LocalDateTime.of(2019, 2, 18, 13, 30));
        travelPeriodData.setEnd(LocalDateTime.of(2019, 2, 22, 17, 30));

        travelPeriodData = travelPeriodCalculationService.calculate(travelPeriodData);
        assertThat(travelPeriodData.getDays(), is(4L));
        assertThat(travelPeriodData.getHours(), is(4L));
        assertThat(travelPeriodData.getMinutes(), is(0L));
    }
}