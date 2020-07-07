var Mobile = function (tenDienThoai) {
    this.tenDienThoai = tenDienThoai;
    this.vungNhoLuuTinNhanDangSoanThao = new Array();
    this.vungNhoLuuTinNhanTrongHopThuDen = new Array();
    this.vungNhoLuuTinNhanDaGui = new Array();
    this.getTenDienThoai = function () {
        return this.tenDienThoai;
    }
    this.setPin = function (pin) {
        this.pin = pin;
    };
    this.getPin = function () {
        return this.pin;
    };
    this.getVungNhoLuuTinNhanDangSoanThao = function () {
        return this.vungNhoLuuTinNhanDangSoanThao;
    };
    this.getVungNhoLuuTinNhanTrongHopThuDen = function () {
        return this.vungNhoLuuTinNhanTrongHopThuDen;
    };
    this.getVungNhoLuuTinNhanDaGui = function () {
        return this.vungNhoLuuTinNhanDaGui;
    };
    this.setTrangThaiDienThoai = function (trangThaiDienThoai) {
        this.trangThaiDienThoai = trangThaiDienThoai;
    };
    this.getTrangThaiDienThoai = function () {
        return this.trangThaiDienThoai;
    };
    this.kiemTraTrangThaiDienThoai = function () {
        if (this.trangThaiDienThoai == true) {
            return "Trạng thái Điện thoai đang bật";
        } else {
            return "Trạng thái Điện thoai đang tắt";
        }
    };
    this.batDienThoai = function () {
        this.pin--;
        this.setTrangThaiDienThoai(true);
    };
    this.tatDienThoai = function () {
        this.pin--;
        this.setTrangThaiDienThoai(false);
    };
    this.sacPinDienThoai = function () {
        var str = "";
        for (var i = this.pin; i <= 100; i++) {
            this.setPin(i);
            str += ":: " + i;
        }
        ;
        return str;
    };
    this.soanTinNhan = function (noiDung) {
        this.vungNhoLuuTinNhanDangSoanThao.push(noiDung);
        this.pin--;
    };
    this.nhanTinNhan = function () {
        this.pin--;
        return this.vungNhoLuuTinNhanTrongHopThuDen;
    };
    this.guiTinNhan = function (objTo) {
        for (var i = 0; i < this.vungNhoLuuTinNhanDangSoanThao.length; i++) {
            this.vungNhoLuuTinNhanDaGui.push(this.vungNhoLuuTinNhanDangSoanThao[i]);
            objTo.vungNhoLuuTinNhanTrongHopThuDen.push(this.vungNhoLuuTinNhanDangSoanThao[i]);
        }
        this.vungNhoLuuTinNhanDangSoanThao = new Array();
        this.pin--;
    };
    this.xemTinNhanDen = function () {
        this.pin--;
        return "Có " + this.getVungNhoLuuTinNhanTrongHopThuDen().length + " tin nhắn đến : " + this.getVungNhoLuuTinNhanTrongHopThuDen().join();
    };
    this.xemTinNhanDaGui = function () {
        this.pin--;
        return "Có "+ this.getVungNhoLuuTinNhanDaGui().length + " tin nhắn đã gửi : " + this.getVungNhoLuuTinNhanDaGui().join();
    };
    this.displayInit = function () {
        return "Bạn đã khởi tạo 1 chiếc điện thoai " + this.tenDienThoai;
    }
    this.displayTrangThaiPin = function () {
        return "Trạng thái pin hiện tại " + this.getPin();
    };

};