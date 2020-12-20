package jp.project.fab.service;

import jp.project.fab.config.EmailConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Properties;


@Service
public class EmailService implements IEmailService{

    private static final Logger LOG =LogManager.getLogger(EmailService .class.getSimpleName());

    @Autowired
    private Environment env;

    @Autowired
    private EmailConfig conf;


    @GetMapping("/testSendMail")
    public String sendMail(){
        //create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(conf.getHost());
        System.out.println(mailSender.getHost());
        mailSender.setPort(conf.getPort());
        System.out.println(mailSender.getPort());
        mailSender.setUsername(conf.getUsername());
        System.out.println(mailSender.getUsername());
        mailSender.setPassword(conf.getPassword());
        System.out.println(mailSender.getPassword());

        //create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(conf.getFrom());
        mailMessage.setTo("hervanenkomo@gmail.com");
        mailMessage.setSubject("yes je l'ai fait !");
        mailMessage.setText("Jedis hein, viens dormir! c'est comment? j'ai froid!'");

        //send mail
        mailSender.setJavaMailProperties(getMailSenderProperties());
        mailSender.send(mailMessage);

        return "successfully send email";
    }

    private Properties getMailSenderProperties(){
        Properties props = new Properties();
        props.put("mail.transport.protocol", conf.getProtocol());
        props.put("mail.smtp.auth", conf.isAuth());
        props.put("mail.smtp.starttls.enable", conf.isStarttls());
        props.put("mail.debug", conf.isDebug());

        return props;
    }
}
