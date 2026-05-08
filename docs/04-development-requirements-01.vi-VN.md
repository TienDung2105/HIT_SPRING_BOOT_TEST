# Yêu cầu phát triển: Chương 1 - Domain Classes

## 1. Entity gợi ý

> Khuong edited: start

```ts
type RoomType = {
  id: string,                 // UUID
  name: string,               // Tên loại phòng
  maxOccupancy: number,       // Số khách tối đa
  basePrice: number,          // Giá cơ bản
  createdAt: DateTime,        // Ngày giờ tạo loại phòng
  updatedAt: DateTime,        // Ngày giờ cập nhật loại phòng
};
```

```ts
type Room = {
  id: string,                 // UUID
  roomName: string,           // Tên phòng
  status: RoomStatus,         // Trạng thái phòng
  roomType: RoomType,         // Loại phòng
  createdAt: DateTime,        // Ngày giờ tạo phòng
  updatedAt: DateTime,        // Ngày giờ cập nhật phòng
};
```

```ts
type Booking = {
  id: string,                 // UUID
  customerName: string,       // Tên khách hàng
  customerCccd: string,       // Số CCCD khách hàng
  roomId: string,             // ID phòng
  checkInDateTime: DateTime,  // Ngày giờ nhận phòng
  checkOutDateTime: DateTime, // Ngày giờ trả phòng
  numberOfGuests: number,     // Số khách
  status: BookingStatus,      // Trạng thái đặt phòng
  totalPrice: number,         // Tổng giá
  note: string,               // Ghi chú
  createdAt: DateTime,        // Ngày giờ tạo booking
  updatedAt: DateTime,        // Ngày giờ cập nhật booking
}
```

## 2. Enum gợi ý

```ts
type RoomStatus = "AVAILABLE" | "INACTIVE";
```

```ts
type BookingStatus = "PENDING" | "CANCELLED";
```

> Khuong edited: end

## 3. Gợi ý kỹ thuật

- Nên tách Entity, Repository, Service, Controller.
- Nên xử lý nghiệp vụ booking trong Service.
- Nên dùng kiểu dữ liệu phù hợp cho tiền và ngày tháng.
