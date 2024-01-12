package gr.hua.dit.ds.BloodDonorApp.repository;

import gr.hua.dit.ds.BloodDonorApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);
    User findUserByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    void deleteUserById(int id);
}