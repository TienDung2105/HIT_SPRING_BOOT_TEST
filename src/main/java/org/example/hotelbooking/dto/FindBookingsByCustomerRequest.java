package org.example.hotelbooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.example.hotelbooking.constant.ErrorMessage;

public record FindBookingsByCustomerRequest(
        // TO DO
        String cccd
) {
}
