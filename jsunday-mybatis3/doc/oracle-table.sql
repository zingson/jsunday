/**
Oracle Mybatis SQL
 */

-- auto-generated definition
create table ZT_BLOG
(
  ID NUMBER,
  TITLE CHAR(100) default NULL,
  USER_NAME CHAR(50),
  CONTENT VARCHAR2(500) default NULL
)
/

create unique index Z_TEST_ID_PK
  on ZT_BLOG (ID)
/

comment on table ZT_BLOG is '测试程序表'
/


