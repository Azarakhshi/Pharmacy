package entity;

import java.util.Objects;

public class Drugs {

    private int drugsId;
    private String drugName;

    public int getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(int drugsId) {
        this.drugsId = drugsId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drugs drugs = (Drugs) o;
        return drugsId == drugs.drugsId && Objects.equals(drugName, drugs.drugName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugsId, drugName);
    }

    @Override
    public String toString() {
        return "Drugs{ " +
                "drugsId= " + drugsId +
                ", drugName=' " + drugName + '\'' +
                " }";
    }

}
