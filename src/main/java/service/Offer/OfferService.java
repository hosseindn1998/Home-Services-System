package service.Offer;

import base.service.BaseService;
import model.Offer;

import java.util.List;

public interface OfferService extends BaseService<Offer, Long> {
    List<Offer> findOfferByTechnicianId(Long technicianId);

    List<Offer> findOfferByOrderId(Long orderId);

    Offer findByOrderIdAndId(Long orderId, Long id);

    Boolean isExistsByTechnicianAndOrder(Long technicianId, Long OrderId);
}
