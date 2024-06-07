package service.SubService;


import base.exception.NotFoundException;
import base.service.BaseServiceImpl;
import model.SubService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.SubService.SubServiceRepository;

import java.util.List;


public class SubServiceServiceImpl extends BaseServiceImpl<SubService, Long, SubServiceRepository> implements SubServiceService {
    @Override
    public List<SubService> findSubServicesByServiceId(Long serviceId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<SubService> result = repository.findSubServicesByServiceId(serviceId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public SubService findSubServiceByServiceIdAndSubServiceId(Long serviceId, Long subServiceId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            SubService result = repository.findSubServiceByServiceIdAndSubServiceId(serviceId, subServiceId)
                    .orElseThrow(() -> new NotFoundException("SubService Not found"));
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private final SessionFactory sessionFactory;

    public SubServiceServiceImpl(SubServiceRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

}
