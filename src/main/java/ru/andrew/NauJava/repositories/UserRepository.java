package ru.andrew.NauJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.andrew.NauJava.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User WHERE u.id =:id")
    Optional<User> findById(@Param("id") String s);

    @Override
    void deleteById(String s);
}
