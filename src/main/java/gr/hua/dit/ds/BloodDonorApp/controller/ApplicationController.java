package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("")
    public String showApplications(Model model){
        model.addAttribute("applications",applicationService.findApplications());
        return "applications";
    }

    @GetMapping("/new")
    public String addApplication(Model model){
        Application application = new Application();
        model.addAttribute("application",application);
        return "add_application";
    }

    @PostMapping("/new")
    public String saveApplication(Application application,Model model){
        application.setApproved(false);
        applicationService.saveApplication(application);
        return "applications";
    }

}
