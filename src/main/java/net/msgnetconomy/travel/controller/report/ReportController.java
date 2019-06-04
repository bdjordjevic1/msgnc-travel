package net.msgnetconomy.travel.controller.report;

import lombok.extern.slf4j.Slf4j;
import net.msgnetconomy.travel.data.MealType;
import net.msgnetconomy.travel.data.TravelData;
import net.msgnetconomy.travel.dto.ExampleDTO;
import net.msgnetconomy.travel.dto.TravelDTO;
import net.msgnetconomy.travel.populator.TravelPopulator;
import net.msgnetconomy.travel.service.report.ReportService;
import net.msgnetconomy.travel.service.travel.TravelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Resource
    private TravelPopulator travelPopulator;

    @Resource
    private TravelService travelService;

    @Resource
    private ReportService reportService;

    @PostMapping("/generate")
    public TravelData generateReport(@RequestBody TravelDTO travelDTO) {
        log.info("date of submission" + travelDTO.getTravelOrder().getDateOfSubmission());
        TravelData travelData = travelPopulator.populate(travelDTO, new TravelData());
        reportService.generatePdf(travelService.calculate(travelData));
        return travelData;
    }

    @GetMapping("/example")
    public ExampleDTO generateReport() {
        ExampleDTO exampleDTO = new ExampleDTO();
        Map<MealType, Integer> meals = new HashMap<>();
        meals.put(MealType.BREAKFAST, 3);
        meals.put(MealType.LUNCH, 2);
        meals.put(MealType.DINNER, 0);
        exampleDTO.setMeals(meals);
        return exampleDTO;
    }

}

