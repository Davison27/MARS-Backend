
DROP TABLE IF EXISTS user_table CASCADE;
DROP TABLE IF EXISTS doctor_table CASCADE;;
DROP TABLE IF EXISTS patient_table CASCADE;;
DROP TABLE IF EXISTS appointment_table CASCADE;;
DROP TABLE IF EXISTS diagnosis_table CASCADE;;
DROP TABLE IF EXISTS doctor_patient CASCADE;

DROP SCHEMA IF EXISTS postgres;

CREATE SCHEMA postgres;

CREATE TABLE user_table (
    user_id varchar(255) NOT NULL,
    name varchar(255),
    password varchar(255),
    surnames varchar(255),
    PRIMARY KEY(user_id)
);

CREATE TABLE doctor_table (
    doctor_id varchar(255) NOT NULL,
    membership_number varchar(255),
    PRIMARY KEY(doctor_id)
);

CREATE TABLE patient_table (
    patient_id varchar(255) NOT NULL,
    card_number varchar(255),
    direction varchar(255),
    nss varchar(255),
    telephone varchar(255),
    PRIMARY KEY(patient_id)
);

CREATE TABLE doctor_patient (
    doctor_id varchar(255) NOT NULL,
    patient_id varchar(255) NOT NULL
);

CREATE TABLE diagnosis_table (
     diagnosis_id varchar(255) NOT NULL,
     disease varchar(255),
     specialist_assessment varchar(255),
     PRIMARY KEY (diagnosis_id)
);

CREATE TABLE appointment_table (
    appointment_id varchar(255) NOT NULL,
    attribute11 integer,
    date_hour timestamp(6),
    diagnosis_id varchar(255) UNIQUE,
    doctor_id varchar(255),
    patient_id varchar(255),
    reason varchar(255),
    PRIMARY KEY (appointment_id)
);

ALTER TABLE if EXISTS appointment_table ADD CONSTRAINT  fk_appointment_diagnosis FOREIGN KEY (diagnosis_id) REFERENCES diagnosis_table;

ALTER TABLE if EXISTS appointment_table ADD CONSTRAINT  fk_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctor_table;

ALTER TABLE if EXISTS appointment_table ADD CONSTRAINT  fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patient_table;

ALTER TABLE if EXISTS doctor_patient ADD CONSTRAINT  fk_patient_doctor FOREIGN KEY (patient_id) REFERENCES patient_table;

ALTER TABLE if EXISTS doctor_patient ADD CONSTRAINT  fk_doctor_patient FOREIGN KEY (doctor_id) REFERENCES doctor_table;

ALTER TABLE if EXISTS doctor_table ADD CONSTRAINT  fk_doctor_user FOREIGN KEY (doctor_id) REFERENCES user_table;

ALTER TABLE if EXISTS patient_table ADD CONSTRAINT  fk_patient_user FOREIGN KEY (patient_id) REFERENCES user_table;

