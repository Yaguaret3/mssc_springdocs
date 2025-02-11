package guru.microservices.springdoc.service;

import guru.microservices.springdoc.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteBeer(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);
}
