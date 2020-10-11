spring.cloud.config.label 指明远程仓库的分支

spring.cloud.config.profile

dev开发环境配置文件
test测试环境
pro正式环境
spring.cloud.config.uri= http://localhost:8888/ 指明配置服务中心的网址


打开网址访问：http://localhost:8881/hi，网页显示：

foo version 3

这就说明，config-client从config-server获取了foo的属性，而config-server是从git仓库读取的.

流程：config-client ---> config-server ---> git
在需要使用配置中心的地方，按照这个写法即可拿到远程配置的数据，嵌入打工程项目中



上面只能完成基础的一次性获取配置信息，但是配置变更的时候并不能及时更新项目中的配置。


> 方案1：借助于actuator的refresh实现

步骤1，引入依赖

```xml
 <!-- 提供监控功能 此处引入是需要refresh 的功能 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```

步骤2：配置management.endpoints.web.exposure.include=*

步骤3：在类上添加@RefreshScope注解

步骤4：post  http://localhost:8881/actuator/refresh


存在的问题：需要手动更新每一个client，繁琐

> 方案2：借助springcloud bus+mq(kafka\rabbitmq)

https://blog.csdn.net/wtdm_160604/article/details/83720391