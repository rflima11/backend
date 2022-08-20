CREATE TABLE PERSON (
      ID  SERIAL PRIMARY KEY,
      NAME bpchar(100) NOT NULL,
      PHONE_NUMBER bpchar(15) NOT NULL,
      CPF bpchar(11) NULL,
      CNPJ bpchar(14) NULL,
      CITY_ID INT NOT NULL,
      ADDRESS bpchar(100) NOT NULL,
      ADDRESS_NUMBER bpchar(50) NOT NULL,
      DISTRICT bpchar(100) NOT NULL,
      COMPLEMENT bpchar(200) NULL,
      CONSTRAINT FK_CUSTOMER_CITY FOREIGN KEY(CITY_ID) REFERENCES public.CITY(ID)
);