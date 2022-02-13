package com.bpm.workflow.controller;

import com.bpm.workflow.dto.User;
import com.bpm.workflow.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    @Autowired
    private MyService myService;

    @PostMapping(value="/process")
    public void startProcessInstance(@RequestBody StartProcessRepresentation startProcessRepresentation) {
        myService.startProcess(startProcessRepresentation.getAssignee());
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = myService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
    {
        User user = (User) myService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @GetMapping("/findEmail")
    public ResponseEntity<User> getUserByEmail(String email)
    {
        User user = myService.findUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        User newEmployee = myService.addUser(user);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<User>updateUser(@RequestBody User user)
    {
        User newEmployee = myService.updateUser(user);
        return new ResponseEntity<>(newEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable("id") Long id)
    {
        myService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





    static class StartProcessRepresentation {

        private String assignee;

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }



    }}