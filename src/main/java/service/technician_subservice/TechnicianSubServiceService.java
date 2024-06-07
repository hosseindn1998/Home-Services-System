package service.technician_subservice;

import base.service.BaseService;
import model.TechnicianSubService;

import java.util.List;

public interface TechnicianSubServiceService extends BaseService<TechnicianSubService, Long> {

    TechnicianSubService find(Long technicianId, Long subServiceId);

    Boolean isExist(Long technicianId, Long subServiceId);

    List<TechnicianSubService> findByTechnicianId(Long technicianId);
}
