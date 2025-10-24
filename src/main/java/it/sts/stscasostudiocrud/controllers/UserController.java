package it.sts.stscasostudiocrud.controllers;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.sts.stscasostudiocrud.dtos.UserDto;
import it.sts.stscasostudiocrud.services.UserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String userIndex(Model viewModel) {
        viewModel.addAttribute("title", "tutti gli utenti");
        List<UserDto> users = userService.readAll();
        viewModel.addAttribute("users", users);
        return "/users/users";

    }

    @GetMapping("create")
    public String userCreate(Model viewModel) {

        viewModel.addAttribute("user", new UserDto());
        viewModel.addAttribute("title", "Creazione nuovo utente");
        return "users/create";
    }

    @PostMapping
    public String createUser(
            @Valid @ModelAttribute("user") UserDto userDto,
            BindingResult bindingResult,
            Model viewModel,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            viewModel.addAttribute("title", "Creazione nuovo utente");
            return "users/create";
        }

        userService.create(userDto);
        redirectAttributes.addFlashAttribute("successMessage", "Utente creato con successo!");
        return "redirect:/users";
    }

    @GetMapping("/detail/{id}")
    public String detailUser(@PathVariable("id") Long id, Model viewModel) {
        viewModel.addAttribute("title", "Dettaglio Utente");
        viewModel.addAttribute("user", userService.read(id));
        return "users/detail";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model viewModel) {
        viewModel.addAttribute("title", "Modifica Utente");
        viewModel.addAttribute("user", userService.read(id));
        return "users/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("user") UserDto userDto,
            BindingResult result, Model viewModel, RedirectAttributes redirectAttributes,
            Principal principal) {

        if (result.hasErrors()) {
            viewModel.addAttribute("title", "User Update");
            viewModel.addAttribute("user", userDto);
            return "users/edit";
        }
        userService.update(id, userDto);
        redirectAttributes.addFlashAttribute("successMessage", "Utente modificato con successo");
        return "redirect:/users";

    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        userService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Utente cancellato con successo");
        return "redirect:/users";
    }

}
