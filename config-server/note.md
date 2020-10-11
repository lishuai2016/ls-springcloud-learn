spring.cloud.config.server.git.uri：配置git仓库地址
spring.cloud.config.server.git.searchPaths：配置仓库路径
spring.cloud.config.label：配置仓库的分支
spring.cloud.config.server.git.username：访问git仓库的用户名
spring.cloud.config.server.git.password：访问git仓库的用户密码
如果Git仓库为公开仓库，可以不填写用户名和密码，如果是私有仓库需要填写，本例子是公开仓库，放心使用。

远程仓库https://github.com/forezp/SpringcloudConfig/ 中有个文件config-client-dev.properties文件中有一个属性：

foo = foo version 3

启动程序：访问http://localhost:8888/foo/dev

证明配置服务中心可以从远程程序获取配置信息。

http请求地址和资源文件映射如下:

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties



{"name":"foo","profiles":["dev"],"label":"master",
"version":"792ffc77c03f4b138d28e89b576900ac5e01a44b","state":null,"propertySources":[]}


访问
http://localhost:8888/config-client/dev

```json
{
name: "config-client",
profiles: [
"dev"
],
label: null,
version: "3d769eee8c40987c44946bc33cb7e0d058001844",
state: null,
propertySources: [
{
name: "https://github.com/lishuai2016/ls-spring-cloud-config-respo/config-client-dev.properties",
source: {
foo: "foo version 111112222",
democonfigclient.message: "hello spring io",
name: "ls",
age: "18"
}
}
]
}
```
