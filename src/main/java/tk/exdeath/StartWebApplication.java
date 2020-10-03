package tk.exdeath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.exdeath.model.service.LessonService;
import tk.exdeath.model.service.UserService;

@SpringBootApplication
public class StartWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartWebApplication.class, args);
    }
}
