package net.msgnetconomy.travel.service.currency;

import net.msgnetconomy.travel.dto.CurrencyDTO;

import java.util.List;

public interface CurrencyService {

    List<CurrencyDTO> getAvailableCurrencies();

    CurrencyDTO getCurrency(String isoCode);
}
