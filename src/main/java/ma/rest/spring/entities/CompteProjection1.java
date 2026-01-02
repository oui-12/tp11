package ma.rest.spring.entities;

import org.springframework.data.rest.core.config.Projection;

/**
 * Projection pour afficher uniquement le solde
 */
@Projection(name = "solde", types = Compte.class)
public interface CompteProjection1 {
    double getSolde();
}
