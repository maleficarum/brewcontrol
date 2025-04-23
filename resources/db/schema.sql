CREATE TABLE BATCH (
    id SERIAL PRIMARY KEY,
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
    status VARCHAR(20) CHECK (status IN ('planned', 'brewing', 'fermenting', 'conditioning', 'bottled', 'completed')),
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