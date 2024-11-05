package ru.andrew.NauJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.andrew.NauJava.models.User;

import java.util.Optional;

/**
 * Репозиторий для работы с сущностями {@link User}.
 * Предоставляет методы для выполнения операций с пользователями в базе данных.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Находит пользователя по его идентификатору.
     *
     * @param id идентификатор пользователя
     * @return {@link Optional} с найденным пользователем, если такой существует; иначе пустой {@link Optional}
     */
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findById(@Param("id") Long s);

    /**
     * Удаляет пользователя по его идентификатору.
     *
     * @param id идентификатор пользователя, которого нужно удалить
     */
    @Override
    void deleteById(Long s);

    /**
     * Находит пользователя по его имени.
     *
     * @param name имя пользователя
     * @return {@link Optional} с найденным пользователем, если такой существует; иначе пустой {@link Optional}
     */
    Optional<User> findByName(String name);
}
