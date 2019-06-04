package net.msgnetconomy.travel.controller.currency;

import net.msgnetconomy.travel.dto.CurrencyDTO;
import net.msgnetconomy.travel.service.currency.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Resource
    private CurrencyService currencyService;

    @GetMapping
    public List<CurrencyDTO> getAvailableCurrencies() {
        return currencyService.getAvailableCurrencies();
    }
}

