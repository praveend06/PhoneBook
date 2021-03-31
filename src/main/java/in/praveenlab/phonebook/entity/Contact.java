package in.praveenlab.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;

@Component
@Entity
@Table(name = "contact_tbl")
@Data
@XmlRootElement
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@Column(name = "phone", unique = true, length = 10)
	@NotNull
	private Long phno;
}
