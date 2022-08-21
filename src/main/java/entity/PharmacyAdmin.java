package entity;

import java.util.Objects;

public class PharmacyAdmin {

    private int PharmacyAdminId;
    private String adminName;
    private String adminPassword;

    public int getPharmacyAdminId() {
        return PharmacyAdminId;
    }

    public void setPharmacyAdminId(int pharmacyAdminId) {
        PharmacyAdminId = pharmacyAdminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyAdmin that = (PharmacyAdmin) o;
        return PharmacyAdminId == that.PharmacyAdminId && Objects.equals(adminName, that.adminName)
                && Objects.equals(adminPassword, that.adminPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PharmacyAdminId, adminName, adminPassword);
    }

    @Override
    public String toString() {
        return "PharmacyAdmin { " +
                "PharmacyAdminId= " + PharmacyAdminId +
                ", adminName=' " + adminName + '\'' +
                ", adminPassword=' " + adminPassword + '\'' +
                " }";
    }

}
