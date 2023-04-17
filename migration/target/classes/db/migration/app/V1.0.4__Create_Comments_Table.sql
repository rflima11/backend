CREATE TABLE PRODUCT_COMMENTS (
    ID  SERIAL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    ENABLE BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT UQ_PRODUCT_COMMENTS_NAME UNIQUE (NAME)
);
