package guru.microservices.mssc_beer_service.repositories;

import guru.microservices.mssc_beer_service.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IBeerRepository extends JpaRepository<Beer, UUID> {


}
