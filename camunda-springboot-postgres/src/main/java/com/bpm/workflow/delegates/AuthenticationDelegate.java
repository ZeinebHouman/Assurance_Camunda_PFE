package com.bpm.workflow.delegates;

import com.bpm.workflow.Application;
import com.bpm.workflow.controller.userController;
import com.bpm.workflow.repository.userRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationDelegate implements JavaDelegate {
    @Autowired
    private userController user;
    @Autowired
    private Application v;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
         boolean output ;


        System.out.print("login = "+delegateExecution.getVariable("login"));
        System.out.print("password = "+delegateExecution.getVariable("password"));

        if(user.existsUserByEmailAndPassword((String) delegateExecution.getVariable("login"),(String) delegateExecution.getVariable("password"))){
            output=true;
            delegateExecution.setVariable("output", output);
            System.out.print(output);


        }
        else {

            output=false;
            delegateExecution.setVariable("output", output);
         //  delegateExecution.setVariable("attempts", v.getAttempts());
            System.out.print(output);
       //     System.out.print( v.getAttempts());
        }

    }
}
