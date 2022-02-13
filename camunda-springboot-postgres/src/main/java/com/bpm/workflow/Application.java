package com.bpm.workflow;

import com.bpm.workflow.service.MyService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(proxyBeanMethods = false)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner init(final RepositoryService repositoryService,
                                final RuntimeService runtimeService,
                                final TaskService taskService,
                                final MyService myService) {

    return new CommandLineRunner() {
      @Override
      public void run(String... strings) throws Exception {

        myService.createDemoUsers();
       /* System.out.println("Number of process definitions : "
                + repositoryService.createProcessDefinitionQuery().count());
        System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
        System.out.println("Number of tasks after process start: "
                + taskService.createTaskQuery().count());*/
      }
    };
  }
}