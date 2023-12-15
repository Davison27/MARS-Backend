package com.david.citasMedicas.exception.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"Success"),

    PARAM_ERROR(1,"The parameter is incorrect"),

    USER_EXIST(10, "The user already exists"),
    USER_NOT_EXIST(11, "The user doesn't exists"),
    USER_CREATE_FAIL(12, "The user creation fail, please try again later"),
    USER_UPDATE_FAIL(13, "The user update fail, please try again later"),
    USER_DELETE_FAIL(14, "The user deletion fail, please try again later"),

    PATIENT_EXIST(20, "The patient already exists"),
    PATIENT_NOT_EXIST(21, "The patient doesn't exists"),
    PATIENT_CREATE_FAIL(22, "The patient creation fail, please try again later"),
    PATIENT_UPDATE_FAIL(23, "The patient update fail, please try again later"),
    PATIENT_DELETE_FAIL(24, "The patient deletion fail, please try again later"),

    DOCTOR_EXIST(30, "The doctor already exists"),
    DOCTOR_NOT_EXIST(31, "The doctor doesn't exists"),
    DOCTOR_CREATE_FAIL(32, "The doctor creation fail, please try again later"),
    DOCTOR_UPDATE_FAIL(33, "The doctor update fail, please try again later"),
    DOCTOR_DELETE_FAIL(34, "The doctor deletion fail, please try again later"),

    APPOINTMENT_EXIST(40,"The appointment already exists"),
    APPOINTMENT_NOT_EXIST(41,"The appointment doesn't exists"),
    APPOINTMENT_CREATE_FAILS(42,"The appointment creation fail, please try again"),
    APPOINTMENT_UPDATE_FAILS(42,"The appointment update fail, please try again"),
    APPOINTMENT_DELETE_FAILS(42,"The appointment deletion fail, please try again"),

    DIAGNOSIS_EXIST(50, "The diagnosis already exists"),
    DIAGNOSIS_NOT_EXIST(51, "The diagnosis doesn't exists"),
    DIAGNOSIS_CREATE_FAILS(52,"The diagnosis creation fail, please try again"),
    DIAGNOSIS_UPDATE_FAILS(53,"The diagnosis update fail, please try again"),
    DIAGNOSIS_DELETE_FAILS(54,"The diagnosis deletion fail, please try again"),
    
    ;

    private final Integer code;
    private final String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
