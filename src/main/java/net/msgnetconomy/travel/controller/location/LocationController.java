package net.msgnetconomy.travel.controller.location;

import net.msgnetconomy.travel.dto.LocationDTO;
import net.msgnetconomy.travel.service.country.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Resource
    LocationService locationService;

    @GetMapping
    public List<LocationDTO> getAvailableLocations() {
        return locationService.getAvailableCountries();
    }
}
