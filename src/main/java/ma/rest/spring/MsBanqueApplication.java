package ma.rest.spring;

import ma.rest.spring.entities.Client;
import ma.rest.spring.entities.Compte;
import ma.rest.spring.entities.TypeCompte;
import ma.rest.spring.repositories.ClientRepository;
import ma.rest.spring.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

/**
 * Classe principale de l'application bancaire
 * 
 * Cette application est une API REST pour la gestion de comptes bancaires.
 * Elle permet de :
 * - Gérer les clients et leurs comptes bancaires
 * - Effectuer des opérations CRUD sur les clients et les comptes
 * - Consulter les soldes et l'historique des comptes
 * - Gérer différents types de comptes (courant, épargne)
 * 
 * L'application utilise Spring Boot et Spring Data REST pour exposer une API RESTful.
 */
@SpringBootApplication
public class MsBanqueApplication {

    /**
     * Point d'entrée principal de l'application
     * @param args Arguments de la ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    /**
     * Initialise les données de test au démarrage de l'application
     * Crée des clients et des comptes de démonstration
     * 
     * @param compteRepository Repository pour la gestion des comptes
     * @param clientRepository Repository pour la gestion des clients
     * @param restConfiguration Configuration REST pour exposer les IDs dans les réponses
     * @return Un CommandLineRunner qui sera exécuté au démarrage
     */
    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository,
            RepositoryRestConfiguration restConfiguration) {
        return args -> {
            // Configuration pour exposer les IDs dans les réponses JSON
            // Cela permet d'avoir accès aux IDs des entités dans les réponses de l'API
            restConfiguration.exposeIdsFor(Compte.class, Client.class);

            // Création de deux clients de démonstration
            Client c1 = clientRepository.save(new Client(null, "Amal", "amal@gmail.com", null));
            Client c2 = clientRepository.save(new Client(null, "Ali", "ali@gmail.com", null));

            // Création de comptes de démonstration pour les clients
            // Chaque client a un compte épargne et/ou un compte courant
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            // Affichage dans la console de tous les comptes créés
            // Utile pour le débogage et la vérification des données
            System.out.println("=== COMPTES CRÉÉS ===");
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
            System.out.println("====================");
        };
    }
}
