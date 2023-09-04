package org.sonic.booking.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDetails {
    private Integer bookingId;
    private User userDetails;
}
