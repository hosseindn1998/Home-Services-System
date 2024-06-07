package repository.technician_subservice;

import base.repository.BaseRepository;
import model.TechnicianSubService;

import java.util.List;

public interface TechnicianSubServiceRepository extends BaseRepository<TechnicianSubService, Long> {
TechnicianSubService find(Long technicianId, Long subServiceId);
Boolean isExist(Long technicianId,Long subServiceId);
List<TechnicianSubService> findByTechnicianId(Long technicianId);
}
