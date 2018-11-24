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