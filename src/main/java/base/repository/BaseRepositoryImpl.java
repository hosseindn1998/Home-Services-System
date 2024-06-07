package base.repository;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.Optional;


@AllArgsConstructor
public abstract class BaseRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<T, ID> {
    private SessionFactory sessionFactory;

    @Override
    public T saveOrUpdate(T entity) {
        Session session = sessionFactory.getCurrentSession();
        if (entity.getId() == null)
            session.persist(entity);
        else
            entity = session.merge(entity);
        return entity;
    }
    @Override
    public Optional<T> findById(ID id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(getEntityClass(), id));
    }



    public abstract Class<T> getEntityClass();

    public abstract String getEntity();



}
