package guru.microservices.springdoc.web.mapper;

import guru.microservices.springdoc.domain.Beer;
import guru.microservices.springdoc.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToDto(Beer beer);
    Beer dtoToEntity(BeerDTO beerDTO);
}
