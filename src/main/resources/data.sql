INSERT INTO user (name, email, password) VALUES
                                             ('John Doe', 'john.doe@example.com', 'password1'),
                                             ('Jane Smith', 'jane.smith@example.com', 'password2');

INSERT INTO payment_method (name) VALUES
                                      ('Credit card'),
                                      ('Debit card'),
                                      ('Cash');


INSERT INTO income (user_id, amount, source, date) VALUES
                                                       (1, 2000, 'Monthly salary', '2022-03-01'),
                                                       (1, 500, 'Freelance project', '2022-03-05'),
                                                       (2, 1500, 'Part-time job', '2022-03-02');

INSERT INTO expense (user_id, amount, date, payment_method_id) VALUES
                                                                   (1, 200, '2022-03-01', 2),
                                                                   (1, 800, '2022-03-01', 1),
                                                                   (1, 100, '2022-03-02', 1),
                                                                   (1, 50, '2022-03-03', 3),
                                                                   (2, 300, '2022-03-02', 2),
                                                                   (2, 100, '2022-03-04', 1);