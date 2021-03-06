DROP DATABASE IF EXISTS BANK;
CREATE DATABASE BANK DEFAULT CHARSET UTF8;
USE BANK;
CREATE TABLE USER
(
    ID           INT UNSIGNED PRIMARY KEY,
    PASSWORD     VARCHAR(20) NOT NULL,
    NAME         VARCHAR(20),
    PHONE_NUMBER VARCHAR(20),
    ADDRESS      VARCHAR(100)
) ENGINE = INNODB;
CREATE TABLE BIll
(
    SENDER INT UNSIGNED,
    PAYEE  INT UNSIGNED,
    VALUE  DOUBLE,
    type   VARCHAR(20),
    PRIMARY KEY (VALUE, type),
    FOREIGN KEY (SENDER) REFERENCES USER (ID),
    FOREIGN KEY (PAYEE) REFERENCES USER (ID)
);
CREATE TABLE BANKCARD
(
    BANKCARDNUMBER    INT UNSIGNED PRIMARY KEY,
    PASSWORD          VARCHAR(25) NOT NULL,
    REMAINING_BALANCE DOUBLE DEFAULT 0.00,
    BANK_NAME         VARCHAR(20)
) ENGINE = INNODB;
CREATE TABLE USER_BANKCARD
(
    USERID         INT UNSIGNED,
    BANKCARDNUMBER INT UNSIGNED,
    PRIMARY KEY (USERID, BANKCARDNUMBER),
    FOREIGN KEY (USERID) REFERENCES USER (ID)
) ENGINE = INNODB;
CREATE TABLE LOAN
(
    ID           INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    INTERESTRATE DOUBLE      NOT NULL,
    NAME         VARCHAR(20) NOT NULL,
    DETIAL       VARCHAR(100)
) ENGINE = INNODB;
