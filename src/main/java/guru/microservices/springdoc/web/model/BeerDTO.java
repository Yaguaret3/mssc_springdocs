package guru.microservices.mssc_beer_service.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    @Null
    private Integer version;

    @Null
    private UUID id;

    @NotBlank
    private String beerName;
    @NotNull
    private BeerStyleEnum beerStyle;
    private Long quantityOnHand;

    @NotNull
    @Positive
    private Long upc;
    @NotNull
    @Positive
    private BigDecimal price;

    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lasModifiedDate;
}
