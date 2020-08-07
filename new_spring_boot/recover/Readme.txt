WEBSERVICE TEST PROJECT MODULE 4 ->>>>>>>>>>
API CRUD(Method : GET - POST - PUT - DELETE) :
http://localhost:8080/users/

JSON CRUD  :
{
        "name": "Anh Đức",
        "email": "vuagreennhan@gmail.com",
        "phoneNumber": "01653915969",
        "idCard": "85236999",
        "password": "duc123456",
        "question": "tcmb",
        "answer": "Anh",
        "active": null,
        "passwordResetCode": null
    }

API FORGOT PASSWORD (Method : GET):
 -Send Mail Recover:
http://localhost:8080/users/verify/email/{email}
- Send Code Recover:
http://localhost:8080/users/verify/email/{email}/{code}

API FORGOT PASSWORD (Method : POST):
-Send Info :
http://localhost:8080/users/verify/info

-JSON :
{
        "email": "vuagreennhan@gmail.com",
        "phoneNumber": "01653915969",
        "question": "tcmb",
        "answer": "Anh",
    }

* : " Mọi người nhớ cấu hình lại file application.properties trước khi chạy, chúc mn cuối tuần vui vẻ !"

API test Login (Method POST) :
http://localhost:8080/login/

-JSON :
{
        "email": "vuagreennhan@gmail.com",
        "password": "duc123",
    }
