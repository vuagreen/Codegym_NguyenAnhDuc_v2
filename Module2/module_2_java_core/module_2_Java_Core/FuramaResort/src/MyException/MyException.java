package MyException;
//ko cần tới
import Commons.Sc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyException {

    public static Date birthdayException(String str,String strE) {
        String regexDate="^[\\d]{2}/[\\d]{2}/[\\d]{4}";
        boolean birthday = false;
        Date date = new Date();
        while (!birthday) {
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(Sc.input(str, strE, regexDate));
            } catch (Exception e) {
                continue;
            }
                if (date.getYear() > 0) {
                    Calendar dateNew = Calendar.getInstance();
                    dateNew.add(Calendar.YEAR, -18);
                    if (dateNew.getTime().getTime() > date.getTime()) {
                        birthday = true;
                        continue;
                    }
                }
            System.out.println(strE);
        }
        return date;
    }

    public static void main(String[] args) {
        Date date = new Date();
        date=MyException.birthdayException("Nhập vào birthday: ","Bạn cần nhập ký tự đầu tiên viết hoa các ký tự tiếp theo viết thường.");
        System.out.println(date);
    }

}
