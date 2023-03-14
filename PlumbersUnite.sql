/*Database for Advanced Systems Project CIST 2931
Author: Milo Parr*/
CREATE TABLE `employee` (
    `employee_id` int  NOT NULL ,
    `employee_fname` varchar(20)  NOT NULL ,
    `employee_lname` varchar(20)  NOT NULL ,
    `employee_phone` char(10)  NOT NULL ,
    `employee_email` varchar(60)  NOT NULL ,
    `dept_id` int  NOT NULL ,
    `schedule_id` int  NOT NULL ,
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
    `customer_phone` char(10)  NOT NULL ,
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
    `appt_time` varchar(10)  NOT NULL ,
    PRIMARY KEY (
        `appt_id`
    )
);

CREATE TABLE `shift` (
    `shift_id` int  NOT NULL ,
    `start_time` time  NOT NULL ,
    `end_time` time  NOT NULL ,
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
    `shift_id` int  NOT NULL 
);

CREATE TABLE `users` (
    `user_id` int  NOT NULL ,
    `username` varchar(20)  NOT NULL ,
    `user_pass` varchar(20)  NOT NULL ,
    PRIMARY KEY (
        `user_id`
    )
);

INSERT INTO employee (employee_id, employee_fname, employee_lname, employee_phone, employee_email, dept_id, schedule_id) 
VALUES ('44689', 'Carson', 'Ferrara', '6789968795', 'cferrara@plumbersunite.com', '201', '701');

INSERT INTO employee (employee_id, employee_fname, employee_lname, employee_phone, employee_email, dept_id, schedule_id) 
VALUES ('44960', 'Cathy', 'Brunsdon', '6758555789', 'cbrunsdon@plumbersnite.com', '401', '704');

INSERT INTO employee (employee_id, employee_fname, employee_lname, employee_phone, employee_email, dept_id, schedule_id) 
VALUES ('44961', 'Tony', 'Troke', '6789995862', 'ttroke@plumbersunite.com', '301', '701');

INSERT INTO employee (employee_id, employee_fname, employee_lname, employee_phone, employee_email, dept_id, schedule_id) 
VALUES ('44963', 'Jackson', 'Henrichs', '7065695119', 'jhenrichs@plumbersunite.com', '201', '702');

INSERT INTO employee (employee_id, employee_fname, employee_lname, employee_phone, employee_email, dept_id, schedule_id) 
VALUES ('44985', 'Darrius', 'McMillan', '7062364419', 'dmcmillan@plumbersunite.com', '301', '702');

INSERT INTO employee (employee_id, employee_fname, employee_lname, employee_phone, employee_email, dept_id, schedule_id) 
VALUES ('44526', 'Evelyn', 'Terbrugge', '6784531221', 'eterbrugge@plumbersunite.com', '201', '703');

INSERT INTO employee (employee_id, employee_fname, employee_lname, employee_phone, employee_email, dept_id, schedule_id) 
VALUES ('45891', 'Naomi', 'Cadwallder', '7067251136', 'ncadwallder@plumberunite.com', '201', '704');

INSERT INTO employee (employee_id, employee_fname, employee_lname, employee_phone, employee_email, dept_id, schedule_id) 
VALUES ('45984', 'Benji', 'Gogerty', '7063369987', 'bgogerty@plumbersunite.com', '201', '705');



INSERT INTO department (dept_id, dept_name) 
VALUES ('201', 'Technician');

INSERT INTO department (dept_id, dept_name) 
VALUES ('301', 'Administration');

INSERT INTO department (dept_id, dept_name) 
VALUES ('401', 'Human Resources');



INSERT INTO customers (customer_id, customer_fname, customer_lname, customer_phone, customer_email, address_id) 
VALUES ('98871', 'Hank', 'Smith', '6789322451', 'hanksmith2@gmail.com', '801');

INSERT INTO customers (customer_id, customer_fname, customer_lname, customer_phone, customer_email, address_id)
VALUES ('98872', 'Alicia', 'Harris', '6785602775', 'aliciaharris876@gmai.com', '803');

INSERT INTO customers (customer_id, customer_fname, customer_lname, customer_phone, customer_email, address_id) 
VALUES ('98873', 'Trent', 'Jones', '6786518874', 'trentjones42@yahoo.com', '804');

INSERT INTO customers (customer_id, customer_fname, customer_lname, customer_phone, customer_email, address_id) 
VALUES ('98874', 'George', 'Shoults', '7067627821', 'gshoults1967@aol.com', '802');

INSERT INTO customers (customer_id, customer_fname, customer_lname, customer_phone, customer_email, address_id) 
VALUES ('98875', 'Jasmine', 'Taylor', '7066963032', 'jasminetaylor001@yahoo.com', '805');



INSERT INTO appointment (appt_id, employee_id, customer_id, service_id, appt_date, appt_time) 
VALUES ('111', '44963', '98873', '52B', '2023-02-10', '101');

INSERT INTO appointment (appt_id, employee_id, customer_id, service_id, appt_date, appt_time) 
VALUES ('112', '45984', '98872', '73C', '2023-03-01', '102');

INSERT INTO appointment (appt_id, employee_id, customer_id, service_id, appt_date, appt_time) 
VALUES ('113', '44689', '98871', '52B', '2023-02-24', '101');

INSERT INTO appointment (appt_id, employee_id, customer_id, service_id, appt_date, appt_time) 
VALUES ('114', '45891', '98875', '52B', '2023-02-21', '103');

INSERT INTO appointment (appt_id, employee_id, customer_id, service_id, appt_date, appt_time) 
VALUES ('115', '44523', '98874', '73C', '2023-02-21', '104');




INSERT INTO services (service_id, service_name) 
VALUES ('52B', 'Diagnostics');

INSERT INTO services (service_id, service_name) 
VALUES ('73A', 'Re-Piping');



INSERT INTO shift (shift_id, start_time, end_time) 
VALUES ('101', '8:00', '10:00');

INSERT INTO shift (shift_id, start_time, end_time) 
VALUES ('102', '10:00', '13:00');

INSERT INTO shift (shift_id, start_time, end_time) 
VALUES ('103', '13:00', '16:00');

INSERT INTO shift (shift_id, start_time, end_time) 
VALUES ('104', '16:00', '20:00');

INSERT INTO shift (shift_id, start_time, end_time) 
VALUES ('105', '8:00', '16:00');

INSERT INTO shift (shift_id, start_time, end_time) 
VALUES ('106', '11:00', '16:00');

INSERT INTO shift (shift_id, start_time, end_time) 
VALUES ('201', '8:00', '17:00');

INSERT INTO shift (shift_id, start_time, end_time) 
VALUES ('202', '11:00', '20:00');



INSERT INTO schedule (schedule_id, day_of_week, shift_id) 
VALUES ('701', 'MTWThF', '201');

INSERT INTO schedule (schedule_id, day_of_week, shift_id) 
VALUES ('702', 'MTWThF', '202');

INSERT INTO schedule (schedule_id, day_of_week, shift_id) 
VALUES ('703', 'TWThFS', '201');

INSERT INTO schedule (schedule_id, day_of_week, shift_id) 
VALUES ('704', 'TWThFS', '202');

INSERT INTO schedule (schedule_id, day_of_week, shift_id) 
VALUES ('705', 'MWThFS', '201');

INSERT INTO schedule (schedule_id, day_of_week, shift_id) 
VALUES ('706', 'MWThFS', '202');

INSERT INTO schedule (schedule_id, day_of_week, shift_id) 
VALUES ('707', 'MTThFS', '201');

INSERT INTO schedule (schedule_id, day_of_week, shift_id) 
VALUES ('708', 'MTThFS', '202');



INSERT INTO users (user_id, username, user_pass) 
VALUES ('44960', 'cbrunsdon', 'abc123');

INSERT INTO users (user_id, username, user_pass) 
VALUES ('44985', 'dmcmillan', 'xyz456');

INSERT INTO users (user_id, username, user_pass) 
VALUES ('98871', 'hsmith', '12345');

INSERT INTO users (user_id, username, user_pass) 
VALUES ('98875', 'jtaylor', '67890');




INSERT INTO address (add_id, address1, address2, add_city, add_state, add_zip) 
VALUES ('801', '1176 Roswell Rd', '', 'Marietta', 'GA', '30062');

INSERT INTO address (add_id, address1, address2, add_city, add_state, add_zip) 
VALUES ('802', '5350 Cherokee St', '', 'Acworth', 'GA', '30101');

INSERT INTO address (add_id, address1, address2, add_city, add_state, add_zip) 
VALUES ('803', '2719 E College Ave', '', 'Decatur', 'GA', '30030');

INSERT INTO address (add_id, address1, address2, add_city, add_state, add_zip) 
VALUES ('804', '3335 S Cobb Dr SE', '', 'Smyrna', 'GA', '30080');

INSERT INTO address (add_id, address1, address2, add_city, add_state, add_zip) 
VALUES ('805', '1849 Marietta Hwy', '', 'Canton', 'GA', '30114');

INSERT INTO address (add_id, address1, address2, add_city, add_state, add_zip) 
VALUES ('806', '306 Northside Pkwy', '', 'Canton', 'GA', '30114');



