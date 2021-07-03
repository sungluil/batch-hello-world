CREATE TABLE CUSTOMER (
      CUSTOMER_ID VARCHAR2(45)
    , FIRST_NAME VARCHAR2(45)
    , MIDDLE_NAME VARCHAR2(45)
    , LAST_NAME VARCHAR2(45)
    , SSN VARCHAR2(45)
    , EMAIL_ADDRESS VARCHAR2(255)
    , HOME_PHONE CHAR(10)
    , CELL_PHONE CHAR(10)
    , WORK_PHONE CHAR(10)
    , NOTIFICATION_PREF CHAR(1)
)
;

CREATE TABLE ACCOUNT (
    ACCOUNT_ID INT
  , BALANCE FLOAT
  , LAST_STATEMENT_DATE TIMESTAMP
);


CREATE TABLE TRANSACTION (
    TRANSACTION_ID INT
  , ACCOUNT_ACCOUNT_ID INT
  , CREDIT FLOAT
  , DEBIT FLOAT
  , TIMESTAMP TIMESTAMP
);