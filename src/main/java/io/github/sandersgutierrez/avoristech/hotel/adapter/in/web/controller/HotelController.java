package io.github.sandersgutierrez.avoristech.hotel.adapter.in.web.controller;

import io.github.sandersgutierrez.avoristech.hotel.application.exception.NoSuchElementFoundException;
import io.github.sandersgutierrez.avoristech.hotel.application.service.HotelService;
import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable("hotelId") Long hotelId) {
        return new ResponseEntity<>(hotelService.getById(hotelId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Hotel> update(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.update(hotel), HttpStatus.CREATED);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("hotelId") Long hotelId) {
        hotelService.delete(hotelId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
