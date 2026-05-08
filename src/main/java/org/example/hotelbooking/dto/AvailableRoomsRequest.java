package org.example.hotelbooking.dto;

import jakarta.validation.constraints.NotNull;
import org.example.hotelbooking.constant.ErrorMessage;

import java.time.Instant;

public record AvailableRoomsRequest(
        // TO DO
        Instant checkInDateTime,

        // TO DO
        Instant checkOutDateTime
) {
}
