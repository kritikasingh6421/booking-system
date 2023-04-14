-- create databases
CREATE DATABASE IF NOT EXISTS `transactions`;
CREATE DATABASE IF NOT EXISTS `flight_search`;
CREATE DATABASE IF NOT EXISTS `hotel_search`;
CREATE DATABASE IF NOT EXISTS `login`;

-- create root user and grant rights
-- CREATE USER 'root'@'localhost' IDENTIFIED BY 'local';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';