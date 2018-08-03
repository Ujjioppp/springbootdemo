# springbootdemo
springboot学习项目

2018年08月02日

技术：springboot、mybatis、thymeleaf、mysql。

实现：

mybatis pagehelper分页
自定义注解
@LoginAccess：用于Controller内方法，判断是否登录。
@PageAccess：用于Service内方法，判断是否需要分页。
自定义异常
BusiException：Controller内捕获到异常跳转500页面。
AOP：Aspect使用@Before配合@PageAccess判断是否开启分页查询（开始分页后只针对下一次select生效，如service内多次查询，则不适合使用@PageAccess）。
properties文件注入：使用@PropertySource读取自定义properties文件配合@Value注入配置文件常亮。
拦截器：配合@LoginAccess注解判断是否跳转到登录页（采用@Bean方式添加拦截器方可使拦截器可以获取到properties文件中变量）。
Thymeleaf：
th:each
th:replace（替换，@see th:include）
druid


2018年08月03日

技术：redis

实现：RedisTemplate 管理登录用户。
