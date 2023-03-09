/*Database for Advanced Systems Project CIST 2931
Author: Milo Parr*/
CREATE TABLE `employee` (
    `employee_id` int  NOT NULL ,
    `employee_fname` varchar(20)  NOT NULL ,
    `employee_lname` varchar(20)  NOT NULL ,
    `employee_phone` int  NOT NULL ,
    `employee_email` varchar(60)  NOT NULL ,
    `dept_id` int  NOT NULL ,
    `schedule_id` varchar(10)  NOT NULL ,
    PRIMARY KEY (
        `employee_id`
    )
);

CREATE TABLE `department` (
    `dept_id` int  NOT NULL ,
    `dept_name` varchar(100)  NOT NULL ,
    PRIMARY KEY (
        `dept_id`
    )
);

CREATE TABLE `customers` (
    `customer_id` int  NOT NULL ,
    `customer_fname` varchar(20)  NOT NULL ,
    `customer_lname` varchar(20)  NOT NULL ,
    `customer_phone` int  NOT NULL ,
    `customer_email` varchar(60)  NOT NULL ,
    `address_id` int  NOT NULL ,
    PRIMARY KEY (
        `customer_id`
    )
);

CREATE TABLE `address` (
    `add_id` int  NOT NULL ,
    `address1` varchar(200)  NOT NULL ,
    `address2` varchar(200)  NULL ,
    `add_city` varchar(50)  NOT NULL ,
    `add_state` varchar(20)  NOT NULL ,
    `add_zip` varchar(15)  NOT NULL ,
    PRIMARY KEY (
        `add_id`
    )
);

CREATE TABLE `appointment` (
    `appt_id` int  NOT NULL ,
    `employee_id` varchar(10)  NOT NULL ,
    `customer_id` varchar(10)  NOT NULL ,
    `service_id` varchar(10)  NOT NULL ,
    `appt_date` datetime  NOT NULL ,
    `appt_time` int  NOT NULL ,
    PRIMARY KEY (
        `appt_id`
    )
);

CREATE TABLE `shift` (
    `shift_id` int  NOT NULL ,
    `start_time` datetime  NOT NULL ,
    `end_time` datetime  NOT NULL ,
    PRIMARY KEY (
        `shift_id`
    )
);

CREATE TABLE `services` (
    `service_id` varchar(10)  NOT NULL ,
    `service_name` varchar(100)  NOT NULL ,
    PRIMARY KEY (
        `service_id`
    )
);

CREATE TABLE `schedule` (
    `schedule_id` int  NOT NULL ,
    `day_of_week` varchar(20)  NOT NULL ,
    `shift_id` varchar(10)  NOT NULL 
);

CREATE TABLE `users` (
    `user_id` int  NOT NULL ,
    `username` varchar(20)  NOT NULL ,
    `user_pass` varchar(20)  NOT NULL ,
    PRIMARY KEY (
        `user_id`
    )
);




