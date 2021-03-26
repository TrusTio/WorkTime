package com.praktika.worktime.web;

import com.praktika.worktime.persistence.bindings.TaskAddBindingModel;
import com.praktika.worktime.persistence.entity.Task;
import com.praktika.worktime.service.TaskService;
import com.praktika.worktime.service.models.TaskServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final ModelMapper modelMapper;
    private final TaskService taskService;

    public TaskController(ModelMapper modelMapper, TaskService taskService) {
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }

    @GetMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public String addTool(Model model) {
        if (!model.containsAttribute("taskAddBindingModel")) {
            model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());

        }
        return "add-task";
    }

    @GetMapping("/completed")
    @PreAuthorize("isAuthenticated()")
    public String completedTasks(Model model) {
        System.out.println();
        List<Task> completedTaskList = taskService.getAllCompleted();
        System.out.println();
        model.addAttribute("completedTaskList",completedTaskList);
        return "completed-tasks";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addToolConfirm(@Valid @ModelAttribute("taskAddBindingModel") TaskAddBindingModel taskAddBindingModel, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) throws IOException {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel"
                    , bindingResult);
            return "redirect:add";
        }


        TaskServiceModel taskServiceModel = modelMapper.map(taskAddBindingModel, TaskServiceModel.class);

        taskService.save(taskServiceModel);

        return "redirect:add";
    }


}
