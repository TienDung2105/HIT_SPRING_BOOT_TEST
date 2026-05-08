# Yêu cầu nghiệp vụ: Chương 3 - Logic nghiệp vụ chính

Chương này chỉ nêu các rule cốt lõi. Các bạn cần tự phân tích thêm edge case và cách implement phù hợp.

## 1. Dữ liệu nền

Loại phòng, phòng được xem là dữ liệu có sẵn.

Các bạn cần đảm bảo khi chạy project có đủ dữ liệu để test các API booking.

> Khuong edited: start

## 2. Xem danh sách phòng

API này trả về danh sách tất cả phòng để lễ tân có thể theo dõi.

## 3. Tìm các phòng còn trống

API này trả về danh sách các phòng có thể đặt (booking) trong khoảng thời gian mong muốn (Do lễ tân nhập vào).

Có thể có thêm filter (tùy ý) để giúp lễ tân tìm phòng nhanh hơn.

## 4. Xem booking cụ thể

API này trả về thông tin chi tiết của một booking.

## 5. Tìm danh sách booking của khách hàng

API này trả về danh sách booking của một khách hàng dựa trên số CCCD.

## 6. Tạo booking

API này tạo một booking mới cho khách hàng.

Một booking mới bắt buộc có:
- Thông tin khách hàng
- Khoảng thời gian check-in và check-out 

Ngoài các ràng buộc cơ bản (tự các bạn định nghĩa), các ràng buộc như sau cần được đảm bảo:
- Số khách phù hợp với sức chứa phòng
- Khoảng thời gian thuê phòng không quá dài (ví dụ: không quá 30 ngày)
- Hệ thống phải kiểm tra lại một lần nữa xem phòng đó có còn trống không trước khi lưu (tránh trường hợp 2 lễ tân cùng đặt 1 phòng cùng lúc)

Phòng khi được booking sẽ chuyển sang trạng thái `PENDING` để chờ xác nhận.

## 7. Tính tiền

Khi tạo booking, hệ thống cần tính tổng tiền thuê phòng dự kiến.

Công thức gợi ý:

```text
totalPrice = số đêm * giá phòng mỗi đêm * hệ số điều chỉnh (nếu có)
```

Hệ số điều chỉnh có thể là các yếu tố khác như loại phòng, dịch vụ,.. tùy các bạn quyết định.

## 8. Hủy booking

API này hủy một booking của khách hàng.

Khi hủy booking, cần đảm bảo các ràng buộc sau:
- Booking đang ở trạng thái `PENDING`.
- Sau khi hủy thì không thể thay đổi trạng thái.

Khi hủy booking:
- Booking chuyển sang trạng thái `CANCELLED`.
- Sau khi hủy thì phòng sẽ được trả về trạng thái `AVAILABLE`.

> Khuong edited: end