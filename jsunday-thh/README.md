THH Project 
========================


## 框架
- Spring4
- Mybatis3

## 项目模块

- ul-commons    项目工具类模块
- ul-framework  项目框架模块
- ul-mapper     数据库操作映射模型
- ul-service    业务模块
- ul-rpcapi     对外接口控制
- ul-deploy     发布部署

## 项目包路径

包路径强制要求规则定义， `*`为通配符，对应功能模块名。 

- 框架包路径 `com.ul.core.*.*`
- 实体类对象路径 `com.ul.biz.*.model`
- 数据层映射接口 `com.ul.biz.*.mapper`
- 业务层包路径 `com.ul.biz.*.service`
- 控制器层包路径 `com.ul.biz.*.controller`



