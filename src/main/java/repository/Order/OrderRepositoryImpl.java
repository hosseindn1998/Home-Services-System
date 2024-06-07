package repository.Order;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order, Long> implements OrderRepository {
    public OrderRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Order> query = session.createQuery("from model.Order o where o.customer.id = : customerId", getEntityClass());
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }



    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }

    @Override
    public String getEntity() {
        return "Order";
    }
}
