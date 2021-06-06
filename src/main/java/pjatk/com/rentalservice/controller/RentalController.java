package pjatk.com.rentalservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjatk.com.rentalservice.service.RentalService;

@RestController
@RequestMapping("/rental/")
public class RentalController {
    RentalService rentalService;

    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(rentalService.findMovieById(id));
    }

    @PutMapping("{id}/return")
    public void returnMovie(@PathVariable Long id){
        rentalService.returnMovieById(id);
    }
}
