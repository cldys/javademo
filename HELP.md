# 快速开始

### 参考文档

如需进一步了解，请参考以下内容：

* [Apache Maven 官方文档](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven 插件参考指南](https://docs.spring.io/spring-boot/4.0.4/maven-plugin)
* [创建 OCI 镜像](https://docs.spring.io/spring-boot/4.0.4/maven-plugin/build-image.html)
* [验证](https://docs.spring.io/spring-boot/4.0.4/reference/io/validation.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.4/reference/web/servlet.html)

### 指南

下面这些指南演示了如何具体使用某些功能：

* [验证](https://spring.io/guides/gs/validating-form-input/)
* [构建 RESTful Web 服务](https://spring.io/guides/gs/rest-service/)
* [使用 Spring MVC 提供 Web 内容](https://spring.io/guides/gs/serving-web-content/)
* [使用 Spring 构建 REST 服务](https://spring.io/guides/tutorials/rest/)

### Maven 父级覆盖

由于 Maven 的设计，某些元素会从父级 POM 继承到项目 POM。
虽然大多数继承是合适的，但也会继承一些不需要的元素，比如父级中的 `<license>` 和 `<developers>`。
为避免这种情况，项目 POM 中为这些元素提供了空的覆盖定义。
如果你手动切换到另一个父级，并且确实希望继承这些内容，需要移除这些覆盖定义。
