package eaextracredit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author Sovichea Cheth
 * @id 985421
 * @date 11-07-2016
 *
 */

@Entity

public class Resource {
	
	@Id
	@GeneratedValue
	
	private int id;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
