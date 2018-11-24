参考：
https://blog.csdn.net/chen497147884/article/details/79896141
Spring Cloud版本说明

Spring Cloud是一个由众多独立子项目组成的大型综合项目，每个子项目有不同的发行节奏，都维护着自己的发布版本号。
Spring Cloud通过一个资源清单BOM（Bill of Materials）来管理每个版本的子项目清单。为避免与子项目的发布号混淆，
所以没有采用版本号的方式，而是通过命名的方式。

这些版本名称的命名方式采用了伦敦地铁站的名称，同时根据字母表的顺序来对应版本时间顺序，
比如：最早的Release版本：Angel，第二个Release版本：Brixton，然后是Camden、Dalston、Edgware，目前最新的是Finchley版本。

当一个版本的Spring Cloud项目的发布内容积累到临界点或者解决了一个严重bug后，就会发布一个“service releases”版本，简称SRX版本，
其中X是一个递增数字。当前官网上最新的稳定版本是Edgware.SR3，里程碑版本是Finchley.M9。
下表列出了这两个版本所包含的子项目及各子项目的版本号。

Component	Edgware.SR3	Finchley.M9	Finchley.BUILD-SNAPSHOT
spring-cloud-aws	1.2.2.RELEASE	2.0.0.M4	2.0.0.BUILD-SNAPSHOT
spring-cloud-bus	1.3.2.RELEASE	2.0.0.M7	2.0.0.BUILD-SNAPSHOT
spring-cloud-cli	1.4.1.RELEASE	2.0.0.M1	2.0.0.BUILD-SNAPSHOT
spring-cloud-commons	1.3.3.RELEASE	2.0.0.M9	2.0.0.BUILD-SNAPSHOT
spring-cloud-contract	1.2.4.RELEASE	2.0.0.M8	2.0.0.BUILD-SNAPSHOT
spring-cloud-config	1.4.3.RELEASE	2.0.0.M9	2.0.0.BUILD-SNAPSHOT
spring-cloud-netflix	1.4.4.RELEASE	2.0.0.M8	2.0.0.BUILD-SNAPSHOT
spring-cloud-security	1.2.2.RELEASE	2.0.0.M3	2.0.0.BUILD-SNAPSHOT
spring-cloud-cloudfoundry	1.1.1.RELEASE	2.0.0.M3	2.0.0.BUILD-SNAPSHOT
spring-cloud-consul	1.3.3.RELEASE	2.0.0.M7	2.0.0.BUILD-SNAPSHOT
spring-cloud-sleuth	1.3.3.RELEASE	2.0.0.M9	2.0.0.BUILD-SNAPSHOT
spring-cloud-stream	Ditmars.SR3	Elmhurst.RC3	Elmhurst.BUILD-SNAPSHOT
spring-cloud-zookeeper	1.2.1.RELEASE	2.0.0.M7 2.0.0.BUILD-SNAPSHOT	
spring-boot	1.5.10.RELEASE	2.0.0.RELEASE	2.0.0.BUILD-SNAPSHOT
spring-cloud-task	1.2.2.RELEASE	2.0.0.M3	2.0.0.RELEASE
spring-cloud-vault	1.1.0.RELEASE	2.0.0.M6	2.0.0.BUILD-SNAPSHOT
spring-cloud-gateway	1.0.1.RELEASE	2.0.0.M9	2.0.0.BUILD-SNAPSHOT
spring-cloud-openfeign		2.0.0.M2	2.0.0.BUILD-SNAPSHOT
Finchley 与 Spring Boot 2.0.x, 兼容，不支持 Spring Boot 1.5.x. 
Dalston 和 Edgware 与 Spring Boot 1.5.x, 兼容，不支持 Spring Boot 2.0.x. 
Camden 是构建在 Spring Boot 1.4.x, 之上，但也支持 1.5.x. 
Brixton 是构建在 Spring Boot 1.3.x, 之上，但也支持 1.4.x. 
Angel 是构建在 Spring Boot 1.2.x, 之上，但也兼容 Spring Boot 1.3.x. 
注意: Angel 和 Brixton 两个版本已于2017年7月终止不再进行维护。 
注意: Angel 和 Brixton 两个版本已于2017年7月终止不再进行维护。

开发代号看似没有什么规律，但实际上首字母是有顺序的，比如：Dalston版本，我们可以简称 D 版本，对应的 Edgware 版本我们可以简称 E 版本。

D版本和E版本的区别
二者均基于SpringBoot的1.5.x版本。但支持其他组件的版本不同，如以 Dalston.SR4 和 Edgware.RELEASE 来对比：

spring-cloud-config 分别对应 1.3.3和 1.4.0; 
spring-cloud-netflix 分别对应 1.3.5和 1.4.0; 
spring-cloud-consul 分别对应 1.2.1和 1.3.0; 
spring-cloud-gateway 前者不支持，后者 1.0.0。

每个小版本的不同，会有细微差别。

F版本
F版本是个绝对的大版本，几乎所有组件，全部同步变更版本号为2.x。

小版本
Spring Cloud 小版本分为:
SNAPSHOT： 快照版本，随时可能修改

M： MileStone，M1表示第1个里程碑版本，一般同时标注PRE，表示预览版版。

SR： Service Release，SR1表示第1个正式版本，一般同时标注GA：(GenerallyAvailable),表示稳定版本。

选择版本
idea里面的RC版本
idea里面的 RC版本英文版名字叫Release Candidate（候选版本）

大版本
首先说明，各个版本之间组件变化不大，但细节略有不同，比如配置项名称、或者新版本增加新的配置方式。 
从这一点来看，选择哪个版本都不是大问题，但提醒一下，遇到坑时，最好根据版本进行查询，否则你会发现你找到的办法不行。实际上是版本不匹配。

如果你项目需要和其他老项目交叉，以兼容为第一要务。

如果全新项目，可以考虑较新版本，如E版。如果你爱好踩坑，F拿去。

小版本
小版本没啥可说的，尝鲜：SNAPSHOT，生产：GA。
