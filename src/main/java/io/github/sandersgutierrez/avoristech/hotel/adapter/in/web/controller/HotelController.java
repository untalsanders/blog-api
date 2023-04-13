package io.github.sandersgutierrez.avoristech.hotel.adapter.in.web.controller;

import io.github.sandersgutierrez.avoristech.hotel.application.service.HotelService;
import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return new ResponseEntity<>(hotelService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable("id") Long id) {
        return hotelService.getById(id)
                       .map(hotel -> new ResponseEntity<>(hotel, HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if (hotelService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
