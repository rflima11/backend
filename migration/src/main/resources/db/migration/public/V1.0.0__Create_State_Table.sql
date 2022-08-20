CREATE TABLE public.STATE (
       ID  SERIAL PRIMARY KEY,
       NAME varchar(50) NULL,
       CODE int4 NOT NULL,
       INITIALS bpchar(2) NULL,
       GENTILIC varchar(80) NULL,
       GOVERNOR varchar(50) NULL,
       CAPITAL varchar(50) NULL,
       TERRITORIAL_AREA numeric(20, 3) NULL,
       ESTIMATED_POPULATION int4 NULL,
       DEMOGRAPHIC_DENSITY numeric(20, 3) NULL,
       ENROLLMENT_ELEMENTARY_SCHOOL int4 NULL,
       IDH numeric(10, 3) NULL,
       REVENEU_MADE numeric(20, 3) NULL,
       EXPENSES_EMPLOYED numeric(20, 3) NULL,
       PER_CAPITA_INCOME numeric(10, 2) NULL,
       VEHICLE_NUMBER int4 NULL
);

