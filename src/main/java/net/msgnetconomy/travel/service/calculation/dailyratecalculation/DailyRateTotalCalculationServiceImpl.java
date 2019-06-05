package net.msgnetconomy.travel.service.calculation.dailyratecalculation;

import net.msgnetconomy.travel.data.DailyRateCalculationData;
import net.msgnetconomy.travel.data.MealType;
import net.msgnetconomy.travel.data.TravelReportData;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("dailyRateTotalCalculationService")
public class DailyRateTotalCalculationServiceImpl implements DailyRateTotalCalculationService {

    private static final int HALF_DAY_BOUNDARY = 12;
    private static final int LESS_THEN_HALF_DAY_BOUNDARY = 8;
    private static final double BREAKFAST_REDUCTION_FACTOR = 0.1;
    private static final double LUNCH_REDUCTION_FACTOR = 0.3;
    private static final double DINNER_REDUCTION_FACTOR = 0.3;

    @Override
    public DailyRateCalculationData calculate(TravelReportData travelReportData) {
        DailyRateCalculationData dailyRateCalculationData = travelReportData.getDailyRateCalculation();
        calculateAmountOfDailyRates(dailyRateCalculationData);
        calculateDailyRateTotal(dailyRateCalculationData, travelReportData.getLocationTo().getDailyRate());
        return dailyRateCalculationData;
    }

    private void calculateAmountOfDailyRates(DailyRateCalculationData dailyRateCalculationData) {
        if (dailyRateCalculationData.getTravelPeriod().getHours() <= LESS_THEN_HALF_DAY_BOUNDARY) {
            dailyRateCalculationData.setAmountOfDailyRates(dailyRateCalculationData.getTravelPeriod().getDays());
        } else if (dailyRateCalculationData.getTravelPeriod().getHours() > LESS_THEN_HALF_DAY_BOUNDARY &&
                dailyRateCalculationData.getTravelPeriod().getHours() <= HALF_DAY_BOUNDARY) {
            dailyRateCalculationData.setAmountOfDailyRates(dailyRateCalculationData.getTravelPeriod().getDays() + 0.5);
        } else {
            dailyRateCalculationData.setAmountOfDailyRates(dailyRateCalculationData.getTravelPeriod().getDays() + 1);
        }
    }

    private void calculateDailyRateTotal(DailyRateCalculationData dailyRateCalculationData, double dailyRate) {
        Map<MealType, Integer> meals = dailyRateCalculationData.getMeals();
        int maximumNumberOfMealsOfSameType = findMaximumNumberOfMealsOfSameType(meals);
        double dailyRateTotal = calculateDailyRateTotal(maximumNumberOfMealsOfSameType,
                calculateReductionFactor(meals, maximumNumberOfMealsOfSameType),
                dailyRateCalculationData.getAmountOfDailyRates(),
                dailyRate);
        dailyRateCalculationData.setDailyRateTotal(dailyRateTotal);

    }

    private double calculateDailyRateTotal(int maximumNumberOfMealsOfSameType,
                                           double reductionFactor,
                                           double amountOfDailyRates,
                                           double dailyRate) {
        return dailyRate * reductionFactor + (amountOfDailyRates - maximumNumberOfMealsOfSameType) * dailyRate;
    }

    private double calculateReductionFactor(Map<MealType, Integer> meals, int maximumNumberOfMealsOfSameType) {
        double totalMealsReductionFactor = calculateTotalMealsReductionFactor(meals);
        return maximumNumberOfMealsOfSameType - totalMealsReductionFactor;
    }

    private double calculateTotalMealsReductionFactor(Map<MealType, Integer> meals) {
        double totalBreakfastReductionFactor = meals.get(MealType.BREAKFAST) * BREAKFAST_REDUCTION_FACTOR;
        double totalLunchReductionFactor = meals.get(MealType.LUNCH) * LUNCH_REDUCTION_FACTOR;
        double totalDinnerReductionFactor = meals.get(MealType.DINNER) * DINNER_REDUCTION_FACTOR;
        return totalBreakfastReductionFactor + totalLunchReductionFactor + totalDinnerReductionFactor;
    }

    private int findMaximumNumberOfMealsOfSameType(Map<MealType, Integer> meals) {
        return meals.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
    }
}
