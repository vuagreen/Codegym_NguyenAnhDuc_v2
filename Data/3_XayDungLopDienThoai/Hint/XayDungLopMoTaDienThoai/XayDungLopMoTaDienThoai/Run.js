
var nokia = new Mobile("nokia");
var pin1 = document.getElementById("pin1");
var nokiaResult = document.getElementById("nokiaResult");
var batTatDienThoai1 = document.getElementById("batTatDienThoai1");
var tinNhan1 = document.getElementById("tinNhan1");
var vungNhoLuuTinNhanDangSoanThao1 = document.getElementById("vungNhoLuuTinNhanDangSoanThao1");
var vungNhoLuuTinNhanDaGui1 = document.getElementById("vungNhoLuuTinNhanDaGui1");
var vungNhoLuuTinNhanDen1 = document.getElementById("vungNhoLuuTinNhanDen1");
nokia.setPin(0);
displayInit(nokia);
displayTrangThaiPin(nokia);

var iphone = new Mobile("iphone");
var pin2 = document.getElementById("pin2");
var iphoneResult = document.getElementById("iphoneResult");
var tinNhan2 = document.getElementById("tinNhan2");
var vungNhoLuuTinNhanDangSoanThao2 = document.getElementById("vungNhoLuuTinNhanDangSoanThao2");
var vungNhoLuuTinNhanDaGui2 = document.getElementById("vungNhoLuuTinNhanDaGui2");
var vungNhoLuuTinNhanDen2 = document.getElementById("vungNhoLuuTinNhanDen2");
iphone.setPin(0);
displayInit(iphone);
displayTrangThaiPin(iphone);


function displayInit(mobile) {
    switch (mobile.getTenDienThoai()) {
        case  "nokia":
            nokiaResult.innerText =  mobile.displayInit();
            break;
        case  "iphone":
            iphoneResult.innerText =  mobile.displayInit();
            break;
    }
}
function displayTrangThaiPin(mobile) {
    switch (mobile.getTenDienThoai()) {
        case  "nokia":
            pin1.innerText =  mobile.displayTrangThaiPin();
            break;
        case  "iphone":
            pin2.innerText =  mobile.displayTrangThaiPin();
            break;
    }
}
function batDienThoai(tenDienThoai) {
    switch (tenDienThoai) {
        case  "nokia":
            nokia.batDienThoai();
            nokiaResult.innerText = "nokia có" + nokia.kiemTraTrangThaiDienThoai();
            break;
        case  "iphone":
            iphone.batDienThoai();
            iphoneResult.innerText = "iphone có" + iphone.kiemTraTrangThaiDienThoai();
            break;
    }
}
function tatDienThoai(tenDienThoai) {
    switch (tenDienThoai) {
        case  "nokia":
            nokia.tatDienThoai();
            nokiaResult.innerText = "nokia có" + nokia.kiemTraTrangThaiDienThoai();
            break;
        case  "iphone":
            iphone.tatDienThoai();
            iphoneResult.innerText = "iphone có" + iphone.kiemTraTrangThaiDienThoai();
            break;
    }
}
function sacPin(tenDienThoai) {
    switch (tenDienThoai) {
        case  "nokia":
            nokiaResult.innerText = "nokia đang sạc pin " + nokia.sacPinDienThoai();
            displayTrangThaiPin(nokia);
            break;
        case  "iphone":
            iphoneResult.innerText = "iphone đang sạc pin" + iphone.sacPinDienThoai();
            displayTrangThaiPin(iphone);
            break;
    }
}
function soanTinNhan(tenDienThoai, noidung) {
    switch (tenDienThoai) {
        case  "nokia":
            nokia.soanTinNhan(noidung);
            vungNhoLuuTinNhanDangSoanThao1.innerText = nokia.getVungNhoLuuTinNhanDangSoanThao().join();
            displayTrangThaiPin(nokia);
            tinNhan1.value = "";
            break;
        case  "iphone":
            iphone.soanTinNhan(noidung);
            vungNhoLuuTinNhanDangSoanThao2.innerText = iphone.getVungNhoLuuTinNhanDangSoanThao().join();
            displayTrangThaiPin(iphone);
            break;
    }
}
function guiTinNhan(tenDienThoai) {
    switch (tenDienThoai) {
        case  "nokia":
            iphone.guiTinNhan(nokia);
            vungNhoLuuTinNhanDaGui2.innerText = iphone.getVungNhoLuuTinNhanDaGui().join();
            displayTrangThaiPin(iphone);
            iphoneResult.innerText = "iphone đã gửi đến nokia tin nhắn '" + iphone.getVungNhoLuuTinNhanDaGui().join() + "' thành công";
            break;
        case  "iphone":
            nokia.guiTinNhan(iphone);
            vungNhoLuuTinNhanDaGui1.innerText = nokia.getVungNhoLuuTinNhanDaGui().join();
            displayTrangThaiPin(nokia);
            nokiaResult.innerText = "nokia đã gửi đến iphone tin nhắn '" + nokia.getVungNhoLuuTinNhanDaGui().join() + "' thành công";
            break;
    }
}
function nhanTinNhan(tenDienThoai) {
    switch (tenDienThoai) {
        case  "nokia":
            vungNhoLuuTinNhanDen1.innerText = nokia.nhanTinNhan().join();
            displayTrangThaiPin(nokia);
            break;
        case  "iphone":
            vungNhoLuuTinNhanDen2.innerText = iphone.nhanTinNhan().join();
            displayTrangThaiPin(iphone);
            break;
    }
}
function xemTinNhanDen(tenDienThoai) {
    switch (tenDienThoai) {
        case  "nokia":
            nokiaResult.innerText = nokia.xemTinNhanDen();
            displayTrangThaiPin(nokia);
            break;
        case  "iphone":
            iphoneResult.innerText = iphone.xemTinNhanDen();
            displayTrangThaiPin(iphone);
            break;
    }
}
function xemTinNhanDaGui(tenDienThoai) {
    switch (tenDienThoai) {
        case  "nokia":
            nokiaResult.innerText = nokia.xemTinNhanDaGui();
            displayTrangThaiPin(nokia);
            break;
        case  "iphone":
            iphoneResult.innerText = iphone.xemTinNhanDaGui();
            displayTrangThaiPin(iphone);
            break;
    }
}