CREATE TABLE book (
    BNUM NUMBER(38) PRIMARY KEY,
    TITLE VARCHAR2(50) NOT NULL,
    AUTHOR VARCHAR2(50) NOT NULL,
    PUBLISHER VARCHAR2(50) NOT NULL,
    PRICE NUMBER(38) DEFAULT 0,
    INPUTDATE DATE DEFAULT SYSDATE
);

CREATE SEQUENCE bookseq;
