package net.msgnetconomy.travel.populator;

import lombok.extern.slf4j.Slf4j;
import net.msgnetconomy.travel.data.TravelData;
import net.msgnetconomy.travel.dto.TravelDTO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("travelPopulator")
@Slf4j
public class TravelPopulator implements GenericPopulator<TravelDTO, TravelData> {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public TravelData populate(TravelDTO source, TravelData target) {
        try {
            dozerBeanMapper.map(source, target);
        } catch (Exception e) {
            log.error("Could not instantiate Dozer mapper: " + e.getMessage());
        }
        return target;
    }

}
