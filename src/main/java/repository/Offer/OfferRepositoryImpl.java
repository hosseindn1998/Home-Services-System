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
    public Class<Offer> getEntityClass() {
        return Offer.class;
    }

    @Override
    public String getEntity() {
        return "Offer";
    }
}
