DROP DATABASE IF EXISTS `multi_datasource`;
CREATE DATABASE multi_datasource CHARACTER SET utf8;
CREATE USER multi IDENTIFIED BY 'multi';
GRANT ALL PRIVILEGES ON multi_datasource.* TO 'multi'@'localhost' IDENTIFIED BY 'multi' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON multi_datasource.* TO 'multi'@'%' IDENTIFIED BY 'multi' WITH GRANT OPTION;
FLUSH PRIVILEGES;
