package service.Customer;

import base.service.BaseService;
import model.Customer;

public interface CustomerService extends BaseService<Customer, Long> {
    Boolean isExistsByEmail(String email);
    Customer authentication(String email, String password);

}
