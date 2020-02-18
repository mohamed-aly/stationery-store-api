package stationary.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.OfferDAO;
import stationary.store.model.Offer;

import java.util.List;


@Service
public class OfferServiceImpl implements OfferService {

    // need to inject Offer dao
    @Autowired
    private OfferDAO offerDAO;

    @Override
    @Transactional
    public List<Offer> getOffers() {
        return offerDAO.getOffers();
    }

    @Override
    @Transactional
    public void saveOffer(Offer theOffer) {

        offerDAO.saveOffer(theOffer);
    }

    @Override
    @Transactional
    public Offer getOffer(int theId) {

        return offerDAO.getOffer(theId);
    }

    @Override
    @Transactional
    public void deleteOffer(int theId) {

        offerDAO.deleteOffer(theId);
    }
}





