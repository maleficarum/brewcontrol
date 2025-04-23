CREATE TABLE BATCH (
    id integer NOT NULL DEFAULT nextval('batch_seq') PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    style VARCHAR(50) NOT NULL,
    size_liters DECIMAL(6, 2) NOT NULL,
    original_gravity DECIMAL(4, 3),
    final_gravity DECIMAL(4, 3),
    abv DECIMAL(3, 1),
    brew_date DATE NOT NULL,
    fermentation_start_date DATE,
    bottling_date DATE,
    yeast_strain VARCHAR(50),
    fermentation_temperature_c DECIMAL(4, 1),
    notes TEXT,
    status INT CHECK (status IN (0,1,2,3,4,5)),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create a trigger to update the updated_at timestamp automatically
CREATE OR REPLACE FUNCTION update_batch_date()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_batch_date_trigger
BEFORE UPDATE ON BATCH
FOR EACH ROW
EXECUTE FUNCTION update_batch_date();

CREATE SEQUENCE batch_seq START 1;