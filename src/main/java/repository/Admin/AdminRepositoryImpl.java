package repository.Admin;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long> implements AdminRepository {
    public AdminRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Admin authentication(String email, String password) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Admin> query = session.createQuery("FROM model.Admin a WHERE a.email= :email AND a.password = :password", getEntityClass());
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getSingleResultOrNull();
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    public String getEntity() {
        return "Admin";
    }
}
