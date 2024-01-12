package gr.hua.dit.ds.BloodDonorApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="profile_id")
    private Profile profile;
    @Column
    @NotBlank
    private boolean hasDisease;
    @Column
    @NotBlank
    private boolean takesMedication;
    @Column
    @NotBlank
    private int bodyWeight ;
    @Column
    @NotBlank
    private String bloodGroup;

    @Column
    @NotBlank
    private boolean isApproved;

    public Application(boolean hasDisease, boolean takesMedication, int bodyWeight, String bloodGroup) {
        this.hasDisease = hasDisease;
        this.takesMedication = takesMedication;
        this.bodyWeight = bodyWeight;
        this.bloodGroup = bloodGroup;
        this.isApproved=false;
    }

    public Application() {
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean isHasDisease() {
        return hasDisease;
    }

    public void setHasDisease(boolean hasDisease) {
        this.hasDisease = hasDisease;
    }

    public boolean isTakesMedication() {
        return takesMedication;
    }

    public void setTakesMedication(boolean takesMedication) {
        this.takesMedication = takesMedication;
    }

    public int getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(int bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Override
    public String toString() {
        return "Application{" +
                "profile=" + profile +
                ", hasDisease=" + hasDisease +
                ", takesMedication=" + takesMedication +
                ", bodyWeight=" + bodyWeight +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }
}
