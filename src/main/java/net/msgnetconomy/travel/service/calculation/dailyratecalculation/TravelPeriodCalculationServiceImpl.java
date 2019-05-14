package net.msgnetconomy.travel.service.calculation.dailyratecalculation;

import net.msgnetconomy.travel.data.TravelPeriodData;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Service("travelPeriodCalculationService")
public class TravelPeriodCalculationServiceImpl implements TravelPeriodCalculationService {

    @Override
    public TravelPeriodData calculate(TravelPeriodData travelPeriod) {
        if (Objects.isNull(travelPeriod)) {
            return travelPeriod;
        }
        LocalDateTime start = travelPeriod.getStart();
        LocalDateTime end = travelPeriod.getEnd();

        if (Objects.nonNull(start) && Objects.nonNull(end)) {
            Interval interval = new Interval(getMilliseconds(start), getMilliseconds(end));
            Period period = interval.toPeriod();
            travelPeriod.setDays(period.getDays());
            travelPeriod.setHours(period.getHours());
            travelPeriod.setMinutes(period.getMinutes());
        }

        return travelPeriod;
    }

    private long getMilliseconds(LocalDateTime date) {
        return date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
