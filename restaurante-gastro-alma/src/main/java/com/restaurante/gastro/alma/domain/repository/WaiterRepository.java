package com.restaurante.gastro.alma.domain.repository;
import com.restaurante.gastro.alma.domain.Waiter;
import java.util.List;
import java.util.Optional;

public interface WaiterRepository {

    List<Waiter> getAll();
    Waiter saveWaiter(Waiter waiter);
    void deleteWaiter(int waiterId);
    Optional<Waiter> getByID(int waiterId);

}
