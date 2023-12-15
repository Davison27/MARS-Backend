package com.david.citasMedicas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diagnosis_table")
@AllArgsConstructor
@NoArgsConstructor  //For having the default constructor
@Data //Shortcut for having @Setter, @Getter, @EqualsAndHashCode & @RequiredArgsConstructor
public class Diagnosis {

	@Id
	@Column(name = "diagnosis_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(name = "specialist_assessment")
	private String specialistAssessment;

	@Column(name = "disease")
	private String disease;

	@OneToOne(mappedBy = "diagnosis")
	private Appointment appointment;

}
