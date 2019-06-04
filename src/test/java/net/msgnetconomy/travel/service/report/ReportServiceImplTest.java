package net.msgnetconomy.travel.service.report;

import net.msgnetconomy.travel.data.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceImplTest {

    @InjectMocks
    ReportServiceImpl documentGenerationService;

    @Test
    public void name() {
        TravelData travelData = new TravelData();
        TravelReportData travelReportData = new TravelReportData();
        travelReportData.setDateOfSubmission(LocalDate.of(2019, 2, 22));
        travelReportData.setFirstName("Boban");
        travelReportData.setLastName("Djordjevic");
        travelReportData.setTransportationType(TransportationType.RENT_A_CAR);

        LocationData locationTo = new LocationData();
        CurrencyData currencyEuro = new CurrencyData();
        currencyEuro.setIsoCode("EUR");
        locationTo.setCurrency(currencyEuro);
        locationTo.setDailyRate(58);
        locationTo.setCountry("Austria");
        locationTo.setCity("Graz");
        travelReportData.setLocationTo(locationTo);

        DailyRateCalculationData dailyRateCalculationData = new DailyRateCalculationData();
        dailyRateCalculationData.setDailyRate(58);

        Map<MealType, Integer> meals = new HashMap<>();
        meals.put(MealType.BREAKFAST, 3);
        meals.put(MealType.LUNCH, 2);
        meals.put(MealType.DINNER, 0);
        dailyRateCalculationData.setMeals(meals);

        TravelPeriodData travelPeriod = new TravelPeriodData();
        travelPeriod.setDays(4);
        travelPeriod.setHours(4);
        travelPeriod.setStart(LocalDateTime.of(2019, 2, 18, 14, 30));
        travelPeriod.setEnd(LocalDateTime.of(2019, 2, 22, 18, 30));
        dailyRateCalculationData.setTravelPeriod(travelPeriod);

        dailyRateCalculationData.setAmountOfDailyRates(3.5);
        dailyRateCalculationData.setDailyRateTotal(150.8);
        travelReportData.setDailyRateCalculation(dailyRateCalculationData);

        AdditionalExpenseData additionalExpense = new AdditionalExpenseData();
        ExpenseData expense1 = new ExpenseData();
        expense1.setPrice(48);
        expense1.setDescription("Parking - hotel u Gracu");
        expense1.setCurrency(currencyEuro);
        ExpenseData expense2 = new ExpenseData();
        expense2.setPrice(8102.95);
        expense2.setDescription("Gorivo - Srbija");
        ExpenseData expense3 = new ExpenseData();
        expense3.setPrice(308);
        expense3.setDescription("Taksi - Airport city do Europcar");
        ExpenseData expense4 = new ExpenseData();
        expense4.setPrice(320);
        expense4.setDescription("Taksi - Europcar do Airport city");
        List<ExpenseData> expenses = Arrays.asList(expense1, expense2, expense3, expense4);
        additionalExpense.setExpenses(expenses);
        Map<CurrencyData, Double> totalPayout = new HashMap<>();
        totalPayout.put(currencyEuro, 285.80);
        additionalExpense.setTotalPayout(totalPayout);
        travelReportData.setAdditionalExpense(additionalExpense);

        travelData.setTravelReport(travelReportData);

        TravelOrderData travelOrder = new TravelOrderData();
        travelOrder.setDateOfSubmission(LocalDate.of(2019, 2, 18));
        travelOrder.setPurposeOfTravel("zajednickog rada sa timom i Kickoff Event-a sa novim timom (XXXLutz - G116MC01)");
        travelOrder.setIncludedExpenses("smestaja, dorucka, prevoza, putarina");

        travelData.setTravelOrder(travelOrder);

        documentGenerationService.generatePdf(travelData);
    }
}