-- 后台管理员表  --  (郭权慧)

CREATE TABLE admin (
id  int(11) NOT NULL auto_increment,			--  主键
email  varchar(255) NOT NULL , 	-- 邮箱
pwd  varchar(255) NOT NULL , 	--  密码
image  varchar(255) NOT NULL ,	 -- 一寸照片 
PRIMARY KEY (id)
);











