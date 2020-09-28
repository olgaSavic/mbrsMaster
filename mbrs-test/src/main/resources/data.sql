insert into item(description, name) values ("Report Description", "First report");
insert into item(description, name) values ("Second Report Description", "Second report");

insert into symptom(description, name) values ("Very dangerous symptom", "Flu");
insert into symptom(description, name) values ("Light symptom", "Headache");

insert into therapy(description)
	values ("Every 6 hours");
insert into therapy(description)
	values ("Once a day");

insert into doctor(jmbg, name, phone_number, specialty, surname)
  values ("800067", "Peter", "063-8643", "Surgeon", "Atkinson");
insert into doctor(jmbg, name, phone_number, specialty, surname)
  values ("805017", "Charlotte", "064-9275", "Pediatrician", "Montgomery");

insert into patient(address, jmbg, name, phone_number, surname)
  values ("5th Avenue", "802014", "Ed", "066-124", "Burnley");
insert into patient(address, jmbg, name, phone_number, surname)
  values ("7th Boulevard", "807023", "Chuck", "065-123", "De Niro");

insert into doctor_patient (doctor_id, patient_id) values (1,1);
insert into doctor_patient (doctor_id, patient_id) values (2,2);

insert into diagnosis(description, name)
	values ("Description", "Flu");
insert into diagnosis(description, name)
	values ("Second Description", "Headache");

insert into patient_diagnosis (patient_id, diagnosis_id) values (1,1);
insert into patient_diagnosis (patient_id, diagnosis_id) values (2,2);

insert into examination(date)
	values ("2020-05-05");
insert into examination(date)
	values ("2020-06-06");

insert into patient_examination (patient_id, examination_id) values (1,1);
insert into patient_examination (patient_id, examination_id) values (2,2);

insert into report(examination_id)
    values (1);
insert into report(examination_id)
    values (2);

insert into report_item (report_id, item_id) values (1,1);
insert into report_item (report_id, item_id) values (2,2);