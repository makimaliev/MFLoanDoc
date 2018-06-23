package kg.gov.mf.loan.doc.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Override
    public String generateRegistrationNumber() {
        return "ДОК-" + new Random().nextInt(100);
    }

    @Override
    public String generateInternalRegistrationNumber() {
        return "ДОК-" + new Random().nextInt(100);
    }

    @Override
    public String generateIncomingRegistrationNumber() {
        return "ВХ-" + new Random().nextInt(100);
    }

    @Override
    public String generateOutgoingRegistrationNumber() {
        return "ИХ-" + new Random().nextInt(100);
    }

    @Override
    public String generateArchiveRegistrationNumber() {
        return "АХВ-" + new Random().nextInt(100);
    }
}
