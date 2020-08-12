DROP TABLE IF EXISTS events;

CREATE TABLE events (
  eventId INT AUTO_INCREMENT  PRIMARY KEY,
  eventName VARCHAR(250) NOT NULL,
  evetLocation VARCHAR(250) NOT NULL,
  eventDescription VARCHAR(250) NOT NULL,
  eventStartDate DATE,
  eventEndDate DATE,
  eventLink VARCHAR(250) not null
);

INSERT INTO events (eventName,evetLocation, eventDescription,eventStartDate, eventEndDate,eventLink ) VALUES
  ('Spring Boot project managemamt','ADANA', 'Spring Boot framework building', DATE '2020-11-14',DATE '2021-11-14', 'www.zoom.com/AXGDXG'),
  ('Oracle database using', 'LONDON','Oracle database building', DATE '2020-11-14',DATE '2021-11-14', 'www.zoom.com/sfafadfdfafa'),
  ('ELK Kibana', 'GERMANY','ELK Kibana using with Spring boot', DATE '2020-11-14',DATE '2021-11-14', 'www.zoom.com/ZXCVFD');




