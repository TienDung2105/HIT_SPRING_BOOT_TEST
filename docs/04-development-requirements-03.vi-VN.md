# Yêu cầu phát triển: Chương 4 - DDL tham khảo và tiêu chí hoàn thành

## 1. DDL tham khảo

DDL dưới đây chỉ là gợi ý. Học viên có thể tự thiết kế bảng khác nếu vẫn đáp ứng nghiệp vụ.

```sql
CREATE TABLE room_type (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    max_occupancy INT NOT NULL,
    base_price DECIMAL(15, 2) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE room (
    id VARCHAR(36) PRIMARY KEY,
    room_name VARCHAR(50) NOT NULL,
    status VARCHAR(30) NOT NULL,
    room_type_id VARCHAR(36) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE booking (
    id VARCHAR(36) PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    customer_cccd VARCHAR(50) NOT NULL,
    room_id VARCHAR(36) NOT NULL,
    check_in_datetime DATETIME NOT NULL,
    check_out_datetime DATETIME NOT NULL,
    number_of_guests INT NOT NULL,
    status VARCHAR(30) NOT NULL,
    total_price DECIMAL(15, 2) NOT NULL,
    note TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

## 2. Seed data

Học viên nên seed sẵn dữ liệu cho các bảng:

- `room_type`
- `room`

Có thể seed bằng `data.sql`.

## 3. Tiêu chí hoàn thành

Bài làm đạt yêu cầu khi:

- Chạy được Spring Boot API.
- Có đủ API bắt buộc.
- Có dữ liệu seed để test ngay sau khi chạy project.
- Tìm phòng còn trống đúng theo khoảng thời gian.
- Không cho tạo booking bị trùng lịch.
- `totalPrice` được hệ thống tự tính.
- Hủy booking xong thì booking đó không còn chặn lịch phòng.

## 4. Phần các bạn tự quyết định

- Cách seed data.
- Cách validate chi tiết.
- Cách thiết kế DTO/response.
- Cách xử lý exception.
- Có dùng pagination hay không.
- Có viết test hay không.
- Có dùng Swagger hay không.
