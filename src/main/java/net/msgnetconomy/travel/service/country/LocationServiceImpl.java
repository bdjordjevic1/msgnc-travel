package net.msgnetconomy.travel.service.country;

import net.msgnetconomy.travel.dto.LocationDTO;
import net.msgnetconomy.travel.service.currency.CurrencyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service("locationServiceImpl")
public class LocationServiceImpl implements LocationService {

    @Resource
    CurrencyService currencyService;

    @Override
    public List<LocationDTO> getAvailableCountries() {
        LocationDTO locationDefault = new LocationDTO();
        locationDefault.setIsoCode("Default");
        locationDefault.setCountry("Choose country");
        LocationDTO locationAustria = new LocationDTO();
        locationAustria.setIsoCode("AU");
        locationAustria.setCountry("Austria");
        locationAustria.setCurrency(currencyService.getCurrency("EUR"));
        locationAustria.setDailyRate(58);
        return Arrays.asList(locationDefault, locationAustria);
    }
}
