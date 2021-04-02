create user phonebook with encrypted password 'phonebook';
ALTER USER phonebook WITH encrypted PASSWORD 'phonebook';
GRANT phonebook TO postgres;
grant all privileges on database phonebook to phonebook;

-- Global table field definitions that are added to most tables.
CREATE TABLE General_Tbl
(
  created		TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
  modified	TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
  enabled		BOOLEAN DEFAULT true
);
COMMENT ON TABLE General_Tbl IS 'Global table field definitions that are added to most tables.';

/* ==================== TEMPLATE SCHEMA END ==================== */
-- General trigger function for updating a table
CREATE OR REPLACE FUNCTION Public.Update_Table_Proc() RETURNS TRIGGER AS $BODY$
BEGIN
  NEW.modified := now();
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

COMMENT ON FUNCTION Public.Update_Table_Proc() IS 'General trigger function for updating a table';
GRANT EXECUTE ON FUNCTION Public.Update_Table_Proc() TO phonebook;

-- Table schema
CREATE TABLE Contact_Tbl
(
  id serial NOT NULL,
  name character varying(50),
  phone bigint,
  email character varying(100),
  LIKE General_Tbl INCLUDING DEFAULTS,
  CONSTRAINT contact_pk PRIMARY KEY (id)
);

ALTER TABLE Contact_Tbl
  OWNER TO phonebook;

CREATE TRIGGER Update_Contact
BEFORE UPDATE
ON Contact_Tbl FOR EACH ROW
EXECUTE PROCEDURE Public.Update_Table_Proc();



