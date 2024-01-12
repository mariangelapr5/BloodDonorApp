package gr.hua.dit.ds.BloodDonorApp.service;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.Profile;
import gr.hua.dit.ds.BloodDonorApp.repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Transactional
    public Application getApplicationById(int application_id){
        return applicationRepository.findApplicationById(application_id);
    }

    @Transactional
    public Application getApplicationByProfile(Profile profile){
        return applicationRepository.findApplicationByProfile(profile);
    }

    @Transactional
    public List<Application> getNonApprovedApplications(){
        return applicationRepository.findApplicationsByApprovedFalse();
    }

    @Transactional
    public void deleteApprovedApplications(){
        applicationRepository.deleteApplicationByApprovedIsTrue();
    }

    @Transactional
    public void deleteApplicationById(int application_id){
        applicationRepository.deleteApplicationById(application_id);
    }

    @Transactional
    public void deleteApplicationByProfile(Profile profile){
        applicationRepository.deleteApplicationByProfile(profile);
    }

    @Transactional
    public List<Application> findApplications(){
        return applicationRepository.findAll();
    }

    @Transactional
    public void saveApplication(Application application){
        applicationRepository.save(application);
    }
}
