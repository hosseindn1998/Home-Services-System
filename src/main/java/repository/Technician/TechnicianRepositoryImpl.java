package repository.Technician;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.Technician;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TechnicianRepositoryImpl extends BaseRepositoryImpl<Technician, Long> implements TechnicianRepository {
    public TechnicianRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Boolean isExistsByEmail(String email) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Technician> query = session.createQuery("FROM model.Technician t WHERE t.email = :email", getEntityClass());
        query.setParameter("email", email);
        return !query.getResultList().isEmpty();
    }

    @Override
    public Technician authentication(String email, String password) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Technician> query = session.createQuery("FROM model.Technician t WHERE t.email= :email AND t.password = :password", getEntityClass());
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getSingleResultOrNull();
    }

    @Override
    public List<Technician> findAllVerified() {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Technician> query = session.createQuery("FROM model.Technician t WHERE t.technicianStatus = 2", getEntityClass());
        return query.getResultList();
    }

    @Override
    public Class<Technician> getEntityClass() {
        return Technician.class;
    }

    @Override
    public String getEntity() {
        return "Technician";
    }
}
