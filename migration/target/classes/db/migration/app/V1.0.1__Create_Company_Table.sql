CREATE TABLE COMPANY (
    ID SERIAL PRIMARY KEY,
    COMPANY_NAME VARCHAR(100) NOT NULL,
    TRADE_NAME VARCHAR(100) NOT NULL,
    CNPJ VARCHAR(14) NOT NULL,
    CITY_ID INT NOT NULL,
    ZIP_CODE VARCHAR(8) NULL,
    ADDRESS VARCHAR(100) NOT NULL,
    ADDRESS_NUMBER VARCHAR(50) NOT NULL,
    DISTRICT VARCHAR(100) NOT NULL,
    COMPLEMENT VARCHAR(200) NULL,
    PHONE_NUMBER VARCHAR(15) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    STATE_REGISTER VARCHAR(9) NOT NULL,
    MUNICIPAL_REGISTER VARCHAR(11) NOT NULL,
    CONSTRAINT FK_FILIAL_CITY FOREIGN KEY(CITY_ID) REFERENCES public.CITY(ID),
    CONSTRAINT UNIQUE_CNPJ UNIQUE (CNPJ)

);