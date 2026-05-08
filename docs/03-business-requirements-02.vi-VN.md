# Yêu cầu nghiệp vụ: Chương 2 - Chức năng cần làm

## 1. Dữ liệu có sẵn

> Khuong edited: start

Các bạn không cần làm API tạo loại phòng, tạo phòng.

Các dữ liệu này sẽ được chuẩn bị sẵn ở file `data.sql` và các bạn insert thủ công vào database **SAU** khi chạy ứng dụng (để Spring tạo table trước).

Dữ liệu seed tối thiểu có:

- Một vài loại phòng.
- Một vài phòng cụ thể.

## 2. Danh sách chức năng bắt buộc

Bài yêu cầu các chức năng sau:

| Nhóm | Chức năng | Endpoint gợi ý |
| --- | --- | --- |
| Room | Xem danh sách phòng | `GET /api/v1/rooms` |
| Room | Tìm các phòng còn trống | `GET /api/v1/rooms/available` |
| Booking | Xem booking cụ thể | `GET /api/v1/booking/booking_id=?` |
| Booking | Tìm danh sách booking của khách hàng | `GET /api/v1/bookings/cccd=?` |
| Booking | Tạo booking | `POST /api/v1/booking` |
| Booking | Hủy booking | `PATCH /api/v1/booking/{booking_id}/cancel` |

Endpoint trên chỉ là gợi ý, các bạn có thể tùy chọn sử dụng `request param`, `request body`, hoặc `path variable` cho các endpoint trên. Miễn sao đảm bảo chức năng hoạt động đúng là được.

> Khuong edited: end

## 3. Luồng sử dụng chính

![Luồng tạo đơn đặt phòng](../assets/hotel-booking-flow.svg)

Luồng gợi ý:

```text
Seed dữ liệu phòng/khách hàng
-> Xem danh sách phòng
-> Tìm phòng còn trống
-> Tạo booking
-> Hủy booking nếu cần
```

## 4. Ghi chú

Các bạn có thể tự quyết định:

- Response trả chi tiết đến mức nào.
- Có dùng DTO hay không.
- Có phân trang hay không.
- Cách tổ chức package, service, repository.
- Format lỗi cụ thể.
