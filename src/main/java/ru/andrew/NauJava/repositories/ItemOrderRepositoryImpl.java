package ru.andrew.NauJava.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.andrew.NauJava.models.ItemOrderMapping;

/**
 * Реализация пользовательского репозитория для работы с сущностями {@link ItemOrderMapping}.
 * Предоставляет методы для сохранения, поиска и удаления связей между товарами и заказами.
 */
@Repository
public class ItemOrderRepositoryImpl implements ItemOrderMappingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Сохраняет указанную связь между товаром и заказом в базе данных.
     *
     * @param entity связь, которую нужно сохранить
     * @return сохранённая связь
     */
    @Override
    @Transactional
    public ItemOrderMapping save(ItemOrderMapping entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    /**
     * Находит связь между товаром и заказом по её идентификатору.
     *
     * @param id идентификатор связи
     * @return найденная связь, если такая существует; иначе {@code null}
     */
    @Override
    public ItemOrderMapping findById(String id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ItemOrderMapping> criteriaQuery = criteriaBuilder.createQuery(ItemOrderMapping.class);
        Root<ItemOrderMapping> itemOrderMappingRoot = criteriaQuery.from(ItemOrderMapping.class);
        Predicate idPredicate = criteriaBuilder.equal(itemOrderMappingRoot.get("id"), id);
        criteriaQuery.select(itemOrderMappingRoot).where(idPredicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    /**
     * Удаляет связь между товаром и заказом по её идентификатору.
     *
     * @param id идентификатор связи, которую нужно удалить
     */
    @Override
    @Transactional
    public void deleteById(String id) {
        ItemOrderMapping entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
