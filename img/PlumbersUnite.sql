/*Database for Advanced Systems Project CIST 2931
Author: Milo Parr*/

CREATE TABLE `address` (
    `add_id` char(10)  NOT NULL ,
    `add_1` varchar(100)  NOT NULL ,
    `add_2` varchar(100)  NULL ,
    `add_city` varchar(20)  NOT NULL ,
    `add_state` varchar(20)  NOT NULL ,
    `add_zip` varchar(15)  NOT NULL ,
    PRIMARY KEY (
        `add_id`
    )
);

CREATE TABLE `appointment` (
    `appt_id` char(10)  NOT NULL ,
    `emp_username` varchar(50)  NOT NULL ,
    `cust_username` varchar(50)  NOT NULL ,
    `service_name` varchar(50)  NOT NULL ,
    `appt_date` varchar(20)  NOT NULL ,
    `appt_start` varchar(10)  NOT NULL ,
    `appt_end` varchar(10)  NOT NULL ,
    PRIMARY KEY (
        `appt_id`
    )
);

CREATE TABLE `customers` (
    `cust_username` varchar(50)  NOT NULL ,
    `cust_pwd` varchar(50)  NOT NULL ,
    `cust_fname` varchar(20)  NOT NULL ,
    `cust_lname` varchar(20)  NOT NULL ,
    `cust_phone` varchar(20)  NOT NULL ,
    `cust_email` varchar(50)  NOT NULL ,
    `add_id` char(10)  NOT NULL ,
    PRIMARY KEY (
        `cust_username`
    )
);

CREATE TABLE `employees` (
    `emp_username` varchar(50)  NOT NULL ,
    `emp_pwd` varchar(50)  NOT NULL ,
    `emp_fname` varchar(20)  NOT NULL ,
    `emp_lname` varchar(20)  NOT NULL ,
    `emp_phone` varchar(20)  NOT NULL ,
    `emp_email` varchar(50)  NOT NULL ,
    `dept_name` varchar(20)  NOT NULL ,
    `schedule_id` char(10)  NOT NULL ,
    PRIMARY KEY (
        `emp_username`
    )
);

CREATE TABLE `schedule` (
    `schedule_id` char(10)  NOT NULL ,
    `days_of_week` varchar(10)  NOT NULL ,
    `shift_start` varchar(20)  NOT NULL ,
    `shift_end` varchar(20)  NOT NULL ,
    PRIMARY KEY (
        `schedule_id`
    )
);


INSERT INTO address (add_id, add_1, add_2, add_city, add_state, add_zip) 
VALUES ('801', '1176 Roswell Rd', 'null', 'Marietta', 'GA', '30062');

INSERT INTO address (add_id, add_1, add_2, add_city, add_state, add_zip) 
VALUES ('802', '5350 Cherokee St', 'null', 'Acworth', 'GA', '30101');

INSERT INTO address (add_id, add_1, add_2, add_city, add_state, add_zip) 
VALUES ('803', '2719 E College Ave', 'Apt 27', 'Decatur', 'GA', '30030');

INSERT INTO address (add_id, add_1, add_2, add_city, add_state, add_zip) 
VALUES ('804', '3335 S Cobb Dr SE', 'null', 'Smyrna', 'GA', '30080');

INSERT INTO address (add_id, add_1, add_2, add_city, add_state, add_zip) 
VALUES ('805', '1849 Marietta Hwy', 'null', 'Canton', 'GA', '30114');

INSERT INTO address (add_id, add_1, add_2, add_city, add_state, add_zip) 
VALUES ('806', '306 Northside Pkwy', 'null', 'Canton', 'GA', '30114');


INSERT INTO appointment (appt_id, emp_username, cust_username, service_name, appt_date, appt_start, appt_end) 
VALUES ('111', 'jhenrichs', 'tjones', 'Diagnostics', '4/10/2023', '10:30AM', '11:30AM');

INSERT INTO appointment (appt_id, emp_username, cust_username, service_name, appt_date, appt_start, appt_end) 
VALUES ('112', 'bgogerty', 'aharris', 'Re-Piping', '5/1/2023', '8:00AM', '5:00PM');

INSERT INTO appointment (appt_id, emp_username, cust_username, service_name, appt_date, appt_start, appt_end) 
VALUES ('113', 'cferrara', 'hsmith', 'Diagnostics', '4/24/2023', '3:30PM', '4:30PM');

INSERT INTO appointment (appt_id, emp_username, cust_username, service_name, appt_date, appt_start, appt_end) 
VALUES ('114', 'ncadwall', 'jtaylor', 'Leak Repair', '4/21/2023', '8:00AM', '10:00AM');

INSERT INTO appointment (appt_id, emp_username, cust_username, service_name, appt_date, appt_start, appt_end) 
VALUES ('115', 'eterbrug', 'gshoults', 'Re-Piping', '4/21/2023', '8:00AM', '5:00PM');


INSERT INTO customers (cust_username, cust_pwd, cust_fname, cust_lname, cust_phone, cust_email, add_id) 
VALUES ('hsmith', '12345', 'Hank', 'Smith', '6789322451', 'hanksmith2@gmail.com', '801');

INSERT INTO customers (cust_username, cust_pwd, cust_fname, cust_lname, cust_phone, cust_email, add_id) 
VALUES ('gshoults', 'abc123', 'George', 'Shoults', '7067627821', 'gshoults1967@aol.com', '802');

INSERT INTO customers (cust_username, cust_pwd, cust_fname, cust_lname, cust_phone, cust_email, add_id) 
VALUES ('aharris', 'abcde', 'Alicia', 'Harris', '6785602775', 'aliciaharris876@gmai.com', '803');

INSERT INTO customers (cust_username, cust_pwd, cust_fname, cust_lname, cust_phone, cust_email, add_id) 
VALUES ('tjones', '67890', 'Trent', 'Jones', '6786518874', 'trentjones42@yahoo.com', '804');

INSERT INTO customers (cust_username, cust_pwd, cust_fname, cust_lname, cust_phone, cust_email, add_id) 
VALUES ('jtaylor', '123abc', 'Jasmine', 'Taylor', '7066963032', 'jasminetaylor001@yahoo.com', '805');


INSERT INTO employees (emp_username, emp_pwd, emp_fname, emp_lname, emp_phone, emp_email, dept_name, schedule_id) 
VALUES ('eterbrug', '12345', 'Evelyn', 'Terbrugge', '6784531221', 'eterbrugge@plumbersunite.com', 'Technician', '703');

INSERT INTO employees (emp_username, emp_pwd, emp_fname, emp_lname, emp_phone, emp_email, dept_name, schedule_id) 
VALUES ('cferrara', '67890', 'Carson', 'Ferrara', '6789968795', 'cferrara@plumbersunite.com', 'Technician', '701');

INSERT INTO employees (emp_username, emp_pwd, emp_fname, emp_lname, emp_phone, emp_email, dept_name, schedule_id) 
VALUES ('cbrunsdon', 'abcde', 'Cathy', 'Brunsdon', '6758555789', 'cbrunsdon@plumbersnite.com', 'Human Resources', '704');

INSERT INTO employees (emp_username, emp_pwd, emp_fname, emp_lname, emp_phone, emp_email, dept_name, schedule_id) 
VALUES ('ttroke', 'abc123', 'Tony', 'Troke', '6789995862', 'ttroke@plumbersunite.com', 'Admin', '701');

INSERT INTO employees (emp_username, emp_pwd, emp_fname, emp_lname, emp_phone, emp_email, dept_name, schedule_id) 
VALUES ('jhenrichs', 'def456', 'Jackson', 'Henrichs', '7065695119', 'jhenrichs@plumbersunite.com', 'Technician', '702');

INSERT INTO employees (emp_username, emp_pwd, emp_fname, emp_lname, emp_phone, emp_email, dept_name, schedule_id) 
VALUES ('dmcmillan', '01234', 'Darrius', 'McMillan', '7062364419', 'dmcmillan@plumbersunite.com', 'Admin', '702');

INSERT INTO employees (emp_username, emp_pwd, emp_fname, emp_lname, emp_phone, emp_email, dept_name, schedule_id) 
VALUES ('ncadwall', 'abc101', 'Naomi', 'Cadwallder', '7067251136', 'ncadwallder@plumberunite.com', 'Technician', '704');

INSERT INTO employees (emp_username, emp_pwd, emp_fname, emp_lname, emp_phone, emp_email, dept_name, schedule_id) 
VALUES ('bgogerty', 'abc404', 'Benji', 'Gogerty', '7063369987', 'bgogerty@plumbersunite.com', 'Technician', '705');


INSERT INTO schedule (schedule_id, days_of_week, shift_start, shift_end) 
VALUES ('701', 'MTWThF', '8:00AM', '5:00PM');

INSERT INTO schedule (schedule_id, days_of_week, shift_start, shift_end) 
VALUES ('702', 'MTWThF', '11:00AM', '8:00PM');

INSERT INTO schedule (schedule_id, days_of_week, shift_start, shift_end) 
VALUES ('703', 'TWThFS', '8:00AM', '5:00PM');

INSERT INTO schedule (schedule_id, days_of_week, shift_start, shift_end) 
VALUES ('704', 'TWThFS', '11:00AM', '8:00PM');

INSERT INTO schedule (schedule_id, days_of_week, shift_start, shift_end) 
VALUES ('705', 'MWThFS', '8:00AM', '5:00PM');

INSERT INTO schedule (schedule_id, days_of_week, shift_start, shift_end) 
VALUES ('706', 'MWThFS', '11:00AM', '8:00PM');

INSERT INTO schedule (schedule_id, days_of_week, shift_start, shift_end) 
VALUES ('707', 'MTThFS', '8:00AM', '5:00PM');

INSERT INTO schedule (schedule_id, days_of_week, shift_start, shift_end) 
VALUES ('708', 'MTThFS', '11:00AM', '8:00PM');



