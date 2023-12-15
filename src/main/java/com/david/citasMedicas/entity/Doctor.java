package com.david.citasMedicas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctor_table")
@PrimaryKeyJoinColumn(name = "doctor_id") //Due to I am using the JOINED strategy
@Getter @Setter
public class Doctor extends User{

	@Column(name = "membership_number")
	private String membershipNum;

	public Doctor(){}

	public Doctor(String name, String password, String surnames, @NonNull String user) {
		super(name, password, surnames, user);
	}

	@ManyToMany()
	@JoinTable(
			name = "doctor_patient",
			joinColumns = @JoinColumn(name = "doctor_id"),
			inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private List<Patient> patients;

	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;

}
