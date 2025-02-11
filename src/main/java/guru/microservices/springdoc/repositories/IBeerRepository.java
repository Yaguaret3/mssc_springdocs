package guru.microservices.springdoc.repositories;

import guru.microservices.springdoc.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IBeerRepository extends JpaRepository<Beer, UUID> {


}
