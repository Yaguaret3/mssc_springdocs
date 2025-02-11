package guru.microservices.mssc_beer_service.web.controller;

import guru.microservices.mssc_beer_service.service.BeerService;
import guru.microservices.mssc_beer_service.web.model.BeerDTO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService){
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> saveNewBeer(@Validated @RequestBody BeerDTO beerDTO){
        BeerDTO beerCreated = beerService.saveNewBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", String.format("/api/v1/beer/$s", beerCreated.getId().toString()));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable UUID beerId, @Validated @RequestBody BeerDTO beerDTO){
        beerService.updateBeer(beerId, beerDTO);
    }
    /*@DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.deleteBeer(beerId);
    }
    
     */
}
