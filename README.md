### java 自定义注解  
  - Java注解是附加在代码中的一些元信息，用于一些工具在编译、运行时进行解析和使用，起到说明、配置的功能。
注解不会也不能影响代码的实际逻辑，仅仅起到辅助性的作用。包含在 java.lang.annotation 包中。

#### 元注解——指注解的注解，包括 @Retention、@Target、@Document、@Inherited四种  
 - ##### @Retention——定义注解的保留策略
     - RetentionPolicy.SOURCE —— 注解仅存在于源码中，在class字节码文件中不包含
     - RetentionPolicy.CLASS —— 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得
     - RetentionPolicy.RUNTIME —— 注解会在class字节码文件中存在，在运行时可以通过反射获取到