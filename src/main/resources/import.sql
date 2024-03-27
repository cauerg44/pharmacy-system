INSERT INTO manufactures (name, address, shipment_date) VALUES ('ABC Pharmaceuticals', '123 Main Street, Cityville, USA', 2012);
INSERT INTO manufactures (name, address, shipment_date) VALUES ('XYZ Biotech', '456 Elm Street, Townsville, USA', 2008);
INSERT INTO manufactures (name, address, shipment_date) VALUES ('PQR Health Solutions', '789 Oak Street, Villageton, USA', 2015);

INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('PainAway', 0, 10.50, 'PainAway is a fast-acting pain reliever suitable for headaches and muscle pains.', 1);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('SleepEase', 1, 15.75, 'SleepEase helps promote relaxation and improve sleep quality.', 1);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('ColdCure', 2, 20.00, 'ColdCure provides relief from common cold symptoms like congestion and sore throat.', 1);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('AllerGuard', 0, 12.25, 'AllerGuard helps alleviate allergy symptoms such as sneezing and itching.', 1);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('DigestEase', 1, 18.90, 'DigestEase aids in digestion and soothes upset stomachs.', 1);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('HeartHealth', 2, 25.50, 'HeartHealth supports cardiovascular health and maintains normal blood pressure levels.', 2);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('FocusPlus', 0, 11.00, 'FocusPlus enhances mental clarity and concentration.', 2);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('StressRelief', 1, 17.30, 'StressRelief helps reduce stress and promotes relaxation.', 2);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('BoneStrength', 2, 22.75, 'BoneStrength supports bone health and reduces the risk of osteoporosis.', 2);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('EnergyBoost', 0, 13.75, 'EnergyBoost increases energy levels and combats fatigue.', 2);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('ImmuneGuard', 1, 19.95, 'ImmuneGuard strengthens the immune system and helps fight off infections.', 3);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('VisionCare', 2, 27.50, 'VisionCare supports eye health and reduces the risk of age-related vision problems.', 3);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('JointFlex', 0, 14.80, 'JointFlex improves joint flexibility and relieves arthritis pain.', 3);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('SkinGlow', 1, 21.20, 'SkinGlow promotes healthy skin and reduces the appearance of wrinkles.', 3);
INSERT INTO remedies (name, warning_label, price, description, manufacturer_id) VALUES ('HairRevive', 2, 30.00, 'HairRevive nourishes the scalp and promotes hair growth.', 3);

INSERT INTO users (name, email, birth_date, password) VALUES ('Cauê Garcia', 'caue@gmail.com', '2004-11-08', '2024');
INSERT INTO users (name, email, birth_date, password) VALUES ('Emanuele Sacramento', 'manu@gmail.com', '1985-02-19', '2024');
INSERT INTO users (name, email, birth_date, password) VALUES ('Ana Cláudia', 'ataide@gmail.com', '2005-05-03', '2024');

INSERT INTO roles (authority) VALUES ('CLIENT');
INSERT INTO roles (authority) VALUES ('PHARMACEUTICAL');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 1);

INSERT INTO sales (moment, sale_status, user_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-01-13T19:45:00Z', 0, 1);
INSERT INTO sales (moment, sale_status, user_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-02-15T19:45:00Z', 1, 2);
INSERT INTO sales (moment, sale_status, user_id) VALUES (TIMESTAMP WITH TIME ZONE '2024-03-10T19:45:00Z', 2, 3);

INSERT INTO stock_remedy (sale_id, remedy_id, quantity, price) VALUES (1, 1, 3, 44.25);
INSERT INTO stock_remedy (sale_id, remedy_id, quantity, price) VALUES (2, 2, 1, 55.99);
INSERT INTO stock_remedy (sale_id, remedy_id, quantity, price) VALUES (3, 3, 5, 44.25);

INSERT INTO payments (sale_id, payment_moment, payment_method) VALUES (2, TIMESTAMP WITH TIME ZONE '2024-01-13T19:45:00Z', 'PIX');
INSERT INTO payments (sale_id, payment_moment, payment_method) VALUES (3, TIMESTAMP WITH TIME ZONE '2024-01-13T19:45:00Z', 'DEBIT CARD');
