package guru.microservices.mssc_beer_service.service;

import guru.microservices.mssc_beer_service.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteBeer(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);
}
