package com.bpm.workflow.delegates;

import com.bpm.workflow.controller.userController;
import com.bpm.workflow.dto.User;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class signupDelegate implements JavaDelegate {
    @Autowired
    private userController userController;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email= (String) delegateExecution.getVariable("email");
        String password= (String) delegateExecution.getVariable("password");
        String jobTitle= (String) delegateExecution.getVariable("jobTitle");
        String firstName= (String) delegateExecution.getVariable("firstname");
        String lastName= (String) delegateExecution.getVariable("lastname");
        String phone= (String) delegateExecution.getVariable("phone");
        System.out.println(email);
        User user =new User(1.0,email,password,firstName,lastName,jobTitle,phone);
        System.out.println("okkk");
        userController.addUser(user);
        System.out.println("okkk2222");

    }
}
