package entity;

import java.util.Objects;

public class Prescriptions {

    private int PrescriptionsId;
    private String patientsName;
    private String drugsName;
    private int quantity;
    private int price;
    private boolean isConfirm;
    private boolean doesExist;
    private int TOTAL_PRICE;

    public void setTOTAL_PRICE(int TOTAL_PRICE) {
        this.TOTAL_PRICE = TOTAL_PRICE;
    }

    private int prescriptionsIdOrder;

    public int getPrescriptionsIdOrder() {
        return prescriptionsIdOrder;
    }

    public void setPrescriptionsIdOrder(int prescriptionsIdOrder) {
        this.prescriptionsIdOrder = prescriptionsIdOrder;
    }

    public int getPrescriptionsId() {
        return PrescriptionsId;
    }

    public void setPrescriptionsId(int prescriptionsId) {
        PrescriptionsId = prescriptionsId;
    }

    public String getPatientsName() {
        return patientsName;
    }

    public void setPatientsName(String patientsName) {
        this.patientsName = patientsName;
    }

    public String getDrugsName() {
        return drugsName;
    }

    public void setDrugsName(String drugsName) {
        this.drugsName = drugsName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    public boolean isDoesExist() {
        return doesExist;
    }

    public void setDoesExist(boolean doesExist) {
        this.doesExist = doesExist;
    }

    public int getTOTAL_PRICE() {
        return TOTAL_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescriptions that = (Prescriptions) o;
        return PrescriptionsId == that.PrescriptionsId && quantity == that.quantity &&
                price == that.price && isConfirm == that.isConfirm && doesExist == that.doesExist &&
                TOTAL_PRICE == that.TOTAL_PRICE && prescriptionsIdOrder == that.prescriptionsIdOrder &&
                Objects.equals(patientsName, that.patientsName) && Objects.equals(drugsName, that.drugsName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PrescriptionsId, patientsName, drugsName, quantity,
                price, isConfirm, doesExist, TOTAL_PRICE, prescriptionsIdOrder);
    }

    @Override
    public String toString() {
        return "Prescriptions{ " +
                "PrescriptionsId= " + PrescriptionsId +
                ", patientsName= '" + patientsName + '\'' +
                ", drugsName= '" + drugsName + '\'' +
                ", quantity= " + quantity +
                ", price= " + price +
                ", isConfirm= " + isConfirm +
                ", doesExist= " + doesExist +
                ", TOTAL_PRICE= " + TOTAL_PRICE +
                ", prescriptionsIdOrder= " + prescriptionsIdOrder +
                " }";
    }
}
