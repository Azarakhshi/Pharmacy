package service.prescriptions;

import entity.Prescriptions;
import repository.prescriptions.PrescriptionsRepository;

import java.sql.SQLException;

public class PrescriptionsServiceImpl implements PrescriptionsService{
    private PrescriptionsRepository prescriptionsRepository;

    public PrescriptionsServiceImpl(PrescriptionsRepository prescriptionsRepository) {
        this.prescriptionsRepository = prescriptionsRepository;
    }

    @Override
    public int findPrescriptionsId() throws SQLException {
        return (prescriptionsRepository.lastPrescriptionsId() + 1);
    }

    @Override
    public void addDrugtoPrescriptions(Prescriptions prescriptions) throws SQLException {
        prescriptionsRepository.save(prescriptions);
    }
}
