

this.setFix_adr = function () {
    if (this.address.indexOf("Đà Nẵng") > 0) {
        this.fix_adr = 20;
    } else if ((this.address.indexOf("Huế")) > 0) {
        this.fix_adr = 10;
    } else if ((this.address.indexOf("Quảng Nam")) > 0) {
        this.fix_adr = 5;
    } else {
        this.fix_adr = 0
    }
};
this.getFix_adr = function () {
    this.setFix_adr();
    return this.fix_adr;
};
this.setFix_rentday = function () {
    if (parseInt(this.rentDays) > 7) {
        this.fix_rentday = 30;

    } else if (parseInt(this.rentDays) >= 5) {
        this.fix_rentday = 20;

    } else if (parseInt(this.rentDays) >= 2) {
        this.fix_rentday = 1;
    }
    return this.fix_renday;
};
this.getFix_rentday = function () {
    this.setFix_rentday();
    return this.fix_rentday;
};

this.setFix_ageandadr = function () {
    var fix_adr2 = this.fix_adr;
    if (fix_adr2 = 20 && age >= 30) {
        fix_ageandadr = 2;
    } else if (fix_adr2 = 20 && age >= 20) {
        fix_ageandadr = 1;
    }
    this.fix_ageandadr = fix_ageandadr;
};
this.getFix_ageandadr = function () {
    this.setFix_ageandadr();
    return this.fix_ageandadr;
};