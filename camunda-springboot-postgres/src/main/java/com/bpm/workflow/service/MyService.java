package com.bpm.workflow.service;

import com.bpm.workflow.Exception.UserNotFoundException;
import com.bpm.workflow.dto.User;
import com.bpm.workflow.repository.userRepository;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class MyService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private userRepository personRepository;

    public void startProcess(String assignee) {

        User person = personRepository.findByFirstname(assignee);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", person);
        runtimeService.startProcessInstanceByKey("oneTaskProcess", variables);
    }

    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    public void createDemoUsers() {
        if (personRepository.findAll().size() == 0) {
            personRepository.save(new User(1, "zeinebhouman9@gmail.com", "123", "zeineb","houman","dev","123456") );
            personRepository.save(new User(2, "zaaaa@gmail.com", "123", "aaaa","houman","dev","47896333" ));
        }
    }


    public User addUser(User user)
    {
        user.setId(Double.parseDouble(UUID.randomUUID().toString()));
        return personRepository.save(user);
    }

    public List<User> findAllUsers()
    {
        return personRepository.findAll();
    }


    public User updateUser(User employee)
    {
        return personRepository.save(employee);
    }

    public User findUserById(long id)
    {
        return personRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + "was not found"));
    }



    public void deleteUser(Long id){
        personRepository.deleteUserById(id);
    }

    public boolean existUser(String email,String password){
        return personRepository.existsByEmailAndPassword(email,password);
    }


    public User findUserByEmail(String email) {
        return personRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User by email " + email + "was not found"));
    }
}