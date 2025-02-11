package guru.microservices.mssc_beer_service.web.mapper;

import guru.microservices.mssc_beer_service.domain.Beer;
import guru.microservices.mssc_beer_service.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToDto(Beer beer);
    Beer dtoToEntity(BeerDTO beerDTO);
}
