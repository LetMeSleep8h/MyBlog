-- MySQL 容器第一次启动时自动执行(初始化数据库)
-- 只会在数据卷为空时执行一次;之后想改表结构请手动执行 ALTER
USE blog;

CREATE TABLE IF NOT EXISTS article (
    id           INT          NOT NULL AUTO_INCREMENT,
    title        VARCHAR(200) NOT NULL,
    content      TEXT         NOT NULL,
    article_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_delete    TINYINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
