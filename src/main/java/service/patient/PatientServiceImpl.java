package service.patient;

import entity.Patient;
import repository.patient.PatientRepository;

import java.sql.SQLException;

public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    Patient patient = new Patient();


    private boolean patientNameContains(String patientName) throws SQLException {
        patient.setPatientName(patientName);
        return patientRepository.patientNameContains(patient);
    }

    @Override
    public void signUp(String patientName, String patientPassword) throws SQLException {
        if (patientNameContains(patientName)) {
            System.out.println("sign up failed. ");
            System.out.println("this name is exist. please enter the another name.");
        } else {
            patient.setPatientName(patientName);
            patient.setPatientPassword(patientPassword);
            patientRepository.save(patient);
            System.out.println("sign up is successfully. ");
        }
    }

    @Override
    public void logIn(String patientName, String patientPassword) throws SQLException {
        patient.setPatientName(patientName);
        patient.setPatientPassword(patientPassword);
        if (patientRepository.patientContains(patient)) {
            //show patient menu
        }else{
            System.out.println("your account is not exist. ");
        }
    }


}
