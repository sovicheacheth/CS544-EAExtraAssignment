package eaextracredit;

import javax.persistence.Entity;
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
public class Administrator extends User{
	
	

}
