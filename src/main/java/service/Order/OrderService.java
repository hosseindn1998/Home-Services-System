package service.Order;

import base.service.BaseService;
import model.Order;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
    Order findByCustomerIdAndId(Long customerId, Long id);

}
