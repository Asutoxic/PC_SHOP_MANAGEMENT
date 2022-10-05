class App {
    static DOMAIN = location.origin;

    static ERROR_400 = "Giao dịch không thành công, vui lòng kiểm tra lại dữ liệu.";
    static ERROR_401 = "Quyền truy cập bị từ chối! Thông tin không hợp lệ.";
    static ERROR_403 = "Quyền truy cập bị từ chối! Bạn không được phép thực hiện chức năng này.";
    static ERROR_404 = "Đã xảy ra lỗi. Vui lòng thử lại sau!";
    static ERROR_500 = "Lưu dữ liệu không thành công, vui lòng liên hệ quản trị hệ thống.";

    static BASE_URL_ROLE = this.DOMAIN + "/api/roles";
    static BASE_URL_AUTH = this.DOMAIN + "/api/auth";
    static BASE_URL_USER = this.DOMAIN + "/api/users";

    static SUCCESS_CREATED = "Tạo dữ liệu thành công!";
    static SUCCESS_UPDATED = "Cập nhật dữ liệu thành công!";
    static SUCCESS_REMOVED = "Xóa thành công!";

    static BLOCK_USER = 'Bạn chắc chắn muốn chặn người dùng này không?';

    static SweetAlert = class {
        static showConfirmDialog(message) {
            return Swal.fire({
                icon: 'WARNING',
                text: message,
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Đồng Ý',
                cancelButtonText: 'Huỷ',
            })
        }

        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 1500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
            })
        }


    }


    static IziToast = class {
        static showSuccessAlert(t) {
            iziToast.success({
                title: 'OK',
                position: 'topRight',
                timeout: 5000,
                message: t
            });
        }

        static showErrorAlert(t) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: false,
                message: t
            });
        }
    }
}


class Product {
    constructor(id, name, image, amount, price, isDeleted) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.amount = amount;
        this.price = price;
        // this.category = category;
        this.isDeleted = isDeleted;
    }
}


class Category {
    constructor(id, category) {
        this.id = id;
        this.categoryName = category;
    }
}