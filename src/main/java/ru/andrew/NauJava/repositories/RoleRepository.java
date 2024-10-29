package ru.andrew.NauJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrew.NauJava.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    public <S extends Role> S save(S entity);

    @Override
    public List<Role> findAll();

    @Override
    void deleteById(Long aLong);

    Optional<Role> findByName(String name);
}
