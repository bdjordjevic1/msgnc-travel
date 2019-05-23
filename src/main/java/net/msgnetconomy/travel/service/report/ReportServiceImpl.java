package net.msgnetconomy.travel.service.report;

import lombok.extern.slf4j.Slf4j;
import net.msgnetconomy.travel.data.TravelData;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.OutputStream;

@Slf4j
@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Override
    public void generatePdf(TravelData travelData) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("XHTML");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("travelData", travelData);

        String html = templateEngine.process("pdf-template", context);

        try (OutputStream outputStream = new FileOutputStream("message.pdf")) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
        } catch (Exception e) {
            log.error("There was an error while generating PDF: " + e.getMessage());
        }

    }
}
