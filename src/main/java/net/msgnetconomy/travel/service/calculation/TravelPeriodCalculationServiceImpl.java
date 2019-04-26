package net.msgnetconomy.travel.service.calculation;

import net.msgnetconomy.travel.data.TravelPeriodData;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Service("travelPeriodCalculationService")
public class TravelPeriodCalculationServiceImpl implements TravelPeriodCalculationService {

    private static final int HALF_DAY_BOUNDARY = 12;
    private static final int LESS_THEN_HALF_DAY_BOUNDARY = 8;
    private static final double BREAKFAST_INCLUDED = 0.1;
    private static final double LUNCH_INCLUDED = 0.3;
    private static final double DINNER_INCLUDED = 0.3;

    @Override
    public TravelPeriodData calculate(TravelPeriodData travelPeriod) {
        if (Objects.isNull(travelPeriod)) {
            return travelPeriod;
        }
        LocalDateTime start = travelPeriod.getStart();
        LocalDateTime end = travelPeriod.getEnd();

        if (Objects.nonNull(start) && Objects.nonNull(end)) {
            Interval interval = new Interval(getMiliseconds(start), getMiliseconds(end));
            Period period = interval.toPeriod();
            travelPeriod.setDays(period.getDays());
            travelPeriod.setHours(period.getHours());
            travelPeriod.setMinutes(period.getMinutes());
        }
        calculateAmountOfDailyRates(travelPeriod);
        calculateDailyRateTotal(travelPeriod);

        return travelPeriod;
    }

    private void calculateDailyRateTotal(TravelPeriodData travelPeriod) {
        double dailyRate = travelPeriod.getDailyRate();
        double reduceDailyRateFactor = reduceDailyRate(travelPeriod);
        double dailyRateTotal = travelPeriod.getAmountOfDailyRates() * dailyRate * reduceDailyRateFactor;
        travelPeriod.setDailyRateTotal(dailyRateTotal);
    }

    private double reduceDailyRate(TravelPeriodData travelPeriod) {
        double reduceDailyRate = 1;
        if (travelPeriod.isBreakfastIncluded()) {
            reduceDailyRate -= BREAKFAST_INCLUDED;
        }
        if (travelPeriod.isLunchIncluded()) {
            reduceDailyRate -= LUNCH_INCLUDED;
        }
        if (travelPeriod.isDinnerIncluded()) {
            reduceDailyRate -= DINNER_INCLUDED;
        }
        return reduceDailyRate;
    }

    private void calculateAmountOfDailyRates(TravelPeriodData travelPeriod) {
        if (travelPeriod.getHours() <= LESS_THEN_HALF_DAY_BOUNDARY) {
            travelPeriod.setAmountOfDailyRates(travelPeriod.getDays());
        } else if (travelPeriod.getHours() > LESS_THEN_HALF_DAY_BOUNDARY && travelPeriod.getHours() <= HALF_DAY_BOUNDARY) {
            travelPeriod.setAmountOfDailyRates(travelPeriod.getDays() + 0.5);
        } else {
            travelPeriod.setAmountOfDailyRates(travelPeriod.getDays() + 1);
        }
    }

    private long getMiliseconds(LocalDateTime date) {
        return date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
