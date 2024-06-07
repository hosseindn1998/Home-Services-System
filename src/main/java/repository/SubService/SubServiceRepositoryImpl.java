package repository.SubService;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.SubService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubService, Long> implements SubServiceRepository {
    public SubServiceRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<SubService> findSubServicesByServiceId(Long serviceId) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<SubService> query = session.createQuery("from model.SubService s where s.service.id = : serviceId", getEntityClass());
        query.setParameter("serviceId", serviceId);
        return query.getResultList();
    }

    @Override
    public Optional<SubService> findSubServiceByServiceIdAndSubServiceId(Long serviceId, Long subServiceId) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<SubService> query = session.createQuery("from model.SubService s where s.service.id = : serviceId and s.id = :id", getEntityClass());
        query.setParameter("serviceId", serviceId);
        query.setParameter("id", subServiceId);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }

    @Override
    public String getEntity() {
        return "SubService";
    }
}
