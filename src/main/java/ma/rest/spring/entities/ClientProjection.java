package ma.rest.spring.entities;

import org.springframework.data.rest.core.config.Projection;

/**
 * Projection pour afficher les détails du client
 */
@Projection(name = "clientDetails", types = Client.class)
public interface ClientProjection {
    String getNom();

    String getEmail();
}
