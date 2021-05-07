package org.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main_page")
public class CafeManagementController {

    @GetMapping
    public String showMainPage() {
        return "main_page";
    }
}
