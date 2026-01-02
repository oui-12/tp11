package ma.rest.spring.repositories;

import ma.rest.spring.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository pour la gestion des clients
 */
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
}
