package org.example.hotelbooking.service;

import org.example.hotelbooking.domain.BookingStatus;
import org.example.hotelbooking.dto.BookingResponse;
import org.example.hotelbooking.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }

    @Transactional(readOnly = true)
    public List<BookingResponse> getAllBookingById(String id){
        return bookingRepository.findBookingById(String.valueOf(BookingStatus.CANCELLED))
                .stream().map(BookingResponse ::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<BookingResponse> findBookingByCccd(String cccd){
        return bookingRepository.findBookingByCustomerCccd(String.valueOf(BookingStatus.PENDING))
                .stream().map(BookingResponse::from)
                .toList();
    }

    // TO DO
}
