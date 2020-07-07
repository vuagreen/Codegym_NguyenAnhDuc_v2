//create Object Nokia
let nokia = new Mobile('nokia','bật',0);
let showOnDisplayNokia = document.getElementById('show-display-nokia');
// let batTatDtNokia = document.getElementById('turn-on-off-nokia').checked;
let hopThuNhapNokia = document.getElementById('hopThuNhap');
let hopThuDenNokia = document.getElementById('hopThuDen');
let hopThuGuiNokia = document.getElementById('hopThuGui');
let pinNokia = document.getElementById('pin-nokia');
document.getElementById('pin-nokia').value = nokia.pin;

//create Object iPhone
let iphone = new Mobile('iphone','bật',15);
let showOnDisplayIphone = document.getElementById('show-display-nokia');
let batTatDtIphone = document.getElementById('turn-on-off-nokia');
let hopThuNhapIphone = document.getElementById('hopThuNhap');
let hopThuDenIphone = document.getElementById('hopThuDen');
let hopThuGuiIphone = document.getElementById('hopThuGui');
let pinIphone = document.getElementById('pin-iphone');
document.getElementById('pin-iphone').value = iphone.pin;

function guiTinNhan(tenDienThoai) {
    switch(tenDienThoai) {
        case nokia: 
            let contentNokia = document.getElementById('content-message-nokia').value;
            nokia.hopThuNhap.push(contentNokia);
            document.getElementById('content-message-nokia'). value = '';
            iphone.hopThuDen.push(contentNokia);
            // alert('Đã gửi tin nhắn từ Nokia: ' + contentNokia)
        break;
        case iphone: 
            let contentIphone = document.getElementById('content-message-iphone').value;
            iphone.hopThuNhap.push(contentIphone);
            document.getElementById('content-message-iphone').value = '';
            nokia.hopThuDen.push(contentIphone);
            // alert('Đã gửi tin nhắn từ Iphone: ' + contentIphone)
        break;
    }
}

function nhanTinNhan(tenDienThoai) {
    switch(tenDienThoai) {
        case nokia:

            break;
        case iphone: 
            break;
    }
}
function showHopThuNhap() {
    let contentHopThuNhapNokia = nokia.hopThuNhap.map((item) => '<li>' + item + '</li>');
    document.getElementById('nokia-message-list').innerHTML = contentHopThuNhapNokia.join('');
    let contentHopThuNhapIphone = iphone.hopThuNhap.map((item) => '<li>' + item + '</li>');
    document.getElementById('iphone-message-list').innerHTML = contentHopThuNhapIphone.join('');
  
    
}

function showHopThuDen(tenDienThoai) {
    switch(tenDienThoai) {
        case nokia: {
            let contentHopThuDenNokia = nokia.hopThuDen.map((item) => '<li>' + item + '</li>');
            document.getElementById('nokia-message-list').innerHTML = contentHopThuDenNokia.join('');
            console.log(contentHopThuDenNokia)
        }
        break;
        case iphone: {
            let contentHopThuDenIphone = iphone.hopThuDen.map((item) => '<li>' + item + '</li>');
            document.getElementById('iphone-message-list').innerHTML = contentHopThuDenIphone.join('');
        }
        break;
    }
}

function showHopThuGui() {
    alert('Hiển thị hộp thư gửi !');
}

function sacPinNokia() {
    let countPinNokia = nokia.pin;
    setInterval(tangPin, 1000);
    function tangPin() {
        if(countPinNokia < 100) {
        countPinNokia++;
        pinNokia.value = countPinNokia;
        }
    }
}

function sacPinIphone() {
    let countPinIphone = iphone.pin;
    setInterval(tangPin, 1000);
    function tangPin() {
        if(countPinIphone < 100) {
        countPinIphone++;
        pinIphone.value = countPinIphone;
        }
    }
}

  // switch(tenDienThoai) {
    //     case nokia:
    //         let countPinNokia = tenDienThoai.pin;
    //         setInterval(tangPin, 1000);
    //         function tangPin() {
    //            if(countPinNokia < 100) {
    //             countPinNokia++;
    //             pinNokia.value = countPinNokia;
    //             console.log(countPinNokia)
    //            }
    //         }
    //     break;
    //     case iphone:
    //         let countPinIphone = tenDienThoai.pin;
    //         console.log(countPinIphone);
    //         setInterval(tangPin, 1000);
    //         function tangPin() {
    //            if(countPinIphone < 100) {
    //             countPinIphone++;
    //             pinIphone.value = countPinIphone;
    //            }
    //         }
    //     break;
    // }

    // // setInterval(tangPin, 1000);
    // // function tangPin() {
    // //    if(countPin < 100) {
    // //     countPin++;
    // //     pinNokia.value = countPin;
    // //    }
    // // }