
drop database if exists database_furama;
create database database_furama;
-- ------------------------------------------------------------------------------- table
use database_furama;
create table vi_tri(
id_vi_tri int NOT NULL AUTO_INCREMENT,
ten varchar(50) NOT NULL,
PRIMARY KEY (id_Vi_Tri)
);
create table trinh_do(
id_trinh_do int NOT NULL AUTO_INCREMENT,
trinh_do varchar(50) NOT NULL,
PRIMARY KEY (id_trinh_do)
);
create table bo_phan(
id_bo_phan int NOT NULL AUTO_INCREMENT,
ten_bo_phan varchar(50) NOT NULL,
PRIMARY KEY (id_bo_phan)
);
create table nhan_vien(
id_nhan_vien int NOT NULL AUTO_INCREMENT,
ho_ten varchar(50) NOT NULL,
id_Vi_Tri int NOT NULL,
id_trinh_do int NOT NULL,
id_bo_phan int NOT NULL,
ngay_sinh date NOT NULL,
so_cmnd varchar(45) NOT NULL,
luong varchar(45) NOT NULL,
SDT varchar(10) NOT NULL,
email varchar(50),
dia_chi varchar(50),
PRIMARY KEY (id_nhan_vien),
FOREIGN KEY (id_Vi_Tri) REFERENCES vi_tri(id_Vi_Tri),
FOREIGN KEY (id_trinh_do) REFERENCES trinh_do(id_trinh_do),
FOREIGN KEY (id_bo_phan) REFERENCES bo_phan(id_bo_phan)
);
create table dich_vu_di_kem(
id_dich_vu_di_kem int NOT NULL AUTO_INCREMENT,
ten_dich_vu_di_kem varchar(50) NOT NULL,
gia int NOT NULL,
don_vi int NOT NULL,
trang_thai_kha_dung varchar(45) NOT NULL,
PRIMARY KEY (id_dich_vu_di_kem)
);
create table loai_khach(
id_loai_khach int NOT NULL AUTO_INCREMENT,
ten_loai_khach varchar(50) NOT NULL,
PRIMARY KEY (id_loai_khach)
);
create table khach_hang(
id_khach_hang int NOT NULL AUTO_INCREMENT,
id_loai_khach int NOT NULL,
ho_ten varchar(50) NOT NULL,
ngay_sinh date NOT NULL,
so_cmnd varchar(45) NOT NULL,
SDT varchar(10) NOT NULL,
email varchar(50),
dia_chi varchar(50),
PRIMARY KEY (id_khach_hang),
FOREIGN KEY (id_loai_khach) REFERENCES loai_khach(id_loai_khach)
);
create table kieu_thue(
id_kieu_thue int NOT NULL AUTO_INCREMENT,
ten_kieu_thue varchar(50) NOT NULL,
gia int NOT NULL,
PRIMARY KEY (id_kieu_thue)
);
create table Loai_Dich_Vu(
id_Loai_Dich_Vu int NOT NULL AUTO_INCREMENT,
ten_Loai_Dich_Vu varchar(50) NOT NULL,
PRIMARY KEY (id_Loai_Dich_Vu)
);
create table dich_vu(
id_Dich_Vu int NOT NULL AUTO_INCREMENT,
ten_Dich_Vu varchar(50) NOT NULL,
dien_Tich int NOT NULL,
so_nguoi_toi_da int NOT NULL,
chi_phi_thue varchar(45) NOT NULL,
id_kieu_thue int NOT NULL,
id_Loai_Dich_Vu int NOT NULL,
trang_thai varchar(10) NOT NULL,
PRIMARY KEY (id_Dich_Vu),
FOREIGN KEY (id_kieu_thue) REFERENCES kieu_thue(id_kieu_thue),
FOREIGN KEY (id_Loai_Dich_Vu) REFERENCES Loai_Dich_Vu(id_Loai_Dich_Vu)
);
create table hop_dong(
id_hop_dong int NOT NULL AUTO_INCREMENT,
id_nhan_vien int NOT NULL,
id_khach_hang int NOT NULL,
id_Dich_Vu int NOT NULL,
ngay_lam_hop_dong date NOT NULL,
ngay_ket_thuc_hop_dong date NOT NULL,
tien_dat_coc int NOT NULL,
ton_tien int NOT NULL,
PRIMARY KEY (id_hop_dong),
FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien) ON DELETE CASCADE,
FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id_khach_hang) ON DELETE CASCADE,
FOREIGN KEY (id_Dich_Vu) REFERENCES dich_vu(id_Dich_Vu)
);
create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int NOT NULL AUTO_INCREMENT,
id_hop_dong int NOT NULL,
id_dich_vu_di_kem int NOT NULL,
so_luong int NOT NULL,
PRIMARY KEY (id_hop_dong_chi_tiet),
FOREIGN KEY (id_hop_dong) REFERENCES hop_dong(id_hop_dong) ON DELETE CASCADE,
FOREIGN KEY (id_dich_vu_di_kem) REFERENCES dich_vu_di_kem(id_dich_vu_di_kem)
);
-- ------------------------------------------------------------------------------------- data

SET SQL_SAFE_UPDATES = 0;
delete from hop_dong_chi_tiet;
delete from hop_dong;
delete from dich_vu;
delete from Loai_Dich_Vu;
delete from kieu_thue;
delete from khach_hang;
delete from loai_khach;
delete from dich_vu_di_kem;
delete from nhan_vien;
delete from bo_phan;
delete from trinh_do;
delete from vi_tri;

insert into vi_tri(id_vi_tri,ten) value(1,'nhân viên bán hàng');
insert into vi_tri(id_vi_tri,ten) value(2,'giám đốc');

insert into trinh_do(id_trinh_do, trinh_do) value(1, 'đại học');
insert into trinh_do(id_trinh_do, trinh_do) value(2, 'cao đẳng');

insert into bo_phan(id_bo_phan, ten_bo_phan) value(1, 'bán hàng');
insert into bo_phan(id_bo_phan, ten_bo_phan) value(2, 'quảng lý');

insert into nhan_vien(id_nhan_vien, ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, SDT, email, dia_chi) 
value(1, 'Nguyễn Văn A',1,1,1,'1990/10/10',123456789,10000000,0123456789,'nguyenvana@gmail.com', 'sơn trà đà nẵng');
insert into nhan_vien(id_nhan_vien, ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, SDT, email, dia_chi) 
value(2, 'Hồ Văn B',1,1,1,'1990/10/10',123456799,10000000,0123456799,'hovanb@gmail.com', 'sơn trà đà nẵng');
insert into nhan_vien(id_nhan_vien, ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, SDT, email, dia_chi) 
value(3, 'Trần Tuấn Anh Kiệt',1,1,1,'1990/10/10',123456999,10000000,0123456999,'trantuananhkiet@gmail.com', 'sơn trà đà nẵng');

insert into dich_vu_di_kem(id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) 
value(1,'massage',1,1000,'trạng thái không biết');
insert into dich_vu_di_kem(id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) 
value(2,'karaoke',2,1000,'trạng thái không biết');
insert into dich_vu_di_kem(id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) 
value(3,'thức ăn',3,1000,'trạng thái không biết');
insert into dich_vu_di_kem(id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) 
value(4,'nước uống',4,1000,'trạng thái không biết');
insert into dich_vu_di_kem(id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung) 
value(5,'thuê xe di chuyển tham quan resort',5,1000,'trạng thái không biết');

insert into loai_khach(id_loai_khach,ten_loai_khach) value(1,'Diamond');
insert into loai_khach(id_loai_khach,ten_loai_khach) value(2,'Platinium');
insert into loai_khach(id_loai_khach,ten_loai_khach) value(3,'Gold');
insert into loai_khach(id_loai_khach,ten_loai_khach) value(4,'Silver');
insert into loai_khach(id_loai_khach,ten_loai_khach) value(5,'Member');

insert into khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,SDT,email,dia_chi)
value(1,1,'Hồ Văn Quốc A','2010/11/10',123456781,0123456781,'hovanquoca@gmail.com','trần cao vân đà nẵng việt nam');
insert into khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,SDT,email,dia_chi)
value(2,1,'Hồ Văn Quốc B','1990/11/10',123456721,0123456782,'hovanquocb@gmail.com','trần cao vân quãng trị việt nam');
insert into khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,SDT,email,dia_chi)
value(3,1,'Hồ Văn Quốc C','1900/11/10',123456783,0123456783,'hovanquocv@gmail.com','trần cao vân việt nam');
insert into khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,SDT,email,dia_chi)
value(4,2,'Hồ Văn','1990/11/10',123456784,0123456784,'hovan@gmail.com','trần cao vân vinh việt nam');
insert into khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,SDT,email,dia_chi)
value(5,3,'Hồ Văn Quốc D','1991/11/10',123456785,0123456785,'hovanquocd@gmail.com','trần cao vân quảng ngãi việt nam');
insert into khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,SDT,email,dia_chi)
value(6,1,'Nguyễn Văn A','1992/11/10',123456786,0123456786,'nguyenvana@gmail.com','trần cao vân vinh việt nam');
insert into khach_hang(id_khach_hang,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,SDT,email,dia_chi)
value(7,1,'Nguyễn Văn A','1992/11/10',123456786,0123456786,'nguyenvana@gmail.com','trần cao vân quảng ngãi việt nam');

insert into	kieu_thue(id_kieu_thue,ten_kieu_thue,gia)
value (1,'thuê theo năm',3650);
insert into	kieu_thue(id_kieu_thue,ten_kieu_thue,gia)
value (2,'thuê theo tháng',300);
insert into	kieu_thue(id_kieu_thue,ten_kieu_thue,gia)
value (3,'thuê theo ngày',10);
insert into	kieu_thue(id_kieu_thue,ten_kieu_thue,gia)
value (4,'thuê theo giờ',1);

insert into Loai_Dich_Vu(id_Loai_Dich_Vu,ten_Loai_Dich_Vu) value(1,'Villa');
insert into Loai_Dich_Vu(id_Loai_Dich_Vu,ten_Loai_Dich_Vu) value(2,'House');
insert into Loai_Dich_Vu(id_Loai_Dich_Vu,ten_Loai_Dich_Vu) value(3,'Room');

insert into dich_vu(id_Dich_Vu,ten_Dich_Vu,dien_Tich,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_Loai_Dich_Vu,trang_thai)
value(1,'tên dịch vụ 1', 10, 5, 1, 1, 1,'trống');
insert into dich_vu(id_Dich_Vu,ten_Dich_Vu,dien_Tich,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_Loai_Dich_Vu,trang_thai)
value(2,'tên dịch vụ 2', 20, 10, 2, 2, 2,'trống');
insert into dich_vu(id_Dich_Vu,ten_Dich_Vu,dien_Tich,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_Loai_Dich_Vu,trang_thai)
value(3,'tên dịch vụ 3', 30, 15, 3, 3, 3,'trống');
insert into dich_vu(id_Dich_Vu,ten_Dich_Vu,dien_Tich,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_Loai_Dich_Vu,trang_thai)
value(4,'tên dịch vụ 4', 40, 20, 4, 4, 1,'trống');

insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_Dich_Vu,ngay_lam_hop_dong,ngay_ket_thuc_hop_dong,tien_dat_coc,ton_tien)
value (1, 1, 1, 1, '2020/03/12', '2021/03/12', 10, 1000);
insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_Dich_Vu,ngay_lam_hop_dong,ngay_ket_thuc_hop_dong,tien_dat_coc,ton_tien)
value (2, 1, 1, 1, '2018/03/12', '2019/03/12', 10, 1000);
insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_Dich_Vu,ngay_lam_hop_dong,ngay_ket_thuc_hop_dong,tien_dat_coc,ton_tien)
value (3, 2, 2, 2, '2018/03/12', '2018/04/12', 10, 1000);
insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_Dich_Vu,ngay_lam_hop_dong,ngay_ket_thuc_hop_dong,tien_dat_coc,ton_tien)
value (4, 3, 2, 2, '2019/03/12', '2019/04/12', 10, 1000);
insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_Dich_Vu,ngay_lam_hop_dong,ngay_ket_thuc_hop_dong,tien_dat_coc,ton_tien)
value (5, 2, 2, 3, '2019/11/12', '2019/12/12', 10, 1000);
insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_Dich_Vu,ngay_lam_hop_dong,ngay_ket_thuc_hop_dong,tien_dat_coc,ton_tien)
value (6, 1, 5, 3, '2019/10/12', '2019/10/12', 10, 1000);

insert into hop_dong_chi_tiet(id_hop_dong_chi_tiet,id_hop_dong,id_dich_vu_di_kem,so_luong)
value(1,1,1,2),
(2,2,1,3),
(3,1,2,3),
(4,6,1,3),
(5,6,2,3),
(6,6,3,3),
(7,5,4,3),
(8,5,2,3);

-- -------------------------------------------------------------------------------------------------------------------------- bài tập

-- câu 2;
-- use tên database
select * 
from nhan_vien
where (ho_ten regexp '^[htk].*')  and length(ho_ten)<=15;

-- câu 3;
SELECT 
    *
FROM
    khach_hang AS KH
WHERE
    (
		(
			YEAR(CURDATE()) - YEAR(kh.ngay_sinh) > 18
			OR (YEAR(CURDATE()) - YEAR(ngay_sinh) = 18
			AND (MONTH(CURDATE()) > MONTH(ngay_sinh)
			OR (MONTH(CURDATE()) = MONTH(ngay_sinh)
			AND DAY(CURDATE()) > DAY(ngay_sinh)))))
		AND (
			(YEAR(CURDATE()) - YEAR(ngay_sinh) < 50)
			OR (YEAR(CURDATE()) - YEAR(ngay_sinh) = 50
			AND (MONTH(CURDATE()) < MONTH(ngay_sinh)
			OR (MONTH(CURDATE()) = MONTH(ngay_sinh)
			AND DAY(CURDATE()) < DAY(ngay_sinh)))))
        AND (
			dia_chi LIKE ('%quang tri%')
			OR dia_chi LIKE ('%da nang%'))
	);

-- câu 4

SELECT 
    kh.id_khach_hang,
    kh.ho_ten,
    COUNT(*) AS 'số lần đặt phòng'
FROM
    (khach_hang KH
    JOIN hop_dong HD ON HD.id_khach_hang = KH.id_khach_hang)
        JOIN
    loai_khach LK ON KH.id_loai_khach = LK.id_loai_khach
WHERE
    LK.ten_loai_khach = 'Diamond'
GROUP BY KH.id_khach_hang
ORDER BY COUNT(*);


-- câu 5

select kh.id_khach_hang, kh.ho_ten, hd.id_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc_hop_dong, (dv.chi_phi_thue+hdct.so_luong*dvdk.Gia) as ton_tien
from khach_hang kh
left join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
left join dich_vu dv on dv.id_Dich_Vu=hd.id_Dich_Vu 
left join hop_dong_chi_tiet hdct on hdct.id_hop_dong=hd.id_hop_dong
left join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem  ;


-- câu 6
select * from dich_vu;
select * from hop_dong;
SELECT 
    dv.id_Dich_Vu,
    ten_Dich_Vu,
    dien_Tich,
    chi_phi_thue,
    ten_Loai_Dich_Vu,
    ngay_lam_hop_dong
FROM
    dich_vu dv
        INNER JOIN
    Loai_Dich_Vu ldv ON dv.id_Loai_Dich_Vu = ldv.id_Loai_Dich_Vu
        LEFT JOIN
    hop_dong hd ON dv.id_Dich_Vu = hd.id_Dich_Vu
WHERE
    NOT EXISTS( SELECT 
            id_Dich_Vu
        FROM
            hop_dong hd
        WHERE
            hd.id_Dich_Vu=dv.id_Dich_Vu and
            YEAR(hd.ngay_lam_hop_dong) >= 2019);

-- câu 7

SELECT 
    DV.id_Dich_Vu,
    DV.ten_Dich_Vu,
    DV.dien_Tich,
    DV.so_nguoi_toi_da,
    DV.chi_phi_thue,
    LDV.ten_Loai_Dich_Vu
FROM
    dich_vu DV
        INNER JOIN
    Loai_Dich_Vu LDV ON DV.id_Loai_Dich_Vu = LDV.id_Loai_Dich_Vu
        LEFT JOIN
    hop_dong HD ON DV.id_Dich_Vu = HD.id_Dich_Vu
WHERE
		EXISTS( SELECT 
            id_Dich_Vu
        FROM
            hop_dong HD
        WHERE
            HD.id_Dich_Vu=DV.id_Dich_Vu 
            and YEAR(HD.ngay_lam_hop_dong) = 2019 )
    and NOT EXISTS( SELECT 
            id_Dich_Vu
        FROM
            hop_dong HD
        WHERE
            HD.id_Dich_Vu=DV.id_Dich_Vu 
            and YEAR(HD.ngay_lam_hop_dong) >= 2019 );
            
-- bài 8
-- cách 1
select distinct ho_ten
from khach_hang;

-- cách 2
SELECT
    ho_ten
FROM
    khach_hang
GROUP BY ho_ten
HAVING COUNT(ho_ten) >= 1;

-- cách 3
SELECT 
    ho_ten
FROM
    khach_hang
UNION SELECT 
    ho_ten
FROM
    khach_hang;

-- bài 9
select month(ngay_lam_hop_dong) as thang,sum(ton_tien) as 'tổng tiền trong tháng'
from hop_dong
where year(ngay_lam_hop_dong)=2019
group by thang;

-- bài đúng
drop table if exists Temp;
create temporary table Temp(
thang int
);
insert into Temp(thang) value(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);
Select thang, count(month(ngay_lam_hop_dong)) as 'Số lần đặt'
From Temp
Left join hop_dong on month(ngay_lam_hop_dong) = thang
and year(ngay_lam_hop_dong) = 2019
group by thang
order by thang;

-- bài 10
select hop_dong.id_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc_hop_dong, tien_dat_coc, count(id_hop_dong_chi_tiet) as so_luongdich_vu_di_kem
from hop_dong
right join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
group by id_hop_dong;

-- bài 11
select *
from dich_vu_di_kem DVDK
where DVDK.id_dich_vu_di_kem in(
select HDCT.id_dich_vu_di_kem from hop_dong_chi_tiet HDCT,hop_dong HD,khach_hang KH ,loai_khach LKH
where (LKH.ten_loai_khach = 'Diamond'
and (KH.dia_chi like '%vinh%' 
or KH.dia_chi like '%quảng ngãi%')));

-- bài 12
select HD.id_hop_dong, NV.ho_ten 'họ tên nhân viên', KH.ho_ten 'họ tên khách hàng',
 KH.SDT, ten_Dich_Vu, count(HDCT.id_hop_dong) as 'số lượng dịch vụ đi kèm',tien_dat_coc
from hop_dong HD
inner join nhan_vien  NV on HD.id_nhan_vien = NV.id_nhan_vien 
inner join khach_hang KH on HD.id_khach_hang = KH.id_khach_hang
inner join dich_vu DV on HD.id_Dich_Vu = DV.id_Dich_Vu
left join hop_dong_chi_tiet HDCT on HD.id_hop_dong = HDCT.id_hop_dong
where HD.id_hop_dong in(
select HD.id_hop_dong from	hop_dong HD
where 
year(ngay_lam_hop_dong)=2019
and month(ngay_lam_hop_dong)>9
and HD.id_hop_dong not in(
select HD.id_hop_dong from hop_dong HD
where year(ngay_lam_hop_dong)=2019
and month(ngay_lam_hop_dong)<7))
group by HDCT.id_hop_dong;

-- bài 13
 SELECT 
    *
FROM
    dich_vu_di_kem
WHERE
    id_dich_vu_di_kem IN (SELECT 
            id_dich_vu_di_kem
        FROM
            hop_dong_chi_tiet
        GROUP BY id_dich_vu_di_kem
        HAVING COUNT(id_dich_vu_di_kem) = (SELECT 
                MAX(so_luongDV)
            FROM
                (SELECT 
                    id_dich_vu_di_kem, COUNT(*) AS so_luongDV
                FROM
                    hop_dong_chi_tiet
                GROUP BY id_dich_vu_di_kem) a));

-- bài 14
select HDCT.id_hop_dong,ten_Loai_Dich_Vu, ten_dich_vu_di_kem,count(DVDK.id_dich_vu_di_kem) SoLanSuDung
from hop_dong_chi_tiet HDCT
join dich_vu_di_kem DVDK on HDCT.id_dich_vu_di_kem = DVDK.id_dich_vu_di_kem
join hop_dong HD on HDCT.id_hop_dong = HD.id_hop_dong
join dich_vu DV on HD.id_Dich_Vu = DV.id_Dich_Vu
join Loai_Dich_Vu LDV on DV.id_Loai_Dich_Vu = LDV.id_Loai_Dich_Vu
group by DVDK.id_dich_vu_di_kem
having SoLanSuDung=1;

-- bài 15
select id_nhan_vien,ho_ten,trinh_do,ten_bo_phan,SDT,dia_chi
from nhan_vien NV
join trinh_do TD on NV.id_trinh_do = TD.id_trinh_do
join bo_phan BP on NV.id_bo_phan = BP.id_bo_phan
where id_nhan_vien in(
select id_nhan_vien
from hop_dong HD
where year(ngay_lam_hop_dong) between 2018 and 2019
group by id_nhan_vien
having count(id_nhan_vien)<4);

-- bài 16
delete from nhan_vien
where id_nhan_vien not in(select id_nhan_vien
from hop_dong HD 
where year(ngay_lam_hop_dong) between 2017 and 2019
);

-- bài 17
update khach_hang KH
set id_loai_khach= 2  
where id_loai_khach = 1
and id_khach_hang in(select id_khach_hang
from hop_dong HD
where year(ngay_lam_hop_dong)=2019
group by id_khach_hang
having sum(ton_tien)>10000000);

-- bài 18
delete from khach_hang
where id_khach_hang in(select id_khach_hang
from hop_dong HD
where year(ngay_lam_hop_dong)<2019
);

-- bài 19
update dich_vu_di_kem
set gia = gia*2
where id_dich_vu_di_kem in(select id_dich_vu_di_kem
from hop_dong_chi_tiet HDCT
join hop_dong HD on HDCT.id_hop_dong = HD.id_hop_dong
where year(ngay_lam_hop_dong)=2019
group by id_dich_vu_di_kem
having count(id_dich_vu_di_kem)>1);

-- bài 20
select  id_nhan_vien ID, ho_ten, email, SDT, ngay_sinh, dia_chi
from nhan_vien as NV
UNION all
select id_khach_hang, ho_ten, email, SDT, ngay_sinh, dia_chi
from khach_hang as KH

