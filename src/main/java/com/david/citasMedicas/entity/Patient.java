package com.david.citasMedicas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "patient_table")
@PrimaryKeyJoinColumn(name = "patient_id") //Due to I am using the JOINED strategy
@Getter @Setter
public class Patient extends User {

	@Column(name = "direction")
	private String direction;

	@Column(name = "NSS")
	private String NSS;

	@Column(name = "card_number")
	private String numCard;

	@Column(name = "telephone")
	private String telephone;

	public Patient(){}
	
	public Patient(String name, String password, String surnames, @NonNull String user) {
		super(name, password, surnames, user);
	}

	@ManyToMany(mappedBy = "patients")
	private List<Doctor> doctors;

	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;


}
