package com.praktika.worktime.web;

import com.praktika.worktime.persistence.bindings.UserRegisterBindingModel;
import com.praktika.worktime.service.UserService;
import com.praktika.worktime.service.models.UserServiceModel;
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




@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String userRegister(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register.html";
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if (this.userService.existByUsername(userRegisterBindingModel.getUsername())) {
            bindingResult.rejectValue("username", "error.userRegisterBindingModel", "Потребител с това име вече съществува!");
        }
        if (this.userService.existByEmail(userRegisterBindingModel.getEmail())) {
            bindingResult.rejectValue("email", "error.userRegisterBindingModel", "Потребител с този емайл вече съществува!");
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            return "redirect:register";
        }

        try {
            UserServiceModel userServiceModel = this.userService.register(this.modelMapper
                    .map(userRegisterBindingModel, UserServiceModel.class));
            System.out.println();


            return "redirect:login";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel"
                    , bindingResult);
            return "redirect:register";
        }
    }

}