package ru.andrew.NauJava.repositories;

public interface CrudRepository<T, ID> {
    ID create(T entity);
    T read(ID id);
    void update(T entity, ID id);
    void delete(ID id);
}
