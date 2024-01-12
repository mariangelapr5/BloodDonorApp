package gr.hua.dit.ds.BloodDonorApp.controller;

import gr.hua.dit.ds.BloodDonorApp.entity.Profile;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.service.ProfileService;
import gr.hua.dit.ds.BloodDonorApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfilController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("")
    public String showProfiles(Model model){
        model.addAttribute("profiles",profileService.getProfiles());
        return "profiles";
    }

    @GetMapping("/{id}")
    public String showProfile(@PathVariable int id,Model model){
        model.addAttribute("profile",profileService.getProfile(id));
        return "myProfile";
    }

    @GetMapping("/new")
    public String addProfile(Model model){
        Profile profile = new Profile();
        model.addAttribute("profile",profile);
        return "add_profile";
    }

    @PostMapping("/new")
    public String saveProfile(Profile profile,Model model) {
        User user = profileService.getUserByEmail(profile.getEmail());
        profile.setUser(user);
        model.addAttribute("profile",profile);
        profileService.saveProfile(profile);
        return "myProfile";
    }


    @GetMapping("/{id}/edit")
    public String editProfile(@PathVariable int id, Model model){
        Profile old= profileService.getProfile(id);
        profileService.deleteProfile(id);
        model.addAttribute("profile",old);
        return "add_profile";
    }
    
    @GetMapping("/{profile_id}/delete")
    public String deleteProfileAndUser(@PathVariable int profile_id){
        profileService.deleteProfile(profile_id);
        return "home";
    }



}
