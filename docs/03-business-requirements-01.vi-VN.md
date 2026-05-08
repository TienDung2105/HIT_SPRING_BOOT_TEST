# Yêu cầu nghiệp vụ: Chương 1 - Khái niệm cốt lõi

## 1. Tổng quan

Xây dựng API đơn giản cho hệ thống đặt phòng khách sạn.

Mục tiêu chính của bài:

> Khuong edited: start
- Đọc hiểu tài liệu và thực hiện yêu cầu.
- Code sạch, dễ hiểu, có cấu trúc tốt.
- Áp dụng kiến thức đã học về Spring Boot, JPA, REST API.

Không cần frontend, login, phân quyền, thanh toán hoặc check-in/check-out.

## 2.Bối cảnh

Bạn sẽ đóng vai **là một lễ tân** trong khách sạn, quản lý phòng và booking cho khách hàng.

Mỗi khi có khách đến hỏi về phòng trống hoặc những phòng có thể đặt, bạn sẽ sử dụng API để tra cứu và tạo booking cho khách.

> Khuong edited: end

## 3. Khái niệm chính

### 2.1 Room Type - Loại phòng

Loại phòng mô tả nhóm phòng trong khách sạn:

- Standard Room - Phòng tiêu chuẩn
- Deluxe Room - Phòng cao cấp
- Family Room - Phòng gia đình

### 2.2 Room - Phòng

> Khuong edited: start

Phòng cụ thể của khách sạn, thuộc một loại phòng nhất định. Mỗi phòng có trạng thái riêng: còn trống (AVAILABLE), không hoạt động (INACTIVE).

### 2.3 Booking - Đơn đặt phòng

Ghi nhận việc một khách hàng (được định danh bằng Số CCCD và Tên) đặt một phòng cụ , trong một thời gian xác định.

Booking có trạng thái như PENDING (đang chờ), CANCELLED (đã hủy). 

> Khuong edited: end