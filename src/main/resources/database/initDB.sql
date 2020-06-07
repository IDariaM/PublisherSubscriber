CREATE TABLE IF NOT EXISTS purchase
(
    id    INTEGER  PRIMARY KEY ,
    msisdn  VARCHAR(10) NOT NULL ,
    timestamp VARCHAR(2000)  NOT NULL
);

CREATE TABLE IF NOT EXISTS subscription
(
    id    INTEGER  PRIMARY KEY ,
    msisdn  VARCHAR(10) NOT NULL ,
    timestamp VARCHAR(2000)  NOT NULL
);
