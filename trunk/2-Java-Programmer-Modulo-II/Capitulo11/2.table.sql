CREATE TABLE tab_role (
    role_code INTEGER PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(20)
);

CREATE TABLE tab_func (
    func_code     INTEGER PRIMARY KEY AUTO_INCREMENT,
    func_name     VARCHAR(30),
    func_rmnt_val DOUBLE,
    role_code     INTEGER
);

ALTER TABLE tab_func
ADD CONSTRAINT fk_role_func
    FOREIGN KEY (role_code)
        REFERENCES tab_role (role_code);

CREATE TABLE tab_foto(
    user_code      INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_name      VARCHAR(30) NOT NULL,
    user_pict      LONGBLOB,
    orig_file_name VARCHAR(50)
);

