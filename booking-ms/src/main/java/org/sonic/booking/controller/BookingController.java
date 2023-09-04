package org.sonic.booking.controller;

import org.sonic.booking.model.BookingDetails;
import org.sonic.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @GetMapping(value = "/details/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingDetails getDetails(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerHeader, @PathVariable String user){
        return bookingService.getBookingDetails(bearerHeader, user);
    }

}
