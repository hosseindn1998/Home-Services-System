package repository.Customer;

import base.repository.BaseRepository;
import model.Customer;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
    Boolean isExistsByEmail(String email);
   Customer authentication(String email, String password);
}
