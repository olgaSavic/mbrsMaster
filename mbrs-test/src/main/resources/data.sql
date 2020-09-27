insert into mbrs.item(id, description, name)
	values (1, "Report Description", "First report");
insert into mbrs.item(id, description, name)
	values (2, "Second Report Description", "Second report");

insert into mbrs.symptom(id, description, name)
	values (1, "Very dangerous symptom", "Flu");
insert into mbrs.symptom(id, description, name)
	values (2, "Light symptom", "Headache");

insert into mbrs.therapy(id, description)
	values (1, "Every 6 hours");
insert into mbrs.therapy(id, description)
	values (2, "Once a day");

insert into mbrs.doctor(id, jmbg, name, phone_number, specialty, surname)
  values (1, "800067", "Peter", "063-8643", "Surgeon", "Atkinson");
insert into mbrs.doctor(id, jmbg, name, phone_number, specialty, surname)
  values (2, "805017", "Charlotte", "064-9275", "Pediatrician", "Montgomery");

insert into mbrs.patient(id, address, jmbg, name, phone_number, surname, doctor_id)
  values (1, "5th Avenue", "802014", "Ed", "066-124", "Burnley", 1);
insert into mbrs.patient(id, address, jmbg, name, phone_number, surname, doctor_id)
  values (2, "7th Boulevard", "807023", "Chuck", "065-123", "De Niro", 2);

insert into mbrs.diagnosis(id, description, name, doctor_id, patient_id)
	values (1, "Description", "Flu", 1, 1);
insert into mbrs.diagnosis(id, description, name, doctor_id, patient_id)
	values (2, "Second Description", "Headache", 2, 2);

insert into mbrs.examination(id, date, doctor_id, patient_id)
	values (1, "2020-05-05", 1, 1);
insert into mbrs.examination(id, date, doctor_id, patient_id)
	values (2, "2020-06-06", 2, 2);

insert into mbrs.report(id, examination_id)
    values (1, 1);
insert into mbrs.report(id, examination_id)
    values (2, 2);

