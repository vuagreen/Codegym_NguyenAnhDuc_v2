var dem = 0; // biến đếm số lượng khách hàng tồn tại trên hệ thống
var a = 0;// biến tính toán
var array = new Array(); // khai báo mảng
var i = 1; // biến số dòng của mảng
var j; // biến cố cột của mảng
var id_customer; // biến tính toán
var id_typeOfService;// biến tính toán
var id_kindOfRoom;// biến tính toán
var current;//biến tính ngày
var name;//0
var idCard;//1
var birthday;//2
var email;//3
var address;//4
var promotion;//5
var numberPeople;//6
var rentDays;//7
var customer;//8
var typeOfService;//9
var kindOfRoom;//10
var giaTien;//11
var money_typeOfService;//12- biến tính toán
var age = 0;//13-biến tuổi
var fix_customer = 0;//14 - biến fix giá theo customer
var fix_rentday = 0;//15-Biến fix giá theo rentday
var fix_ageandadr = 0;//16 Biến fix theo địa chỉ và age
var fix_adr = 0;//17 biến fix theo địa chỉ

// do {
//
//     displayMainMenu();
//
// } while (true)


function displayMainMenu() {
    let number1 = parseInt(prompt(" MENU \n" +            // menu
        "\n1.ADD" +
        "\n2.SHOW" +
        "\n3.EDIT" +
        "\n4.DELETE" +
        "\n5.EXIT" +
        "" +
        ""));
    switch (number1) {
        case 1:
            add();
            dem++;
            i++;
            break;
        case 2:
            show();
            break;
        case 3:
            edit();
            break;
        case 4:
            showmini1();
            i = prompt("Xóa khách hàng thứ : ");
            dem -= 1;
            array.splice(i, 1);
            break;
        case 5:
            ondragexit
    }

}// Menu
function delete1() {

}

function add() {// hàm nhập thông tin

    name1();
    cmnd1();
    //idCard = parseInt(prompt('Nhập số cmnd ', "195411269"));
    birthday1();

    address = prompt('Nhập địa chỉ : ', "295 Nguyễn Tất Thành, Đà Nẵng");
    promotion = parseFloat(prompt('Giảm giá (%) :', "20"));
    numberPeople = prompt('Số người đi cùng : ', "3");
    rentDays = parseInt(prompt('Ngày Thuê :', "3"));
    kindOfRoom1();
    customer1();
    typeOfService1();
    age1();
    fix_adr1();
    fix_ageandadr1();
    fix_rentday1();
    giaTien1();
    array[i] = new Array(name, idCard, birthday, email, address, promotion, numberPeople, rentDays, customer, typeOfService, kindOfRoom, giaTien, money_typeOfService, age);

}// Hàm ADD
function email1() {
    email = prompt('Nhập Email: ', "mirinda@gmail.com");
    var re_email = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    let boo_email = re_email.test(email);
    if (boo_email == false) {
        alert("ERRO");
        email1();
    }
}

function cmnd1() {

    idCard = parseInt(prompt('Nhập số cmnd ', "195411269"));
    var re_cmnd = /\b\d{9}\b/g;
    let boo_cmnd = re_cmnd.test(idCard);
    //alert(boo_cmnd);
    if (boo_cmnd == false) {
        cmnd1();
    }


}// demo check nhập 9 số cmnd true, false return fix

// function show() {// Hàng hiển thị thông tin
//
//
//     a = parseInt(prompt("Số Khách Hiện Tại :" + dem +
//         "\n1. Xem List Khách Hàng : " +
//         "\n.2 Xem Chi Tiết Khách hàng" +
//         "\n.3 Quay Lại Menu"
//     ));
//     switch (a) {
//         case 1:
//             showmini1();
//             return show();
//             break;
//         case 2:
//             showmini2();
//             return show();
//             break;
//         case 3:
//             return displayMainMenu();
//         default:
//             alert("ERROR");
//             return show();
//
//     }
// }//Hàm Hiển Thị
//
//
// function showmini1() { // show List khách hàng đang tồn tại
//     let result = "";
//     for (let k = 1; k < array.length; k++) {//
//         result += k + ". Tên Khách Hàng : " + array[k][0] + " Số cmnd : " + array[k][1] + "\n";//truy xuất tên khách hàng và số cmnd
//     }
//     alert(result);
//     // return show();
//
// }// Hàm Hiển thị list khách hiện có
//
// function showmini2() {// xuất thông tin chi tiết của khách hàng
//     i = parseInt(prompt("Xem Thông Tin Khách Hàng Thứ :"
//     ));
//     alert("1. Tên: " + array[i][0] + "\n2. CMND: " + array[i][1] + "\n3.Ngày Tháng Năm Sinh: " + array[i][2] + "\n4.Email: " + array[i][3] +
//         "\n5.Địa Chỉ: " + array[i][4] + "\n6.Giảm Giá: " + array[i][5] + "%" + "\n7.Số Người Đi Kèm: " + array[i][6] +
//         "\n8.Số Ngày Thuê: " + array[i][7] + "\n9.Customer: " + array[i][8] + "\n10. Loại Dịch Vụ: " + array[i][9] +
//         "\n11. Loại Phòng Thuê: " + array[i][10] + "\n12.Giá Tiền :" + array[i][11] + ' $');
//
// }// Hàm hiển thị chi tiết khách hàng

function edit() {
    showmini1();
    let edit_i = parseInt(prompt("Chỉnh sửa thông tin khách hàng thứ : "));
    edit_i--;
    let edit_j = parseInt(prompt("Bạn Muốn Chỉnh Sửa :" +
        "\n.0 Tên Khách hàng : " + listCustomers[edit_i].getName() +
        "\n.1 Số Cmnd" + listCustomers[edit_i].getIdCard() +
        "\n.2 Brithday" + listCustomers[edit_i].getBrithday() +
        "\n.3 Email " + listCustomers[edit_i].getEmail() +
        "\n.4 Địa Chỉ" + listCustomers[edit_i].getAddress() +
        "\n.5 Giảm Giá" + listCustomers[edit_i].getPromotion() +
        "\n.6 Số Người Đi Kèm" + listCustomers[edit_i].getNumberPeople() +
        "\n.7 Ngày thuê" + listCustomers[edit_i].getRentDays() +
        "\n.8 loại phòng thuê" + listCustomers[edit_i].getKindOfRoom() +
        "\n.9 loại dịch vụ" + listCustomers[edit_i].getTypeOfService() +
        "\n.10 Quay lại" +
        "" +
        "" +
        ""
    ));
    switch (edit_j) {
        case 0:
            listCustomers[edit_i].setName(prompt(" Name : "));
            break;
        case 1:
            listCustomers[edit_i].setIdCard(prompt(" idCard : "));
            break;
        case 2://gọi lại hàm nhập birthday
            birthday1();
            listCustomers[edit_i].setBirthday(birthday);
            break;
        case 3:
            email1();
            listCustomers[edit_i].setEmail(email);
            break;
        case 4:
            listCustomers[edit_i].setAddress(prompt(" address : "));
            break;
        case 5:
            listCustomers[edit_i].setPromotion(prompt(" promotion : "));
            break;
        case 6:
            listCustomers[edit_i].setNumberPeople(prompt(" numberPeople : "));
            break;
        case 7:
            listCustomers[edit_i].setRentDays(prompt(" rentDays : "));
            break;
        case 8://gọi lại hàm nhập customer
            customer1();
            listCustomers[edit_i].setCustomer(customer);
            break;
        case 9:
            typeOfService1();
            listCustomers[edit_i].setMoney_typeOfService(money_typeOfService);// thay đổi giá tiền theo typeofservicce
            listCustomers[edit_i].setTypeOfService(typeOfService);
            giaTien1();
            listCustomers[edit_i].setGiaTien(giaTien);
            break;
        case 10:
            kindOfRoom1();
            listCustomers[edit_i].setKindOfRoom(kindOfRoom);
            break;
        default:
            alert("ERROR");
            return edit()


    }
    showmini2(edit_i)
}// Hàm Chỉnh Sửa
function name1() {
    name = prompt('Tên Khách Hàng :', "Nguyễn Anh ĐỨc");
    let name2 = "";
    name = name.trim().toLocaleLowerCase();
    for (let i = 0; i < name.length; i++) {
        if (name.charAt(i) === " " && name.charAt(i + 1) === " ") {
            continue;
        }
        if (i === 0 || name.charAt(i - 1) === " ") {
            name2 += name.charAt(i).toUpperCase();
            continue;

        }
        name2 += name.charAt(i);

    }
    name = name2;
    alert(name);

}

function customer1() {// hàm nhập customer
    id_customer = parseInt(prompt("CUSTOMER" +
        "\n1.Diamond" +
        "\n2.Platinum" +
        "\n3.Gold" +
        "\n4.Silver" +
        "\n5.Member", "1"));
    switch (id_customer) {
        case 1 :
            customer = "Diamond";
            fix_customer = 15;
            break;
        case 2 :
            customer = "Platinum";
            fix_customer = 10;
            break;
        case 3 :
            customer = "Gold";
            fix_customer = 5;
            break;
        case 4:
            customer = "Silver";
            fix_customer = 2;
            break;
        case 5:
            customer = "Member";
            fix_customer = 0;

        default:
            alert("ERROR");
            return customer1();
    }
    ;


}// Hàm Nhập Customer

function typeOfService1() {
    id_typeOfService = parseInt(prompt("TypeOfService" +
        "\n1.Villa" +
        "\n2.House" +
        "\n3.Room", "1"));
    switch (id_typeOfService) {
        case 1 :
            typeOfService = "Villa";
            money_typeOfService = 500;
            break;
        case 2 :
            typeOfService = "House";
            money_typeOfService = 300;
            break;
        case 3 :
            typeOfService = "Room";
            money_typeOfService = 100;
            break;

        default:
            alert("ERROR");
            return typeOfService1();
    }

} // Hàm Nhập typeOfService

function kindOfRoom1() {
    id_kindOfRoom = parseInt(prompt("KindOfRoom" +
        "\n1.Vip" +
        "\n2.Business" +
        "\n3.Normal", "1"));
    switch (id_kindOfRoom) {
        case 1 :
            kindOfRoom = "Vip";
            break;
        case 2 :
            kindOfRoom = "Business";
            break;
        case 3 :
            kindOfRoom = "Normal";
            break;

        default:
            alert("ERROR");
            return kindOfRoom1();
    }
}// Hàm Nhập kindOfRoom

function giaTien1() {
    int_rentDays = parseInt(customer.getRentDays());
    giaTien = customer.getRentDays() * customer.getMoney_typeOfService* (1 - customer.getPromotion() / 100) - (int_rentDays * (customer.getFix_rentday() + customer.setFix_adr() + customer.setFix_customer() + customer.setFix_ageandadr()));
}// Hàm Tính Giá Tiền
function birthday1() {
    birthday = prompt("Nhập vào ngày tháng năm sinh theo định dạng 'MM/dd/yyyy':", "10/01/1998");

    var rebirthday = /\b\d{1,2}\/\d{1,2}\/(\d{4}|\d{2})\b/g;
    let boo = rebirthday.test(birthday);
    //alert(boo);
    if (boo === true) {

        var day1 = parseInt(birthday.substring(0, 2));
        var month1 = parseInt(birthday.substring(3, 5));
        var year1 = parseInt(birthday.substring(6, 10));
        if (day1 > 31) {
            alert("Lỗi Ngày Sinh!");
            birthday1();
        } else if (month1 > 12) {
            alert("Lỗi Tháng Sinh :");
            birthday1();
        } else if (year1 > 2003) {
            alert("Lỗi năm Sinh :");
            birthday1();
        }

    } else {
        alert("ERRO");
        birthday1();
    }

}// Hàm xử lí tuổi
// function age1() {
//     current = new Date().getFullYear();
//     current_day = new Date().getDate();
//     current_month = new Date().getMonth() + 1;
//     let month1 = parseInt(this.brithday.substring(3, 5));
//     let day2 = parseInt(this.birthday.substring(0, 2));
//     birthday2 = parseInt(this.birthday.substring(6, 10));//cover về định dạng year
//     var age2 = parseInt(current - birthday2);
//
//     if (month1 == current_month) {
//         if (day2 > current_day) {
//             age = age2 - 1;
//         } else {
//             age = age2;
//         }
//     }
//     if (month1 > current_month) {
//         age = age2 - 1;
//     } else {
//         age = age2;
//     }
//     return (age);
//
// }// Hàm Tính tuổi
function fix_adr1() {
    if (customer.getAddress().indexOf("Đà Nẵng") > 0) {
        fix_adr = 20;
    } else if ((customer.getAddress().indexOf("Huế")) > 0) {
        fix_adr = 10;
    } else if ((customer.getAddress().indexOf("Quảng Nam")) > 0) {
        fix_adr = 5;
    } else {
        fix_adr = 0
    }


}// Hàm Fix giá theo địa chỉ
function fix_rentday1() {

    if (parseInt(customer.getRentDays()) > 7) {
        fix_rentday = 30;

    } else if (parseInt(customer.getRentDays()) >= 5) {
        fix_rentday = 20;

    } else if (parseInt(customer.getRentDays()) >= 2) {
        fix_rentday = 10;

    }
}// Hàm Fix giá theo ngày thuê
function fix_ageandadr1() {
    let fix_adr2 = fix_adr;
    if (fix_adr2 = 20 && age >= 30) {
        fix_ageandadr = 2;
    } else if (fix_adr2 = 20 && age >= 20) {
        fix_ageandadr = 1;
    }

}// hàm Fix giá theo địa chỉ và độ tuổi
