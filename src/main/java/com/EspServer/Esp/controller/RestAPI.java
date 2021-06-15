package com.EspServer.Esp.controller;

import com.EspServer.Esp.detail_service.detail.AccountDetail;
import com.EspServer.Esp.detail_service.service.AccountDetailService;
import com.EspServer.Esp.email_service.EmailConfig;
import com.EspServer.Esp.entities.AccountEmployee;
import com.EspServer.Esp.entities.Employee;
import com.EspServer.Esp.jwt.JwtRequest;
import com.EspServer.Esp.jwt.JwtUtils;
import com.EspServer.Esp.repository.AccountEmployeeRepository;
import com.EspServer.Esp.repository.AccountRepository;
import com.EspServer.Esp.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestAPI {
    private final EmployeeRepository employeeRepository;
    private final AccountDetailService accountDetailService;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private AccountEmployeeRepository accountEmployeeRepository;

    @Value("${email_to}")
    private String emailTo;


    public RestAPI(EmployeeRepository employeeRepository, AccountDetailService accountDetailService,
                   JwtUtils jwtUtils,
                   AuthenticationManager authenticationManager) {
        this.employeeRepository = employeeRepository;
        this.accountDetailService = accountDetailService;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        System.out.println("ok");

        final AccountDetail userDetails = (AccountDetail) accountDetailService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("get")
    public void get() {
        List<AccountEmployee> list = accountEmployeeRepository.findAll();
        Logger logger = LoggerFactory.getLogger(RestAPI.class.getName());
        logger.info("-------------------");
        list.get(0).getAccount();
        logger.info(list.get(0).getAccount().getAccountName());
    }

    @ResponseBody
    @RequestMapping("/send-email")
    public String sendHtmlEmail(Model model) throws MessagingException {

        List<Employee> list = employeeRepository.findAll();
        model.addAttribute("employee", list);

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<h1>Welcome</h1>"
                + "<img src='https://miro.medium.com/max/850/1*WsfmenxQNE1hhZasxsIGhA.png'>";

        message.setContent(htmlMsg, "text/html");

        helper.setTo(emailTo);

        helper.setSubject("Test Email service");

        this.emailSender.send(message);

        return "Email Sent!";
    }
}
