CREATE TABLE IF NOT EXISTS user_db.flyway_schema_history (
  installed_rank INTEGER NOT NULL,
  version varchar(50) DEFAULT NULL,
  description varchar(200) NOT NULL,
  type varchar(20) NOT NULL,
  script varchar(1000) NOT NULL,
  checksum INTEGER DEFAULT NULL,
  installed_by varchar(100) NOT NULL,
  installed_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  execution_time INTEGER NOT NULL,
  success BOOLEAN NOT NULL,
  PRIMARY KEY (installed_rank)
);

--INSERT INTO flyway_schema_history (installed_rank, version, description,     type, script, checksum, installed_by, installed_on, execution_time, success)
--SELECT installed_rank, version, description, type, script, checksum,     installed_by, installed_on, execution_time, success
--FROM schema_version;

--ALTER TABLE schema_version RENAME TO bak_schema_version;

