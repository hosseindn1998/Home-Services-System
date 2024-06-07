package service.Service;


import base.service.BaseServiceImpl;
import model.Service;
import org.hibernate.SessionFactory;
import repository.Service.ServiceRepository;


public class ServiceServiceImpl extends BaseServiceImpl<Service, Long, ServiceRepository> implements ServiceService {

    private final SessionFactory sessionFactory;

    public ServiceServiceImpl(ServiceRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

}
