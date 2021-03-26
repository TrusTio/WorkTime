package com.praktika.worktime.web;

import com.praktika.worktime.persistence.entity.Task;
import com.praktika.worktime.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {
    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Task> taskList = taskService.getAll();
        model.addAttribute("taskList", taskList);

        return "home.html";
    }

    @PostMapping("/task/update/{taskName}/{duration}")
    public String updateTask(@PathVariable("taskName") String taskName, @PathVariable("duration") BigInteger duration){
        Task task = taskService.getByName(taskName).orElseThrow(()-> new RuntimeException("No task found"));
        task.setDuration(duration);
        taskService.save(task);

        Logger logger = Logger.getLogger(HomeController.class.getName());
        logger.info("" +task.getDuration());
        return "home.html";
    }
}
