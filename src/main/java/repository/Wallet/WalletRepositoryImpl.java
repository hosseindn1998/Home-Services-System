package repository.Wallet;

import base.repository.BaseRepositoryImpl;
import model.Wallet;
import org.hibernate.SessionFactory;

public class WalletRepositoryImpl extends BaseRepositoryImpl<Wallet, Long> implements WalletRepository {
    public WalletRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return Wallet.class;
    }

    @Override
    public String getEntity() {
        return "Wallet";
    }
}
