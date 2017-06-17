THH Project 
========================

Java API 开发框架，实现多数据源切换，Mapper代码生成。

## 使用框架组件
- Spring4/SpringMvc
- Mybatis3
- Druid 
- Log4j2 
- Jackson


## 项目模块说明

- ul-commons    项目工具类模块
- ul-framework  项目框架模块
- ul-mapper     数据库操作映射模型
- ul-service    业务模块
- ul-rpcapi     对外接口控制
- ul-deploy     发布部署

## Java代码包定义

包路径强制要求规则定义， `*` 为通配符，对应模块名。 

- 框架包路径 `com.ul.core.*.*`
- 实体类对象路径 `com.ul.biz.*.model`
- Mapper接口包路径 `com.ul.biz.*.mapper` 
- Mapper对应xlm包路径 `mapper.* `  ，resources 资源目录线下
- 业务层包路径 `com.ul.biz.*.service`
- 控制器层包路径 `com.ul.biz.*.controller`



