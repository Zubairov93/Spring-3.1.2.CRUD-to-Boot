package Spring31.Crud_to_Boot.Spring312.controller;


import Spring31.Crud_to_Boot.Spring312.models.User;
import Spring31.Crud_to_Boot.Spring312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.sql.SQLException;

@Controller

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "index";
    }

    @GetMapping("/new")
    public String saveForm(@ModelAttribute("user") User user) {

        return "save";
    }
    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") User user) throws SQLException {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String userInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user-info";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }




}
