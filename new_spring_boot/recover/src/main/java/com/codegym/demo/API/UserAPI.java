package com.codegym.demo.API;

import com.codegym.demo.Model.PasswordResetCode;
import com.codegym.demo.Model.User;
import com.codegym.demo.Service.PasswordResetCodeService;
import com.codegym.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Random;

@RestController
public class UserAPI {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordResetCodeService passwordResetCodeService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }

    @GetMapping("/users/verify/email/{email}")
    public ResponseEntity<Void> sendMailRecover(@PathVariable("email") String email) {
        User currentUser = userService.findByEmail(email);
        if (currentUser == null) {
            System.out.println("User with email " + email + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        String content;
        String text;
        int code;
        code = getRandomIntegerWithinRange(100000, 999999);
        PasswordResetCode passwordResetCode = new PasswordResetCode();
        passwordResetCode.setUser(currentUser);
        passwordResetCode.setCode(String.valueOf(code));
        passwordResetCodeService.save(passwordResetCode);
        content = "Yêu Cầu Thay Đổi Mật Khẩu";
        text = "Chào quý khách,\n" +
                "webdaugiac03.vn đã nhận được yêu cầu thay đổi mật khẩu của quý khách.\n" +
                "\n" +
                "Mã xác thực của quý khách là : " + code;
        System.out.println("Sending Email...");
        try {

            sendEmail(email, content, text);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/users/verify/email/{email}/{code}")
    public ResponseEntity<Void> checkCodeRecover(@PathVariable("email") String email, @PathVariable("code") String code) {
        String content;
        String text;
        String newPassword;
        User currentUser = userService.findByEmail(email);

        if (currentUser == null) {
            System.out.println("User with email " + email + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        if (!currentUser.getPasswordResetCode().getCode().equals(code)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        newPassword = RandomStringUtils.randomAlphanumeric(10);
       currentUser.setPassword(newPassword);
       userService.save(currentUser);
       passwordResetCodeService.remove(currentUser.getPasswordResetCode().getId());
        content = "Yêu Cầu Thay Đổi Mật Khẩu";
        text = "Chào quý khách,\n" +
                "Mật Khẩu của quý khách đã được thay đổi thành công.\n" +
                "\n" +
                "Mật Khẩu Mới của quý khách là : " + newPassword;
        System.out.println("Sending Email...");
        try {

            sendEmail(email, content, text);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    private void sendEmail(String email, String content, String text) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject(content);
        msg.setText(text);

        javaMailSender.send(msg);

    }

    private int getRandomIntegerWithinRange(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        System.out.println("User With Id :" + id);
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/users/search/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        System.out.println("User With Email :" + email);
        User user = userService.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        userService.save(user);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/Users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        User currentUser = userService.findById(id);

        if (currentUser == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.save(user);

        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }


}
