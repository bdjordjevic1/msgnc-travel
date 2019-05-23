package net.msgnetconomy.travel.controller.report;

import lombok.extern.slf4j.Slf4j;
import net.msgnetconomy.travel.data.TravelData;
import net.msgnetconomy.travel.dto.TravelDTO;
import net.msgnetconomy.travel.populator.TravelPopulator;
import net.msgnetconomy.travel.service.report.ReportService;
import net.msgnetconomy.travel.service.travel.TravelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Resource
    private TravelPopulator travelPopulator;

    @Resource
    private TravelService travelService;

    @Resource
    private ReportService reportService;

    @PostMapping("/generate")
    public TravelData generateReport(@RequestBody TravelDTO travelDTO) {
        log.info("date of submission" + travelDTO.getTravelReport().getDateOfSubmission());
        TravelData travelData = travelPopulator.populate(travelDTO, new TravelData());
        reportService.generatePdf(travelService.calculate(travelData));
        return travelData;
    }

}
