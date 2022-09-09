package com.cybersoft.DemoSpringBoot.controller;

import com.cybersoft.DemoSpringBoot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    List<User> list = new ArrayList<User>();

    @GetMapping("/add")
    public List addUser(
            @RequestParam("fullName") String fullName,
            @RequestParam("age") int age,
            @RequestParam("gender") boolean gender
    ) {
        User user = new User();
        user.setFullName(fullName);
        user.setAge(age);
        user.setGender(gender);
        list.add(user);
        return list;
    }

    @GetMapping("/{id}/{username}/detail-page")
    public User getDetailUser(
            @PathVariable("id") int id,
            @PathVariable("username") String username) {
        User user = new User();
        System.out.println("User id " + id);
        System.out.println("User name " + username);
        return user;
    }

    @GetMapping("/detail-page")
    public User getDetail(
            @RequestParam("id") int id,
            @RequestParam("username") String username
    ) {
        User user = new User();
        System.out.println("User id " + id);
        System.out.println("User name " + username);
        return user;
    }

    @PostMapping(
            value = "/add-user",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    public User addUser(
            @RequestParam("id") int id,
            @RequestParam("username") String username
    ) {
        User user = new User();
        System.out.println("User id " + id);
        System.out.println("User name " + username);
        return user;
    }

    @PostMapping("/add-user-file")
    public User addUserFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("id") int id,
            @RequestParam("username") String username
    ) {
        User user = new User();
        System.out.println("User id " + id);
        System.out.println("User name " + username);
        return user;
    }

    @PostMapping("/add-json")
    public ResponseEntity<User> addUserJson(
            @RequestBody User user
    ) {
        System.out.println("User name " + user.getFullName());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
