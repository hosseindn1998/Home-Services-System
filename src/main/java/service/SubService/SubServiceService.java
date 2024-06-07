package service.SubService;

import base.service.BaseService;
import model.SubService;

import java.util.List;

public interface SubServiceService extends BaseService<SubService, Long> {

    List<SubService> findSubServicesByServiceId(Long serviceId);

    SubService findSubServiceByServiceIdAndSubServiceId(Long serviceId, Long subServiceId);
}
