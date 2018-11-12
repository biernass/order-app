package pl.mb.soft.orderapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmailServiceImplTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void shouldSendMail(){
        emailService.send("biernass@gmail.com", "test-title", "test-body-of-mail");
    }

}