package gr.hua.dit.ds.BloodDonorApp.repository;

import gr.hua.dit.ds.BloodDonorApp.entity.Application;
import gr.hua.dit.ds.BloodDonorApp.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    Application findApplicationByProfile(Profile profile);
    Application findApplicationById(int id);
    List<Application> findApplicationsByApprovedFalse();

    void deleteApplicationByApprovedIsTrue();
    void deleteApplicationById(int id);
    void deleteApplicationByProfile(Profile profile);
}
