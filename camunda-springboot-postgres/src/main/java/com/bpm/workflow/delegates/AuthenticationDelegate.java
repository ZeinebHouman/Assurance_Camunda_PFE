package com.bpm.workflow.delegates;

import com.bpm.workflow.controller.userController;
import com.bpm.workflow.repository.userRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationDelegate implements JavaDelegate {
    userRepository user;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
         boolean output ;

        System.out.println("Check login and password");
        System.out.print("login = "+delegateExecution.getVariable("login"));
        System.out.print("password = "+delegateExecution.getVariable("password"));

        if(user.existsByEmail(String.valueOf(delegateExecution.getVariable("login")))){
            output=true;
            delegateExecution.setVariable("output", output);
            System.out.print(output);


        }
        else {
            output=false;
            delegateExecution.setVariable("output", output);
            System.out.print(output);}

    }
}
