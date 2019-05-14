package net.msgnetconomy.travel.service.travel;

import net.msgnetconomy.travel.data.DailyRateCalculationData;
import net.msgnetconomy.travel.data.TravelData;
import net.msgnetconomy.travel.data.TravelPeriodData;
import net.msgnetconomy.travel.data.TravelReportData;
import net.msgnetconomy.travel.service.calculation.additionalexpense.AdditionalExpenseCalculationService;
import net.msgnetconomy.travel.service.calculation.additionalexpense.AdditionalExpenseCalculationServiceImpl;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.DailyRateTotalCalculationService;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.DailyRateTotalCalculationServiceImpl;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.TravelPeriodCalculationService;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.TravelPeriodCalculationServiceImpl;
import net.msgnetconomy.travel.service.calculation.totalpayout.TotalPayoutCalculationService;
import net.msgnetconomy.travel.service.calculation.totalpayout.TotalPayoutCalculationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TravelServiceImplIntegrationTest {

    private static final double AT_DAILY_RATE = 58d;

    @TestConfiguration
    static class TravelServiceImplTestConfiguration {

        @Bean
        public TravelService travelService() {
            return new TravelServiceImpl();
        }

        @Bean
        public TravelPeriodCalculationService travelPeriodCalculationService() {
            return new TravelPeriodCalculationServiceImpl();
        }

        @Bean
        public DailyRateTotalCalculationService dailyRateTotalCalculationService() {
            return new DailyRateTotalCalculationServiceImpl();
        }

        @Bean
        public AdditionalExpenseCalculationService additionalExpenseCalculationService() {
            return new AdditionalExpenseCalculationServiceImpl();
        }

        @Bean
        public TotalPayoutCalculationService totalPayoutCalculationService() {
            return new TotalPayoutCalculationServiceImpl();
        }
    }

    @Autowired
    private TravelService travelService;

    @Test
    public void calculate() {
//        TravelData travelData = new TravelData();
//        TravelReportData travelReport = new TravelReportData();
//        DailyRateCalculationData dailyRateCalculationData = new DailyRateCalculationData();
//
//        TravelPeriodData travelPeriodData1 = new TravelPeriodData();
//        travelPeriodData1.setStart(LocalDateTime.of(2019, 2, 18, 13, 30));
//        travelPeriodData1.setEnd(LocalDateTime.of(2019, 2, 18, 23, 59));
//        travelPeriodData1.setDailyRate(AT_DAILY_RATE);
//        travelPeriodData1.setNumberOfBreakfasts(true);
//
//        TravelPeriodData travelPeriodData2 = new TravelPeriodData();
//        travelPeriodData2.setStart(LocalDateTime.of(2019, 2, 19, 0, 0));
//        travelPeriodData2.setEnd(LocalDateTime.of(2019, 2, 22, 17, 30));
//        travelPeriodData2.setDailyRate(AT_DAILY_RATE);
//        travelPeriodData2.setNumberOfBreakfasts(true);
//
//        dailyRateCalculationData.setTravelPeriod(Arrays.asList(travelPeriodData2, travelPeriod2));
//
//        travelReport.setDailyRateCalculation(dailyRateCalculationData);
//        travelData.setTravelReport(travelReport);
//
//        travelService.calculate(travelData);
    }
}