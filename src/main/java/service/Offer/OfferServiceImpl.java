package service.Offer;


import base.exception.NotFoundException;
import base.service.BaseServiceImpl;
import model.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.Offer.OfferRepository;

import java.util.List;


public class OfferServiceImpl extends BaseServiceImpl<Offer, Long, OfferRepository> implements OfferService {
    @Override
    public List<Offer> findOfferByTechnicianId(Long technicianId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Offer> result = repository.findOfferByTechnicianId(technicianId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Offer> findOfferByOrderId(Long orderId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Offer> result = repository.findOfferByOrderId(orderId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Offer findByOrderIdAndId(Long orderId, Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Offer result = repository.findByOrderIdAndId(orderId, id).orElseThrow(() -> new NotFoundException("Offer Not found"));
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private final SessionFactory sessionFactory;

    public OfferServiceImpl(OfferRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Boolean isExistsByTechnicianAndOrder(Long technicianId, Long OrderId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Boolean result = repository.isExistsByTechnicianAndOrder(technicianId, OrderId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
