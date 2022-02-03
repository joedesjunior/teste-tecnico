package com.apidimed.backend.controllers;

import com.apidimed.backend.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public ResponseEntity listAllBus() {
        Boolean httpResponse = busService.importBusHttp();
        if (httpResponse) {
            return ResponseEntity.ok(busService.listAll());
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
