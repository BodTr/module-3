create database clinic_management;
use clinic_management;

create table doctors
(
	id int auto_increment,
	name varchar(50),
    speciality varchar(50),
    phone_number int,
    email varchar(20),
    experience varchar(30),
    primary key(id)
);

create table patients
(
	id int auto_increment,
    name varchar(50),
    age int,
    sex varchar(20),
    phone_number int,
    adress varchar(50),
    medical_history varchar(200),
    primary key(id)
    
);

create table appointments
(
	id int auto_increment,
    pID int not null,
    dID int not null,
    time datetime,
    status varchar(30),
    primary key(id),
    foreign key (pID) references patients(id),
    foreign key (dID) references doctors(id),
    unique(pID, time),
    unique(dID, time)
    
);

create table invoices
(
	id int auto_increment,
    pID int not null,
    invoice_code varchar(20) unique,
    total_fees int,
    payment_method varchar(30),
    payment_date datetime,
    primary key(id),
    foreign key (pID) references patients(id)
);

create table prescriptions
(
	id int auto_increment,
    pID int not null,
    dID int not null,
    primary key(id),
    foreign key(pID) references patients(id),
    foreign key(dID) references doctors(id)
);

create table medicines
(
	id int auto_increment,
    name varchar(50),
    uses varchar(200),
    units varchar(30),
    quantity int,
    price int,
    primary key(id)
);

create table prescription_details
(
	id int auto_increment,
    mID int not null,
    preID int not null,
    dosage varchar(100),
    instruction varchar(100),
    primary key(id),
    foreign key(mID) references medicines(id),
    foreign key(preID) references prescriptions(id)
);