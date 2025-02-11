package guru.microservices.mssc_beer_service.bootstrap;

import guru.microservices.mssc_beer_service.domain.Beer;
import guru.microservices.mssc_beer_service.repositories.IBeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class BeerLoader implements CommandLineRunner {

    private final IBeerRepository beerRepository;

    BeerLoader(IBeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.saveAll(
                    Arrays.asList(Beer.builder()
                                    .beerName("Mango Bobs")
                                    .beerStyle("IPA")
                                    .quantityOnBrew(200)
                                    .minOnHand(12)
                                    .upc(337010000001L)
                                    .price(new BigDecimal("12.95"))
                                    .build(),
                            Beer.builder()
                                    .beerName("Galaxy Cat")
                                    .beerStyle("PALE_ALE")
                                    .quantityOnBrew(200)
                                    .minOnHand(12)
                                    .upc(337010000002L)
                                    .price(new BigDecimal("11.95"))
                                    .build())
            );
        }
    }
}
