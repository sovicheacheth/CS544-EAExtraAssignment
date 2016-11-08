package eaextracredit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;

/**
 * 
 * @author Sovichea Cheth
 * @id 985421
 * @date 11-07-2016
 *
 */

@Entity
@DiscriminatorValue("Admin")
public class Administrator extends User {

	@OneToMany(mappedBy = "administrator")
	private List<Project> projects = new ArrayList<Project>();

	public Administrator() {
	}

	public Administrator(int id, String name) {
		super.setId(id);
		super.setName(name);
	}

	public List<Project> getProject() {
		return projects;

	}

	public void addProject(Project project) {
		projects.add(project);
		project.setAdministrator(this);
	}

	public void removeProject(Project project) {
		project.setAdministrator(null);
		projects.remove(project);
	}
}
