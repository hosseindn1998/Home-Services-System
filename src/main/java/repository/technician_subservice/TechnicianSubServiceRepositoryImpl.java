package repository.technician_subservice;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.TechnicianSubService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TechnicianSubServiceRepositoryImpl extends BaseRepositoryImpl<TechnicianSubService, Long> implements TechnicianSubServiceRepository {
    private SessionFactory sessionFactory;

    public TechnicianSubServiceRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    @Override
    public Class<TechnicianSubService> getEntityClass() {
        return TechnicianSubService.class;
    }

    @Override
    public String getEntity() {
        return "TechnicianSubService";
    }

    @Override
    public TechnicianSubService find(Long technicianId, Long subServiceId) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<TechnicianSubService> query = session.createQuery("FROM model.TechnicianSubService t  WHERE t.technician.id= : technicianId AND t.subService.id =: subServiceId", TechnicianSubService.class);
        query.setParameter("technicianId", technicianId);
        query.setParameter("subServiceId", subServiceId);
        return query.getSingleResultOrNull();
    }

    @Override
    public Boolean isExist(Long technicianId, Long subServiceId) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<TechnicianSubService> query = session.createQuery("FROM model.TechnicianSubService t  WHERE t.technician.id= : technicianId AND t.subService.id =: subServiceId", TechnicianSubService.class);
        query.setParameter("technicianId", technicianId);
        query.setParameter("subServiceId", subServiceId);
        return query.getSingleResultOrNull() != null;
    }

    @Override
    public List<TechnicianSubService> findByTechnicianId(Long technicianId) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<TechnicianSubService> query = session.createQuery("FROM model.TechnicianSubService t  WHERE t.technician.id= : technicianId", TechnicianSubService.class);
        query.setParameter("technicianId", technicianId);
        return query.getResultList();
    }



}
