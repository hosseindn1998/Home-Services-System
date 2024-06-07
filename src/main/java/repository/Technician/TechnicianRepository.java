package repository.Technician;

import base.repository.BaseRepository;
import model.Technician;

import java.util.List;

public interface TechnicianRepository extends BaseRepository<Technician, Long> {
    Boolean isExistsByEmail(String email);

    Technician authentication(String email, String password);

    List<Technician> findAllVerified();
}
