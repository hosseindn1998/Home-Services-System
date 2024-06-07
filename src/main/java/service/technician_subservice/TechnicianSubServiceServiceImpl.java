package service.technician_subservice;


import base.service.BaseServiceImpl;
import model.TechnicianSubService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.technician_subservice.TechnicianSubServiceRepository;

import java.util.List;


public class TechnicianSubServiceServiceImpl extends BaseServiceImpl<TechnicianSubService, Long, TechnicianSubServiceRepository> implements TechnicianSubServiceService {

    private final SessionFactory sessionFactory;

    public TechnicianSubServiceServiceImpl(TechnicianSubServiceRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TechnicianSubService find(Long technicianId, Long subServiceId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            TechnicianSubService result = repository.find(technicianId, subServiceId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<TechnicianSubService> findByTechnicianId(Long technicianId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<TechnicianSubService> result = repository.findByTechnicianId(technicianId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean isExist(Long technicianId, Long subServiceId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Boolean result = repository.isExist(technicianId, subServiceId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
