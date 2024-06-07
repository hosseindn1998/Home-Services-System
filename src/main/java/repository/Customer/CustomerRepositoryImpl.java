package repository.Customer;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {
    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Boolean isExistsByEmail(String email) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer c WHERE c.email = :email", getEntityClass());
        query.setParameter("email", email);
        return !query.getResultList().isEmpty();
    }



    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public String getEntity() {
        return "Customer";
    }
}
