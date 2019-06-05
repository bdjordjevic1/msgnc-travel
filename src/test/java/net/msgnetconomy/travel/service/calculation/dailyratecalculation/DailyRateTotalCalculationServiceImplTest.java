package net.msgnetconomy.travel.service.calculation.dailyratecalculation;

import net.msgnetconomy.travel.data.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAccumulator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DailyRateTotalCalculationServiceImplTest {

    @InjectMocks
    private DailyRateTotalCalculationServiceImpl dailyRateTotalCalculationService;

    @Test
    public void calculate() {
        DailyRateCalculationData dailyRateCalculationData = new DailyRateCalculationData();
        TravelPeriodData travelPeriod = new TravelPeriodData();
        travelPeriod.setDays(3);
        travelPeriod.setHours(9);
        dailyRateCalculationData.setTravelPeriod(travelPeriod);
        Map<MealType, Integer> meals = new HashMap<>();
        meals.put(MealType.BREAKFAST, 3);
        meals.put(MealType.LUNCH, 2);
        meals.put(MealType.DINNER, 0);
        dailyRateCalculationData.setMeals(meals);
        dailyRateCalculationData.setDailyRate(58d);
        LocationData locationTo = new LocationData();
        locationTo.setDailyRate(58);
        TravelReportData travelReportData = new TravelReportData();
        travelReportData.setLocationTo(locationTo);
        travelReportData.setDailyRateCalculation(dailyRateCalculationData);

        dailyRateCalculationData = dailyRateTotalCalculationService.calculate(travelReportData);

        assertThat(dailyRateCalculationData.getDailyRateTotal(), is(150.8d));
    }

    @Test
    public void calculate15Hours() {
        DailyRateCalculationData dailyRateCalculationData = new DailyRateCalculationData();
        TravelPeriodData travelPeriod = new TravelPeriodData();
        travelPeriod.setDays(3);
        travelPeriod.setHours(15);
        dailyRateCalculationData.setTravelPeriod(travelPeriod);
        Map<MealType, Integer> meals = new HashMap<>();
        meals.put(MealType.BREAKFAST, 3);
        meals.put(MealType.LUNCH, 2);
        meals.put(MealType.DINNER, 0);
        dailyRateCalculationData.setMeals(meals);
        dailyRateCalculationData.setDailyRate(58d);

        LocationData locationTo = new LocationData();
        locationTo.setDailyRate(58);
        TravelReportData travelReportData = new TravelReportData();
        travelReportData.setLocationTo(locationTo);
        travelReportData.setDailyRateCalculation(dailyRateCalculationData);

        dailyRateCalculationData = dailyRateTotalCalculationService.calculate(travelReportData);

        assertThat(dailyRateCalculationData.getDailyRateTotal(), is(179.8d));
    }
}