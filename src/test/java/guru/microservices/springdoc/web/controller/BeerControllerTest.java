package guru.microservices.springdoc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.microservices.springdoc.service.BeerService;
import guru.microservices.springdoc.web.model.BeerDTO;
import guru.microservices.springdoc.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@ComponentScan(basePackages = "guru.microservices.mssc_springdocss.web.mapper")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    private BeerService service;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/{beerId}", UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("/v1/beer", pathParameters(
                        parameterWithName("beerId").description("UUID of desired beer to get")
                )));
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDTO beerDTO = validBeerDTO();
        given(service.saveNewBeer(any())).willReturn(BeerDTO.builder().id(UUID.randomUUID()).build());

        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post("/api/v1/beer")
                        .content(beerDtoJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {

        BeerDTO beerDTO = validBeerDTO();
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .content(beerDtoJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    private BeerDTO validBeerDTO(){
        return BeerDTO.builder()
                .beerName("My beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(123123123123L)
                .build();
    }
}