package repository.Order;

import base.repository.BaseRepository;
import model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends BaseRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);

    Optional<Order> findByCustomerIdAndId(Long customerId, Long id);
}
