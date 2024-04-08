package ma.emsi.evaluationFournisseur;

import ma.emsi.evaluationFournisseur.entities.*;
import ma.emsi.evaluationFournisseur.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class EvaluationFournisseurApplication {
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

	public static void main(String[] args) {
		SpringApplication.run(EvaluationFournisseurApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Question question1 = new Question(null,"Performance technique",0.3D);
		Question question2 = new Question(null,"maitrise des couts",0.3D);
		questionRepo.save(question1);
		questionRepo.save(question2) ;
		Question question3 = new Question(null,"respect des delais",0.2D);
		Question question4 = new Question(null,"resolution des problemes",0.2D);
		questionRepo.save(question3);
		questionRepo.save(question4) ;




		Supplier supplier = new Supplier() ;
		supplier.setName("name_sup1");
		supplier.setDescription("desc_sup1");
		supplier.setRating(0.0);
		supplierRepo.save(supplier) ;
		Supplier supplier2 = new Supplier() ;
		supplier2.setName("name_sup2");
		supplier2.setDescription("desc_sup2");
		supplier2.setRating(0.0);
		supplierRepo.save(supplier2) ;
		Supplier supplier3 = new Supplier() ;
		supplier3.setName("name_sup3");
		supplier3.setDescription("desc_sup3");
		supplier3.setRating(0.0);
		supplierRepo.save(supplier3) ;
		Supplier supplier4 = new Supplier() ;
		supplier4.setName("name_sup4");
		supplier4.setDescription("desc_sup4");
		supplier4.setRating(0.0);
		supplierRepo.save(supplier4) ;
		Supplier supplier5 = new Supplier() ;
		supplier5.setName("name_sup5");
		supplier5.setDescription("desc_sup5");
		supplier5.setRating(0.0);
		supplierRepo.save(supplier5) ;
		// Managers
		ProjectManager projectManager = new ProjectManager() ;
		projectManager.setFirst_name("manager_first_name");
		projectManager.setLast_name("manager_last_name");
		projectManager.setJob_title("Enginer");
		projectManager.setProjects(null);
		projectManagerRepo.save(projectManager) ;
		ProjectManager projectManger2 = new ProjectManager(null,"manager2_first_name", "manager_last_name","director",null);
		projectManagerRepo.save(projectManger2) ;
		//Evaluation
		Evaluation evaluation1 = new Evaluation() ;
		evaluation1.setEvaluation_date(new Date());
		evaluation1.setEvaluation_score(100D);
		evaluation1.setScores(null);

		Score score1 = new Score(null,question1,evaluation1,111D);
		Score score2 = new Score(null,question2,evaluation1,222D);

		evaluationRepo.save(evaluation1) ;
		scoreRepo.save(score1) ;
		scoreRepo.save(score2) ;
		// Projects

		Project project1 = new Project() ;
		//project1.setEvaluation(evaluation1);
		project1.setEvaluation(null);
		project1.setN_contract("AA666");
		project1.setDescription("Projet1_desc");
		Date date1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		project1.setStartsAt(date1);
		project1.setEndsAt(new Date());
		project1.setSupplier(supplier);

       // evaluation1.setProject(project1);
		//evaluationRepo.save(evaluation1) ;


		Project project2 = new Project() ;
		project2.setEvaluation(null);
		project2.setN_contract("AA777");
		project2.setDescription("Projet2_desc");
		Date date2 = new GregorianCalendar(2015, Calendar.MARCH, 11).getTime();
		project2.setStartsAt(date2);
		project2.setEndsAt(new Date());
		project2.setSupplier(supplier);

		Project project3 = new Project() ;
		project3.setEvaluation(null);
		project3.setN_contract("AA888");
		project3.setDescription("Projet3_desc");
		Date date3 = new GregorianCalendar(2018, Calendar.MARCH, 12).getTime();
		project3.setStartsAt(date3);
		project3.setEndsAt(new Date());
		project3.setSupplier(supplier);

		Project project4 = new Project() ;
		project4.setEvaluation(null);
		project4.setN_contract("AA999");
		project4.setDescription("Projet4_desc");
		Date date4 = new GregorianCalendar(2019, Calendar.DECEMBER, 19).getTime();
		project4.setStartsAt(date4);
		project4.setEndsAt(new Date());
		project4.setSupplier(supplier2);

		Project project5 = new Project() ;
		project5.setEvaluation(null);
		project5.setN_contract("BB999");
		project5.setDescription("Projet5_desc");
		Date date5 = new GregorianCalendar(2023, Calendar.MARCH, 6).getTime();
		project4.setStartsAt(date5);
		project4.setEndsAt(new Date());
		project4.setSupplier(supplier);

		project1.setProjectManager(projectManager);
		project2.setProjectManager(projectManager);
		project3.setProjectManager(projectManager);
		project4.setProjectManager(projectManager);
		project5.setProjectManager(projectManager);

		projectRepo.save(project1) ;
	//	evaluation1.setProject(project1);
	//	evaluationRepo.save(evaluation1);
		projectRepo.save(project2) ;
		projectRepo.save(project3) ;
		projectRepo.save(project4) ;
		projectRepo.save(project5) ;
	}
}
