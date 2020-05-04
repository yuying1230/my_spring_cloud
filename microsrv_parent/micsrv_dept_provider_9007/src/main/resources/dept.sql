DROP DATABASE IF EXISTS sc_db03;

CREATE DATABASE sc_db03 CHARACTER SET UTF8;

USE sc_db03;

CREATE TABLE dept
(
	deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
	db_source VARCHAR(60)
);

-- DATABASE() mysql自带函数 表示当前所在库的库名
INSERT INTO dept(dname, db_source) VALUES('开发部', DATABASE());
INSERT INTO dept(dname, db_source) VALUES('人事部', DATABASE());
INSERT INTO dept(dname, db_source) VALUES('财务部', DATABASE());
INSERT INTO dept(dname, db_source) VALUES('市场部', DATABASE());
INSERT INTO dept(dname, db_source) VALUES('运维部', DATABASE());

SELECT deptno,dname,db_source FROM dept WHERE deptno=#{deptno};