package service.Wallet;


import base.service.BaseServiceImpl;
import model.Wallet;
import org.hibernate.SessionFactory;
import repository.Wallet.WalletRepository;


public class WalletServiceImpl extends BaseServiceImpl<Wallet, Long, WalletRepository> implements WalletService {

    private final SessionFactory sessionFactory;

    public WalletServiceImpl(WalletRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

}
