CREATE TABLE public.BANK (
       ID SERIAL PRIMARY KEY,
       COMPE bpchar(3) NOT NULL UNIQUE,
       ISBP bpchar(8) NOT NULL,
       CNPJ bpchar(18) NOT NULL,
       COMPANY_NAME varchar(255) NOT NULL,
       TRADE_NAME varchar(150) NOT NULL,
       POPULAR_NAME varchar(100) NULL,
       NETWORK varchar(50) NULL,
       TYPE varchar(30) NULL,
       PIX_TYPE varchar(10) NULL,
       URL varchar(255) NULL,
       START_DATE_OPERATION date NULL,
       START_DATE_PIX date NULL
);