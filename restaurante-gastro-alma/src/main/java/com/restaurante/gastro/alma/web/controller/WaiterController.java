package com.restaurante.gastro.alma.web.controller;
import com.restaurante.gastro.alma.domain.Waiter;
import com.restaurante.gastro.alma.domain.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/waiter")
public class WaiterController {
    @Autowired
    private WaiterService waiterService;

    @GetMapping("/all")
    public ResponseEntity<Waiter> getAll(){
        return new ResponseEntity(waiterService.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById (@PathVariable("id") int waiterId){
            if(waiterService.findById(waiterId).isPresent()){
                waiterService.deleteWaiter(waiterId);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Waiter> getById(@PathVariable("id") int waiterId){
        if (waiterService.findById(waiterId).isPresent()){
        return ResponseEntity.of(waiterService.findById(waiterId));
    }else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Waiter> save(@RequestBody Waiter waiter){

        Waiter savedWaiter = waiterService.save(waiter);
        return new ResponseEntity(savedWaiter,HttpStatus.OK);

    }
}
