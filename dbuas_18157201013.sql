drop database if exists dbuas_18157201013;

create database dbuas_18157201013;
use dbuas_18157201013;

create table penulis(
    id varchar(12) not null,
    nama varchar(64) not null,
    alamat text,
    no_telepon varchar(14),
    website varchar(64),
    email varchar(64),
    primary key(id)
);

create table buku(
    isbn varchar(18) not null,
    judul text not null,
    jumlah_halaman int not null,
    tahun_terbit varchar(4) not null,
    penerbit varchar(64) not null,
    penulis_id varchar(12) not null,
    primary key(isbn),
    foreign key(penulis_id) references penulis(id)
);


insert into penulis values
    ("P001", "Budi", "Jl. Ruruhi", "08812662", "rindev.com", "budi@gmail.com"),
    ("P002", "JAY", "Jl. Simatupang", "08812662", "jay.com", "jay@gmail.com");

insert into buku values
    ("B001", "Java On Android", 22, "2019", "Narendra", "P001"),
    ("B002", "Kotlin On Android", 12, "2020", "Ahmad", "P002");
