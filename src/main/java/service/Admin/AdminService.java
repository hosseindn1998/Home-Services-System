package service.Admin;

import base.service.BaseService;
import model.Admin;

public interface AdminService extends BaseService<Admin,Long> {

    Admin authentication(String email, String password);
}
