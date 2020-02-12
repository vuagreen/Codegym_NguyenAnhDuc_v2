class Mobile {
    constructor(tenDienThoai, trangThai, pin) {
        this.tenDienThoai = tenDienThoai;
        this.trangThai = trangThai;
        this.pin = pin;
        this.hopThuNhap = [];
        this.hopThuDen = [];
        this.hopThuGui = [];
    }
    getTenDienThoai() {
        return this.tenDienThoai;
    }
    setTrangThai(trangThai) {
        this.trangThai = trangThai;
    }
    getTrangThai() {
        return this.trangThai;
    }
    checkTrangThai() {
        if(this.trangThai === true) {
            return 'Điện thoại bật !';
        } else {
            return 'Điện thoại tắt !';
        }
    }
    batDienThoai() {
        this.pin--;
        this.setTrangThai(true);
    }
    tatDienThoai() {
        this.pin--;
        this.setTrangThai(false);
    }
    sacPin() {
        
    }
    setPin(pin) {
        this.pin = pin;
    }
    getPin() {
        return this.pin;
    }
    hopThuNhap() {
        return this.hopThuNhap;
    }
    hopThuDen() {
        return this.hopThuDen;
    }
    hopThuGui() {
        return this.hopThuGui;
    }
    soanTinNhan(noiDung) {
        this.hopThuNhap.push(noiDung);
        this.pin--;
    }
    guiTinNhan(tenDienThoai) {
        alert('Đã gửi');
        for(let i = 0; i < this.hopThuNhap.length; i++) { //loop trong hộp thư nháp để push sang hộp thư đã gửi
            this.hopThuGui.push(this.hopThuNhap[i]);
            tenDienThoai.hopThuDen.push(this.hopThuNhap[i]);
        }
        this.hopThuNhap = []; // khi gửi tn đi rồi thì hộp thư đang soạn sẽ được reset
        this.pin--;
    }
    xemTinNhanDen() {
        return `Có (${this.hopThuGui().length}) tin nhắn mới: ${this.hopThuGui().join(' | ')}`
    }
    showTrangThaiPin() {

    }
}