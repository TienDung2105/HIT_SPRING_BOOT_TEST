package org.example.hotelbooking.controller;

import jakarta.validation.Valid;
import org.example.hotelbooking.common.response.ApiResponse;
import org.example.hotelbooking.common.response.ListResponse;
import org.example.hotelbooking.constant.ApiPath;
import org.example.hotelbooking.constant.SuccessMessage;
import org.example.hotelbooking.dto.BookingResponse;
import org.example.hotelbooking.dto.CreateBookingRequest;
import org.example.hotelbooking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(ApiPath.API_V1)
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public ApiResponse<List<BookingResponse>> getBooking(@RequestParam("booking_id") String bookingId
    ) {
        List<BookingResponse> hihi= bookingService.getAllBookingById(bookingId);
        return ApiResponse.ok(SuccessMessage.FETCH_DATA_SUCCESS,hihi) ;
    }

    @GetMapping("/bookings")
    public ApiResponse<List<BookingResponse>> getBookingsByCustomer(
            @RequestParam("cccd") String cccd
    ) {
        List<BookingResponse> data = bookingService.findBookingByCccd(cccd);
        return ApiResponse.ok(SuccessMessage.FETCH_DATA_SUCCESS, data);
    }


    @PostMapping("/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<BookingResponse> createBooking(@Valid @RequestBody CreateBookingRequest request) {
        BookingResponse data=bookingService.createBooking(request);
        return ApiResponse.ok(SuccessMessage.CREATE_BOOKING_SUCCESS, data);
    }

    @PatchMapping("/booking/{booking_id}/cancel")
    public ApiResponse<BookingResponse> cancelBooking(@PathVariable("booking_id") String bookingId
    ) {
        BookingResponse data= bookingService.cancleBooking(bookingId);
        return ApiResponse.ok(SuccessMessage.CANCEL_BOOKING_SUCCESS, data);
    }
}
