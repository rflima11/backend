CREATE TABLE PRODUCT_GROUP (
    ID  SERIAL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    CONSTRAINT UQ_GROUP_NAME UNIQUE (NAME)
);