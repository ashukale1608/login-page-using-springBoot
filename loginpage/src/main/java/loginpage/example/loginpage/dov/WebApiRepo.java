package loginpage.example.loginpage.dov;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import loginpage.example.loginpage.model.WebApi;

public interface WebApiRepo extends JpaRepository <WebApi , Integer> {

    Optional<WebApi> findByName(String name);
    
}
