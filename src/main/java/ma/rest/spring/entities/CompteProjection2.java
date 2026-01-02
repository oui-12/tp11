package ma.rest.spring.entities;

import org.springframework.data.rest.core.config.Projection;

/**
 * Projection pour affichage mobile
 */
@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2 {
    double getSolde();

    TypeCompte getType();
}
