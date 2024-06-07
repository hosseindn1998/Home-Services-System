package repository.SubService;

import base.repository.BaseRepository;
import model.SubService;

import java.util.List;
import java.util.Optional;

public interface SubServiceRepository extends BaseRepository<SubService, Long> {
    List<SubService> findSubServicesByServiceId(Long serviceId);

    Optional<SubService> findSubServiceByServiceIdAndSubServiceId(Long serviceId, Long subServiceId);

}
