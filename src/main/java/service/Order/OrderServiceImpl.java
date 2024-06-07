package service.Order;


import base.exception.NotFoundException;
import base.service.BaseServiceImpl;
import model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.Order.OrderRepository;

import java.util.List;

public class OrderServiceImpl extends BaseServiceImpl<Order, Long, OrderRepository> implements OrderService {

    private final SessionFactory sessionFactory;

    public OrderServiceImpl(OrderRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Order> result = repository.findByCustomerId(customerId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Order findByCustomerIdAndId(Long customerId, Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Order result = repository.findByCustomerIdAndId(customerId, id)
                    .orElseThrow(() -> new NotFoundException("Order Not found"));
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
