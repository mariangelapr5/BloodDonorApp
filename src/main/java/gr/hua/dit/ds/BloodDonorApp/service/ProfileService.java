package gr.hua.dit.ds.BloodDonorApp.service;


import gr.hua.dit.ds.BloodDonorApp.entity.Profile;
import gr.hua.dit.ds.BloodDonorApp.entity.User;
import gr.hua.dit.ds.BloodDonorApp.repository.ProfileRepository;
import gr.hua.dit.ds.BloodDonorApp.repository.RoleRepository;
import gr.hua.dit.ds.BloodDonorApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    @Transactional
    public void saveProfile(Profile profile){
        profileRepository.save(profile);
    }

    @Transactional
    public void deleteProfile(int id){
        profileRepository.deleteById(id);
    }

    @Transactional
    public Profile getProfile(int id){
        return profileRepository.findById(id).get();
    }

    @Transactional
    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

}
