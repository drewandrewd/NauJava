package ru.andrew.NauJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.andrew.NauJava.models.Role;
import ru.andrew.NauJava.models.User;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findById(@Param("id") Long s);

    @Override
    void deleteById(Long s);

    Optional<User> findByName(String name);
}
