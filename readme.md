euraka-server:8761
hello-service:8762
hello1-service:8763
consumer-hello-ribbon:8764
consumer-hello-feign：8765
zuul-server:8769
turbine-server:9999

config-server：8888
config-client：8881
config-eureka-server：8889

service-hi：8988
service-miya：8989

1、模块euraka-server
Eureka作为服务注册与发现的组件

2、hello-service
服务的提供者，把服务注册到注册中心

3、consumer-hello-ribbon服务消费者
Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign
3.1、原始版本
3.2、加入熔断路由

4、consumer-hello-feign服务消费者（觉得这种方式更加便利）
Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign
4.1、原始版本
4.2、加入熔断路由

5、zuul-server路由网关
所有的请求由该网关进行转发过滤

6、配置中心
config-server
config-client

流程：config-client ---> config-server ---> git
在需要使用配置中心的地方，按照这个写法即可拿到远程配置的数据，嵌入打工程项目中

在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。
在Spring Cloud中，有分布式配置中心组件spring cloud config ，它支持配置服务放在配置服务的内存中（即本地），
也支持放在远程Git仓库中。在spring cloud config 组件中，分两个角色，一是config server，二是config client。

config-eureka-server：为搭建高可用的配置中心 设置的eureka注册中心
这时发现，client端在读取配置文件不再写ip地址，而是服务名，这时如果配置服务部署多份，通过负载均衡，从而高可用

7、服务链路追踪

java -jar zipkin-server-2.10.1-exec.jar
端口9411
web访问：
http://localhost:9411

service-hi：8988
service-miya：8989
简单的两个web服务，没有使用注册中心，直接调用
7.1、先启动zipkin服务
7.2、然后依次启动service-hi和service-miya
7.3、然后访问http://localhost:8989/miya
7.4、访问http://localhost:9411，查看服务调用的各个节点


8、Hystrix Dashboard（相当于一个服务监控页面）
在微服务架构中为例保证程序的可用性，防止程序出错导致网络阻塞，出现了断路器模型。
断路器的状况反应了一个程序的可用性和健壮性，它是一个重要指标。
Hystrix Dashboard是作为断路器状态的一个组件，提供了数据监控和友好的图形化界面。


在请求http://localhost:8762/actuator/hystrix.stream之前，需要随便请求一个接口，
例如：http://localhost:8762/hi，否则会一直ping ping ping
8.1、打开http://localhost:8762/actuator/hystrix.stream，可以看到一些具体的数据
8.2、打开localhost:8762/hystrix 可以看见以下界面
在界面依次输入：http://localhost:8762/actuator/hystrix.stream 、2000 、miya  点确定
8.3、在另一个窗口输入： http://localhost:8762/hi?name=forezp  重新刷新hystrix.stream网页，你会看到良好的图形化界面



9、Hystrix Turbine简介
看单个的Hystrix Dashboard的数据并没有什么多大的价值，要想看这个系统的Hystrix Dashboard数据就需要用到Hystrix Turbine。
Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合。Hystrix Turbine的使用非常简单，只需要引入相应的依赖和加上注解和配置就可以了

9.1、依次开启eureka-server、hello-service、hello1-service、turbine-server工程。
euraka-server:8761
hello-service:8762
hello1-service:8763
turbine-server:9999

打开浏览器输入：http://localhost:9999/turbine.stream,界面如下：

9.2、依次请求：
http://localhost:8762/hi?name=forezp
http://localhost:8763/hi?name=forezp
9.3、打开:http://localhost:8763/hystrix,输入监控流http://localhost:9999/turbine.stream
点击monitor stream 进入页面
可以看到这个页面聚合了2个service的hystrix dashbord数据。


10、






















Spring Cloud

Eureka：各个服务启动时，Eureka Client都会将服务注册到Eureka Server，并且Eureka Client还可以反过来从Eureka Server拉取注册表，从而知道其他服务在哪里

Ribbon：服务间发起请求的时候，基于Ribbon做负载均衡，从一个服务的多台机器中选择一台

Feign：基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求（消费端默认使用ribbon进行负载均衡）

Hystrix：发起请求是通过Hystrix的线程池来走的，不同的服务走不同的线程池，实现了不同服务调用的隔离，避免了服务雪崩的问题

Zuul：如果前端、移动端要调用后端系统，统一从Zuul网关进入，由Zuul网关转发请求给对应的服务


注册中心：consul

配置中心configserver

sleuth：分布式链路追踪

bus：消息总线

dashboard：实时监控仪表盘


概念：service mesh

参考：
https://juejin.im/post/5be13b83f265da6116393fc7






参考：
https://github.com/lishuai2016/SpringCloudLearning