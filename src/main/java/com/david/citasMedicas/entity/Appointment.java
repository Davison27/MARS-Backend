package com.david.citasMedicas.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Entity
@Table(name = "appointment_table")
@AllArgsConstructor
@NoArgsConstructor //For having the default constructor
@Data //Shortcut for having @Setter, @Getter, @EqualsAndHashCode & @RequiredArgsConstructor
public class Appointment {

	@Id
	@Column(name = "appointment_id")
	@GeneratedValue
	@NonNull
	private String id;

	@Column(name = "attribute11")
	private int attribute11;

	@Column(name = "date_hour")
	private Date dateHour;

	@Column(name = "reason")
	private String reason;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "diagnosis_id")
	private Diagnosis diagnosis;

	@ManyToOne()
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne()
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

}
