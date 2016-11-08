package eaextracredit.control;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eaextracredit.domain.Administrator;
import eaextracredit.domain.Project;
import eaextracredit.domain.Resource;
import eaextracredit.domain.Status;
import eaextracredit.domain.Task;
import eaextracredit.domain.Volunteer;

public class MainApp {

	private static EntityManagerFactory em;
	private static SimpleDateFormat sd;

	static {
		try {
			em = Persistence.createEntityManagerFactory("cs544_extra");
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ExceptionInInitializerError();
		}
	}

	public static void main(String[] args) {

	}

	private static void createProject() {
		EntityManager e = em.createEntityManager();
		EntityTransaction t = e.getTransaction();

		try {
			t.begin();

			/* Resource */
			Resource resource = new Resource();
			resource.setDescription("Project 001");
			e.persist(resource);

			Resource resource2 = new Resource();
			resource2.setDescription("Project 002");
			e.persist(resource2);

			Resource resource3 = new Resource();
			resource3.setDescription("Project 003");
			e.persist(resource3);

			/* Task */
			Task task = new Task();
			task.setStatus(Status.NEW);
			task.setResource(Arrays.asList(resource, resource2, resource3));
			task.setTimeFrame(10);
			task.setDescription("New Task");
			e.persist(task);

			/* Project */
			Project project = new Project();
			project.setDescription("New Project");
			project.setStatus(Status.INPROGRESS);
			project.setExpectedStartDate(sd.parse("2016-11-07"));
			project.setExpectedEndDate(sd.parse("2016-12-07"));
			project.setLocation("1000 N 4th St, Fairfield, IA 52557");
			project.addTask(task);
			e.persist(project);

			/* Volunteer */
			Volunteer volunteer = new Volunteer();
			volunteer.setName("Trump");
			volunteer.addTask(task);
			e.persist(volunteer);

			/* Administartor */
			Administrator admin = new Administrator();
			admin.setName("Sovichea Cheth");
			admin.addProject(project);
			e.persist(admin);

			t.commit();

		} catch (Throwable e1) {
			// TODO: handle exception

			if ((t != null) && (t.isActive())) {
				t.rollback();
			}
		} finally {
			if ((em != null) && (em.isOpen())) {
				em.close();
			}
		}
	}

}
