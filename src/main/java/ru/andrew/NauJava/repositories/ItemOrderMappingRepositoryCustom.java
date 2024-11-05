package ru.andrew.NauJava.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.andrew.NauJava.models.ItemOrderMapping;

/**
 * Пользовательский репозиторий для работы с сущностями {@link ItemOrderMapping}.
 * Определяет методы для сохранения, поиска и удаления связей между товарами и заказами.
 */
@RepositoryRestResource
public interface ItemOrderMappingRepositoryCustom {

    /**
     * Сохраняет указанную связь между товаром и заказом в базе данных.
     *
     * @param entity связь, которую нужно сохранить
     * @return сохранённая связь
     */
    ItemOrderMapping save(ItemOrderMapping entity);

    /**
     * Находит связь между товаром и заказом по её идентификатору.
     *
     * @param s идентификатор связи
     * @return найденная связь
     */
    ItemOrderMapping findById(String s);

    /**
     * Удаляет связь между товаром и заказом по её идентификатору.
     *
     * @param s идентификатор связи, которую нужно удалить
     */
    void deleteById(String s);
}
