package repository.Offer;

import base.repository.BaseRepository;
import model.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends BaseRepository<Offer, Long> {
    List<Offer> findOfferByTechnicianId(Long technicianId);

    List<Offer> findOfferByOrderId(Long orderId);

    Optional<Offer> findByOrderIdAndId(Long orderId, Long id);

    Boolean isExistsByTechnicianAndOrder(Long technicianId, Long OrderId);
}
