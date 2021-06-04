package HRMS.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="id")
@Table(name="system_users")
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser extends User
{
	@NotBlank
	@NotNull
	@Size(min = 2)
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Size(min = 2)
	@Column(name="last_name")
	private String lastName;
}
