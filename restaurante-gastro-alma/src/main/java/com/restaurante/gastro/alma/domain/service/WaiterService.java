package com.restaurante.gastro.alma.domain.service;

import com.restaurante.gastro.alma.domain.Order;
import com.restaurante.gastro.alma.domain.Waiter;
import com.restaurante.gastro.alma.domain.repository.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaiterService {

    @Autowired
    private WaiterRepository waiterRepository;

    public List<Waiter> getAll() {
        try {
            return waiterRepository.getAll();
        } catch (Exception e) {
            // Manejar la excepción
            System.err.println("Error al obtener los meseros: " + e.getMessage());
            return null; // o lanzar una excepción personalizada
        }
    }

    public Waiter save(Waiter waiter) {
        try {
            return waiterRepository.saveWaiter(waiter);
        } catch (Exception e) {
            // Manejar la excepción
            System.err.println("Error al guardar el mesero: " + e.getMessage());
            return null; // o lanzar una excepción personalizada
        }
    }

    public void deleteWaiter(int waiterId) {
        try {
            waiterRepository.deleteWaiter(waiterId);
        } catch (Exception e) {
            // Manejar la excepción
            System.err.println("Error al eliminar el mesero: " + e.getMessage());
        }
    }

    public Optional<Waiter> findById(int waiterId){
        return waiterRepository.getByID(waiterId);
    }
}
