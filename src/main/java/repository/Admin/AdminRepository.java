package repository.Admin;

import base.repository.BaseRepository;
import model.Admin;

public interface AdminRepository extends BaseRepository<Admin, Long> {
    Admin authentication(String email, String password);
}
