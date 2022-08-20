CREATE TABLE fluyt_cloud.CUSTOMER (
     ID  SERIAL PRIMARY KEY,
     SCHEMA_NAME bpchar(63) NOT NULL,
     COMPANY_NAME bpchar(100) NOT NULL,
     TRADE_NAME bpchar(100) NOT NULL,
     CNPJ bpchar(14) NOT NULL,
     CITY_ID INT NOT NULL,
     ADDRESS bpchar(100) NOT NULL,
     ADDRESS_NUMBER bpchar(50) NOT NULL,
     DISTRICT bpchar(100) NOT NULL,
     COMPLEMENT bpchar(200) NULL,
     PHONE_NUMBER bpchar(15) NOT NULL,
     CONSTRAINT FK_CUSTOMER_CITY FOREIGN KEY(CITY_ID) REFERENCES public.CITY(ID)
);
