package net.msgnetconomy.travel.service.country;

import net.msgnetconomy.travel.dto.LocationDTO;

import java.util.List;

public interface LocationService {

    List<LocationDTO> getAvailableCountries();
}
