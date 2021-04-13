package com.klservices.tasklist;

import com.klservices.tasklist.domain.Task;
import com.klservices.tasklist.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class TasklistApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasklistApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TaskService taskService){
        return args -> {
            taskService.save(new Task(1L, "get the boot going", LocalDate.now(), true));
            taskService.save(new Task(2L, "feed the boot", LocalDate.now().plus(1, ChronoUnit.DAYS), false));
            taskService.save(new Task(3L, "watch the boot", LocalDate.now().plus(2, ChronoUnit.DAYS), false));
            taskService.save(new Task(4L, "launch the h2 console", LocalDate.now().plus(3, ChronoUnit.DAYS), false));
            taskService.save(new Task(5L, "set configuration properties", LocalDate.now().plus(4, ChronoUnit.DAYS), false));
            taskService.save(new Task(6L, "run the spring boot application", LocalDate.now().plus(5, ChronoUnit.DAYS), false));
        };
    }

}
