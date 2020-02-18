package stationary.store.service.offer;

import stationary.store.model.Offer;

import java.util.List;


public interface OfferService {

    List<Offer> getOffers();

    void saveOffer(Offer theOffer);

    Offer getOffer(int theId);

    void deleteOffer(int theId);

}
