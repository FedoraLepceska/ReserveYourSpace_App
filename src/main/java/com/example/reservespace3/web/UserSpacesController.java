package com.example.reservespace3.web;

import com.example.reservespace3.model.UserReservedSpaces;
import com.example.reservespace3.service.UserSpacesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mySpaces")
public class UserSpacesController {
    private final UserSpacesService userSpacesService;

    public UserSpacesController(UserSpacesService userSpacesService) {
        this.userSpacesService = userSpacesService;
    }

    @GetMapping
    public String getUserSpaces(HttpServletRequest req, Model model){
        String username = req.getRemoteUser();
        UserReservedSpaces userReservedSpaces =this.userSpacesService.getActiveUserSpaces(username);
        model.addAttribute("spaces", this.userSpacesService.listAllSpaces(userReservedSpaces.getId()));
        model.addAttribute("bodyContent", "mySpaces");
        return "master-template";
    }

    @PostMapping("/add-user-space/{id}")
    public String addSpaceToUserSpaces(@PathVariable Long id, HttpServletRequest req){
//        try {
            String username = req.getRemoteUser();
            this.userSpacesService.addSpaceToUserSpaces(id, username);
            return "redirect:/mySpaces";
//        } catch (RuntimeException exception) {
//            return "redirect:/mySpaces?error=" + exception.getMessage();
//        }
    }
}
