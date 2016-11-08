package eaextracredit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * 
 * @author Sovichea Cheth
 * @id 985421
 * @date 11-07-2016
 *
 */

@Entity
@DiscriminatorValue("Volunteer")

public class Volunteer extends User {

	@OneToMany(mappedBy = "volunteer")
	@Transient
	private List<Task> tasks = new ArrayList<Task>();
	
	public Volunteer(){}
	
	public Volunteer(int id, String name){
		super.setId(id);
		super.setName(name);
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void addTask(Task task){
		tasks.add(task);
		task.setVolunteer(this);
	}
	
	public void removeTask(Task task){
		task.setVolunteer(null);
		tasks.remove(task);
	}
	
	
}
