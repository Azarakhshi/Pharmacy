package service.patient;

import entity.Patient;
import repository.patient.PatientRepository;
import view.useroption.patientoption.PatientOption;

import java.sql.SQLException;

public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    Patient patient = new Patient();
    PatientOption patientOption = new PatientOption();

    public boolean patientNameContains(String patientName) throws SQLException {
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
            patientOption.patientOptions(patient.getPatientName());
        }
    }

    @Override
    public void logIn(String patientName, String patientPassword) throws SQLException {
        patient.setPatientName(patientName);
        patient.setPatientPassword(patientPassword);
        if (patientRepository.patientContains(patient)) {
            patientOption.patientOptions(patient.getPatientName());
        }else{
            System.out.println("your account is not exist. ");
        }
    }


}
