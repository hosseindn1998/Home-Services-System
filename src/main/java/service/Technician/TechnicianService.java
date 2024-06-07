package service.Technician;

import base.service.BaseService;
import model.Technician;

import java.util.List;

public interface TechnicianService extends BaseService<Technician, Long> {
    Boolean isExistsByEmail(String email);

    Technician authentication(String email, String password);

    List<Technician> findAllVerified();

}
