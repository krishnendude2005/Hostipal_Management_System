INSERT INTO patient (first_name, last_name, gender, birth_date, email, blood_group)
VALUES
('Krishnendu', 'De', 'Male', '2003-07-15', 'krishnendu.de@gmail.com', 'AB_POSITIVE'),
('Ananya', 'Sen', 'Female', '2002-11-20', 'ananya.sen@gmail.com', 'A_POSITIVE'),
('Rahul', 'Das', 'Male', '1999-03-05', 'rahul.das@gmail.com', 'B_POSITIVE'),
('Priya', 'Sharma', 'Female', '2001-01-12', 'priya.sharma@gmail.com', 'AB_POSITIVE'),
('Sourav', 'Mondal', 'Male', '2000-09-28', 'sourav.mondal@gmail.com', 'O_NEGATIVE');

INSERT INTO doctor (name, specialization, email) VALUES
('Dr. Amit Sharma', 'Cardiology', 'amit.sharma@hospital.com'),
('Dr. Neha Verma', 'Neurology', 'neha.verma@hospital.com'),
('Dr. Rajesh Kumar', 'Orthopedics', 'rajesh.kumar@hospital.com'),
('Dr. Priya Singh', 'Pediatrics', 'priya.singh@hospital.com'),
('Dr. Anil Mehta', 'General Medicine', 'anil.mehta@hospital.com');

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES
('2026-01-30 10:30:00', 'General health checkup', 1, 1),

('2026-01-30 11:15:00', 'Chest pain consultation', 1, 2),

('2026-01-31 09:00:00', 'Follow-up after surgery', 2, 1),

('2026-01-31 14:45:00', 'Neurology consultation', 2, 2);
