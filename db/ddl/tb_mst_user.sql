CREATE TABLE tb_mst_user (
    user_id VARCHAR(255) PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    delete_flg BOOLEAN NOT NULL DEFAULT FALSE
);