
package acme.entities.artifact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Chef;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Artifact extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	
	@NotBlank
	@Length(min = 1, max = 101)
	protected String			name;
	
	@Column(unique=true)
	@Pattern(regexp = "^([A-Z]{2}:)?[A-Z]{3}-[0-9]{3}$",  message = "default.error.conversion")
	protected String			code;

	@NotBlank
	@Length(max=256)
	protected String			description;
	
	@NotNull
	protected Money				retailPrice;

	@URL
	protected String			link;
	
	@NotNull
	protected ArtifactType		type;
	
	@NotNull
	protected boolean 			isPublished;

	// Derived attributes -----------------------------------------------------
	
	// Relationships ----------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Chef				chef;
	
	
}
