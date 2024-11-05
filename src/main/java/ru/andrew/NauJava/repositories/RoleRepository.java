package ru.andrew.NauJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrew.NauJava.models.Role;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для работы с сущностями {@link Role}.
 * Предоставляет методы для выполнения операций с ролями в базе данных.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Сохраняет указанную роль в базе данных.
     *
     * @param entity роль, которую нужно сохранить
     * @param <S> тип роли
     * @return сохранённая роль
     */
    @Override
    public <S extends Role> S save(S entity);

    /**
     * Возвращает все роли из базы данных.
     *
     * @return список всех ролей
     */
    @Override
    public List<Role> findAll();

    /**
     * Удаляет роль по её идентификатору.
     *
     * @param aLong идентификатор роли, которую нужно удалить
     */
    @Override
    void deleteById(Long aLong);

    /**
     * Находит роль по её имени.
     *
     * @param name имя роли
     * @return {@link Optional} с найденной ролью, если такая существует; иначе пустой {@link Optional}
     */
    Optional<Role> findByName(String name);
}
