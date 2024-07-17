package ma.emsi.evaluationFournisseur;

import ma.emsi.evaluationFournisseur.repositories.*;
import ma.emsi.evaluationFournisseur.services.EvaluationService;
import ma.emsi.evaluationFournisseur.services.KeycloakService;
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

//	@Autowired
//	ProjectEventConsumer projectEventConsumer ;
	public static void main(String[] args) {
		SpringApplication.run(EvaluationFournisseurApplication.class, args);
	}

	public void run(String... args) throws Exception {
//		KeycloakService keycloakService = new KeycloakService() ;
//		System.out.println("RUN");
//		keycloakService.deleteUserById("571dde2d-7e9d-4d27-83a6-2e647f6789bf");
//		System.out.println("DONE");
	}
//	public void setTopic(String projectManagerId, ProjectEvent event) {
//		// Assuming project manager ID and event details are provided
//		projectEventConsumer.projectEventConsumer2().accept(event);
//	}
}
