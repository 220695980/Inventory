package com.example.inventorysales.controller;

import com.example.inventorysales.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private final DashboardService dashboardService;

    public WebController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAllAttributes(dashboardService.getSummary());
        return "dashboard";
    }

    @GetMapping("/inventory")
    public String inventory(Model model) {
        model.addAllAttributes(dashboardService.getSummary());
        return "inventory";
    }

    @GetMapping("/analysis")
    public String analysis(Model model) {
        model.addAllAttributes(dashboardService.getSummary());
        return "analysis";
    }
}
