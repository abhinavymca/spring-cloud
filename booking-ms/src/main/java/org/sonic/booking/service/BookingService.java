package org.sonic.booking.service;

import lombok.RequiredArgsConstructor;
import org.sonic.booking.config.UserDetailsProxy;
import org.sonic.booking.model.BookingDetails;
import org.sonic.booking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookingService {

    @Autowired
    private UserDetailsProxy userDetailsProxy;
    public BookingDetails getBookingDetails(String bearerHeader, String userName) {
        User user = userDetailsProxy.search(bearerHeader, userName);
        return BookingDetails.builder().bookingId(Math.abs(new Random().nextInt())).userDetails(user).build();
    }
}
