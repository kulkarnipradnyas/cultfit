CREATE TABLE IF NOT EXISTS user_db.roles (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO user_db.roles(id,name) VALUES (1,'USER');
INSERT INTO user_db.roles(id,name) VALUES (2,'ADMIN');
INSERT INTO user_db.roles(id,name) VALUES (3,'VENDOR');
commit;