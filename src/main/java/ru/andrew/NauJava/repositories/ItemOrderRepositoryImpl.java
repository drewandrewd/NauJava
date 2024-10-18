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

@Repository
public class ItemOrderRepositoryImpl implements ItemOrderMappingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public ItemOrderMapping findById(String id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ItemOrderMapping> criteriaQuery = criteriaBuilder.createQuery(ItemOrderMapping.class);
        Root<ItemOrderMapping> userRoot = criteriaQuery.from(ItemOrderMapping.class);
        Predicate namePredicate = criteriaBuilder.equal(userRoot.get("id"), id);
        criteriaQuery.select(userRoot).where(namePredicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        ItemOrderMapping entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
