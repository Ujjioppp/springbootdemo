# springbootdemo
springboot学习项目

2018年08月02日

技术：springboot、mybatis、thymeleaf、mysql、maven。

实现：

* mybatis generator
* mybatis pagehelper分页
* 自定义注解
  * <code>@LoginAccess</code>：用于Controller内方法，判断是否登录。
  * <code>@PageAccess</code>：用于Service内方法，判断是否需要分页。
* 自定义异常
  * BusiException：Controller内捕获到异常跳转500页面。
* AOP：Aspect使用<code>@Before</code>配合<code>@PageAccess</code>判断是否开启分页查询（开始分页后只针对下一次select生效，如service内多次查询，则不适合使用<code>@PageAccess</code>）。
* properties文件注入：使用<code>@PropertySource</code>读取自定义properties文件配合<code>@Value</code>注入配置文件常亮。
* 拦截器：配合@LoginAccess注解判断是否跳转到登录页（采用<code>@Bean</code>方式添加拦截器方可使拦截器可以获取到properties文件中变量）。
* Thymeleaf：
  * <code>th:each</code>
  * <code>th:replace</code>（替换，@see <code>th:include</code>）
* druid



2018年08月03日

技术：redis

实现：
* <code>RedisTemplate</code> 管理登录用户，<code>@LoginAccess</code>配合redis校验用户是否登录。
* <code>HandlerMethodArgumentResolver</code> 自动注入Controller参数列表中User（登录用户）。
* Thymeleaf 空值的处理使用“?”，例<code>th:text="${user?.userName}"</code>。



2018年08月06日

技术：JSR303

实现：
* thymeleaf使用<code>th:object</code>、<code>th:field</code>、<code>th:errors</code>，Controller使用<code>@ModelAttribute</code>、<code>@Valid</code>
    * 遇到问题：跳转到登录页时报出异常：<code>Neither BindingResult nor plain target object for bean name '' available as request attribut</code>，在跳转登录页面方法内加入参数<code>@ModelAttribute("userForm")</code>解决。