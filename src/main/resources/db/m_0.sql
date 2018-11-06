CREATE TABLE tb_user(
    id BIGSERIAL  NOT NULL,
    name TEXT,
    email TEXT,
    salt TEXT,
    password TEXT,
    CONSTRAINT pk_tb_user_id PRIMARY KEY (id)
);
CREATE UNIQUE INDEX tb_user_email_key ON tb_user (email);