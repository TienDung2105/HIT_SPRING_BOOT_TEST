# Yêu cầu phát triển: Chương 3 - API Specification

Đặc tả dưới đây chỉ là khung mẫu. Các bạn tự quyết định response chi tiết và format.

## 1. Room API

#### `GET /api/v1/rooms`

Mô tả: Trả về danh sách phòng có sẵn.

**Response 200:**

```json
{
  "total": 2,
  "items": 
  [
    {
      "id": 1,
      "roomName": "201",
      "status": "AVAILABLE",
      "roomType": {
        "id": 1,
        "name": "Standard",
        "maxOccupancy": 2,
        "basePrice": 500000
      },
      "createdAt": "2026-05-01T00:00:00Z",
      "updatedAt": "2026-05-01T00:00:00Z"
    },
    {
      "id": 2,
      "roomName": "202",
      "status": "INACTIVE",
      "roomType": {
        "id": 2,
        "name": "Deluxe",
        "maxOccupancy": 2,
        "basePrice": 800000
      },
      "createdAt": "2026-05-01T00:00:00Z",
      "updatedAt": "2026-05-01T00:00:00Z"
    }
  ]
}
```

---

#### `GET /api/v1/rooms/available`

Mô tả: Tìm các phòng còn trống trong thời gian mong muốn.

**Request Body:**

```json
{
  "checkInDateTime": "2026-06-01T00:00:00Z",
  "checkOutDateTime": "2026-06-04T00:00:00Z"
}
```

**Response 200:**

```json
{
  "total": 2,
  "items": [
    {
      "id": 1,
      "roomName": "201",
      "status": "AVAILABLE",
      "roomType": {
        "id": 1,
        "name": "Standard",
        "maxOccupancy": 2,
        "basePrice": 500000
      },
      "createdAt": "2026-05-01T00:00:00Z",
      "updatedAt": "2026-05-01T00:00:00Z"
    },
    {
      "id": 2,
      "roomName": "202",
      "status": "AVAILABLE",
      "roomType": {
        "id": 2,
        "name": "Deluxe",
        "maxOccupancy": 2,
        "basePrice": 800000
      },
      "createdAt": "2026-05-01T00:00:00Z",
      "updatedAt": "2026-05-01T00:00:00Z"
    }
  ]
}
```

## 2. Booking API

#### `GET /api/v1/booking/booking_id=?`

Mô tả: Xem thông tin chi tiết của một booking.

**Response 200:**

```json
{
  "id": 1,
  "customerName": "Nguyen Van A",
  "customerCccd": "123456789",
  "roomId": 1,
  "checkInDateTime": "2026-06-01T00:00:00Z",
  "checkOutDateTime": "2026-06-04T00:00:00Z",
  "numberOfGuests": 2,
  "status": "PENDING",
  "totalPrice": 1500000,
  "note": "Yêu cầu thêm gối phụ",
  "createdAt": "2026-05-20T00:00:00Z",
  "updatedAt": "2026-05-20T00:00:00Z"
}
```

---

#### `GET /api/v1/bookings/cccd=?`

Mô tả: Tìm danh sách booking của khách hàng.
**Request Param:**

```text
cccd: 123456789
```

**Response 200:**

```json
{
  "total": 1,
  "items": [
    {
      "id": 1,
      "customerName": "Nguyen Van A",
      "customerCccd": "123456789",
      "roomId": 1,
      "checkInDateTime": "2026-06-01T00:00:00Z",
      "checkOutDateTime": "2026-06-04T00:00:00Z",
      "numberOfGuests": 2,
      "status": "PENDING",
      "totalPrice": 1500000,
      "note": "Yêu cầu thêm gối phụ",
      "createdAt": "2026-05-20T00:00:00Z",
      "updatedAt": "2026-05-20T00:00:00Z"
    }
  ]
}
```

---

#### `POST /api/v1/booking`

Mô tả: Tạo booking.

**Request Body:**

```json
{
  "customerName": "Nguyen Van A",
  "customerCccd": "123456789",
  "roomId": 1,
  "checkInDateTime": "2026-06-01T00:00:00Z",
  "checkOutDateTime": "2026-06-04T00:00:00Z",
  "numberOfGuests": 2,
  "note": "Yêu cầu thêm gối phụ"
}
```

**Response 201:**

```json
{
  "id": 1,
  "customerName": "Nguyen Van A",
  "customerCccd": "123456789",
  "roomId": 1,
  "checkInDateTime": "2026-06-01T00:00:00Z",
  "checkOutDateTime": "2026-06-04T00:00:00Z",
  "numberOfGuests": 2,
  "status": "PENDING",
  "totalPrice": 1500000,
  "note": "Yêu cầu thêm gối phụ",
  "createdAt": "2026-05-20T00:00:00Z",
  "updatedAt": "2026-05-20T00:00:00Z"
}
```

---

#### `PATCH /api/v1/booking/{booking_id}/cancel`

Mô tả: Hủy booking.

```json
{
  "id": 1,
  "customerName": "Nguyen Van A",
  "customerCccd": "123456789",
  "roomId": 1,
  "status": "CANCELLED",
  "totalPrice": 1500000,
  "updatedAt": "2026-05-20T00:00:00Z"
}
```

## 3. Error response pattern

### Response 400 (Validation Error)

```json
{
  "logMessage": "Invalid request parameters.",
  "userMessage": "Lỗi, vui lòng kiểm tra lại thông tin đã nhập.",
  "devMessage": "Validation failed for multiple fields",
  "errors": [
    {
      "field": "title",
      "message": "Title must not be empty"
    }
  ]
}
```
### Response 404 (Not Found)

```json
{
  "logMessage": "Booking with ID 123 not found.",
  "userMessage": "Không tìm thấy đơn đặt phòng.",
  "devMessage": "No booking found with ID: 123",
  "devInfo": "Line 45 in BookingService.java"
}
```

### Response 500

```json
{
  "logMessage": "Internal Error.",
  "userMessage": "Đã xảy ra lỗi nội bộ.",
  "devMessage": "InternalException throws ",
  "devInfo": "Line 56 in file..."
}
```
