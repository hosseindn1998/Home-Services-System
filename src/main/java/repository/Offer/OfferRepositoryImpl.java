package repository.Offer;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class OfferRepositoryImpl extends BaseRepositoryImpl<Offer, Long> implements OfferRepository {
    public OfferRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Offer> findOfferByTechnicianId(Long technicianId) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Offer> query = session.createQuery("from model.Offer o where o.technician.id = : technicianId", getEntityClass());
        query.setParameter("technicianId", technicianId);
        return query.getResultList();
    }

    @Override
    public List<Offer> findOfferByOrderId(Long orderId) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Offer> query = session.createQuery("from model.Offer o where o.odrer.id = : orderId", getEntityClass());
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    @Override
    public Optional<Offer> findByOrderIdAndId(Long orderId, Long id) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Offer> query = session.createQuery("from model.Offer o where o.odrer.id = : orderId and o.id = :id", getEntityClass());
        query.setParameter("orderId", orderId);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }



    @Override
    public Class<Offer> getEntityClass() {
        return Offer.class;
    }

    @Override
    public String getEntity() {
        return "Offer";
    }
}
