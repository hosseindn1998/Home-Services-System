package base.service;

import base.entity.BaseEntity;
import base.exception.NotFoundException;
import base.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseEntity<ID>,
        ID extends Serializable,
        R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {

    protected final R repository;
    private final SessionFactory sessionFactory;


    @Override
    public T saveOrUpdate(T entity) {

        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            T t = repository.saveOrUpdate(entity);
            transaction.commit();
            return t;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert transaction != null;
            transaction.rollback();
            return null;
        }

    }
    @Override
    public T findById(ID id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            T foundEntity = repository.findById(id).get();
            session.getTransaction().commit();
            return foundEntity;
        } catch (Exception e) {
            throw new NotFoundException(String.format("entity with %s not found", id));
        }
    }
    @Override
    public void delete(T t) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            repository.delete(t);
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
        }
    }
    @Override
    public List<T> findAll() {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            List<T> listAll = repository.findAll();
            session.getTransaction().commit();
            session.close();
            return listAll;
        }
        catch (Exception ignored){
            return null;
        }
    }


}
