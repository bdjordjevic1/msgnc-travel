package net.msgnetconomy.travel.service.currency;

import net.msgnetconomy.travel.dto.CurrencyDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public List<CurrencyDTO> getAvailableCurrencies() {
        CurrencyDTO currencyDefault = new CurrencyDTO();
        currencyDefault.setName("");
        currencyDefault.setIsoCode("");
        currencyDefault.setSymbol("Choose currency");
        CurrencyDTO currencyRSD = new CurrencyDTO();
        currencyRSD.setName("Dinar");
        currencyRSD.setIsoCode("RSD");
        currencyRSD.setSymbol("RSD");
        CurrencyDTO currencyEUR = new CurrencyDTO();
        currencyEUR.setName("Euro");
        currencyEUR.setIsoCode("EUR");
        currencyEUR.setSymbol("€");

        return Arrays.asList(currencyDefault, currencyRSD, currencyEUR);
    }

    @Override
    public CurrencyDTO getCurrency(String isoCode) {
        return getAvailableCurrencies().stream()
                .filter(currency -> StringUtils.equals(currency.getIsoCode(), isoCode))
                .findAny()
                .orElse(null);
    }
}
