insert into mbrs.diagnosis(id, description, name)
	values (1, "Description", "Flu");
insert into mbrs.diagnosis(id, description, name)
	values (2, "Second Description", "Headache");

insert into mbrs.doctor(id, jmbg, name, phone_number, specialty, surname)
  values (1, 800067, "Peter", "063-8643", "Surgeon", "Atkinson");
insert into mbrs.doctor(id, jmbg, name, phone_number, specialty, surname)
  values (2, 805017, "Charlotte", "064-9275", "Pediatrician", "Montgomery");

insert into mbrs.examination(id, date)
	values (1, "2020-05-05");
insert into mbrs.examination(id, date)
	values (2, "2020-06-06");

insert into mbrs.pacient(id, address, jmbg, name, phone_number, surname)
  values (1, "5th Avenue", 802014, "Ed", "066-124", "Burnley");
insert into mbrs.pacient(id, address, jmbg, name, phone_number, surname)
  values (2, "7th Boulevard", 807023, "Chuck", "065-123", "De Niro");

insert into mbrs.report(id)
    values (1);
insert into mbrs.report(id)
    values (2);

insert into mbrs.report_item(id, descriptioin, name)
	values (1, "Report Description", "First report");
insert into mbrs.report_item(id, descriptioin, name)
	values (2, "Second Report Description", "Second report");

insert into mbrs.symptom(id, description, name)
	values (1, "Very dangerous symtom", "Flu");
insert into mbrs.symptom(id, description, name)
	values (2, "Light symtom", "Headache");

insert into mbrs.therapy(id, description)
	values (1, "Every 6 hours");
insert into mbrs.therapy(id, description)
	values (2, "Once a day");