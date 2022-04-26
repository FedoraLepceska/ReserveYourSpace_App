package com.example.reservespace3.web;

import com.example.reservespace3.model.*;
import com.example.reservespace3.service.CityService;
import com.example.reservespace3.service.SpaceService;
import com.example.reservespace3.service.UserService;
import com.example.reservespace3.service.UserSpacesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/spaces")
public class SpaceController {
    private final SpaceService service;
    private final CityService cityService;
    private final UserService userService;
    private final UserSpacesService userSpacesService;

    public SpaceController(SpaceService service, CityService cityService, UserService userService, UserSpacesService userSpacesService) {
        this.service = service;
        this.cityService = cityService;
        this.userService = userService;
        this.userSpacesService = userSpacesService;
    }

    @GetMapping
    public String getSpacePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Space> spaces = this.service.findAll();
        List<SpaceType> types = Arrays.asList(SpaceType.values());
        model.addAttribute("types", types);
        model.addAttribute("spaces", spaces);
        model.addAttribute("bodyContent", "spaces");
        return "master-template";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSpace(@PathVariable Long id) {
        this.service.deleteById(id);
        return "redirect:/spaces";
    }

    @GetMapping("/edit-form/{id}")
    public String editSpacePage(@PathVariable Long id, Model model) {
        if (this.service.findById(id).isPresent()) {
            Space space = this.service.findById(id).get();
            List<City> cities = this.cityService.listCities();
            List<SpaceType> types = Arrays.asList(SpaceType.values());
            model.addAttribute("types", types);
            model.addAttribute("cities", cities);
            model.addAttribute("space", space);
            model.addAttribute("bodyContent", "add-space");
            return "master-template";
        }
        return "redirect:/spaces?error=SpaceNotFound";
    }

    @GetMapping("/add-form")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addSpacePage(Model model) {
        List<City> cities = this.cityService.listCities();
        List<SpaceType> types = Arrays.asList(SpaceType.values());
        model.addAttribute("types", types);
        model.addAttribute("cities", cities);
        model.addAttribute("bodyContent", "add-space");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveSpace(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam SpaceType type,
            @RequestParam String url) {
        if (id != null) {
            this.service.edit(id, name, address, type, url);
        } else {
            this.service.save(name, address, type, url);
        }
        return "redirect:/spaces";
    }
}
