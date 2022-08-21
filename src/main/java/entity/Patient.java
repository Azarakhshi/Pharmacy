package entity;

import java.util.Objects;

public class Patient {

    private int PatientId;
    private String patientName;
    private String patientPassword;

    public int getPatientId() {
        return PatientId;
    }

    public void setPatientId(int patientId) {
        this.PatientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return PatientId == patient.PatientId && Objects.equals(patientName, patient.patientName) && Objects.equals(patientPassword, patient.patientPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PatientId, patientName, patientPassword);
    }

    @Override
    public String toString() {
        return "Patient{ " +
                "id= " + PatientId +
                ", patientName=' " + patientName + '\'' +
                ", patientPassword=' " + patientPassword + '\'' +
                " }";
    }

}
