package kg.gov.mf.loan.doc.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Override
    public String generateRegistrationNumber() {
        return "DOCR-" + new Random().nextInt(100);
    }
}
