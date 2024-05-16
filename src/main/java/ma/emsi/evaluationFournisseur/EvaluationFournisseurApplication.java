package ma.emsi.evaluationFournisseur;

import ma.emsi.evaluationFournisseur.repositories.*;
import ma.emsi.evaluationFournisseur.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvaluationFournisseurApplication implements CommandLineRunner{
	@Autowired
	SupplierRepo supplierRepo ;
	@Autowired
	ProjectRepo projectRepo ;
	@Autowired
	ProjectManagerRepo projectManagerRepo ;
	@Autowired
	EvaluationRepo evaluationRepo ;
	@Autowired
	QuestionRepo questionRepo ;
	@Autowired
	ScoreRepo scoreRepo ;
	@Autowired
	EvaluationService evaluationService ;
//	@Autowired
//	KeycloakService keycloakService ;

	public static void main(String[] args) {
		SpringApplication.run(EvaluationFournisseurApplication.class, args);
	}

	public void run(String... args) throws Exception {
//		KeycloakService keycloakService = new KeycloakService() ;
//		System.out.println("RUN");
//		keycloakService.createUser("fadi","1234");
//		System.out.println("DONE");
	}
}
