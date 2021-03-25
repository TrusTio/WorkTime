package com.praktika.worktime.web;

import com.praktika.worktime.persistence.entity.Task;
import com.praktika.worktime.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
