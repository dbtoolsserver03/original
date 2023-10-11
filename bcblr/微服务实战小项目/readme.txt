
1.中期项目  班级管理系统   clazz-web-parent 父项目

   单体应用:   springboot  完成所有功能 
   
   微服务应用:  独立业务拆分 一个个微笑服务独立应用    服务与服务之间通信   重点
 

2.开发如何开发?

  项目开发流程:  
      
	  需求分析: 整个系统中模块  每个模块功能     
	  概要设计: 库表设计     .....                   
	  详细设计: 流程图  伪代码 验证分析库表准确性   ====> 省略
	  编码阶段: 环境搭建  +  业务编码
	  项目阶段: 测试开发人员业务功能
	  上线|发布新的版本:    更新迭代功能 
	  维护:     
	  
	
	班级管理系统:
	
	   1. 城市表 city  单表
	   2. 标签表 tag   单表
	   3. 班级表 clazz  tagId外键
	   4. 小组表 group  clazzId 外键
	   5. 学生表 student  cityId 外键  clazzid外键  groupid外键  
	   6. 关系表  学生标签关系表  student_tag  sid tid     
	   

  a.基于现有业务进行服务拆分  明确拆分服务?
  
       city  城市服务
	   tag   标签服务
	   clazz 班级服务
	   group 小组服务
	   student 学生服务
	   gateway 网关服务
	   
	   
  b.编码阶段(环境搭建)
    
	 要求:  1.要求整个系统中全部使用单表进行查询    2.整个微服务系统使用一个数据库  clazz-web  数据库编码: UTF8   3.idea中编码UTF-8
	        4.maven聚合开开发  
	
		
     环境搭建流程:
	 
	     1.库表入库    创建clazz-web库   编码: UTF8
		 
		 2.项目架子搭建 
		   clazz-web-parent  父项目  维护依赖
		      clazz-commons  公共服务  维护公共依赖 公共代码
		      clazz-city     城市服务
			  clazz-clazz    班级服务
			  clazz-group    小组服务
			  clazz-tag      标签服务
			  clazz-student  学生服务
			  
			  clazz-gateway   网关服务
			  
	     3.处理业务代码微服务 引入springboot依赖  引入consul client 依赖    引入consul actuator
		 
		 4.每一个微服务
			指定服务端口号
			指定服务服务名称
			注册consul server上面
			
		 
		 5.开发入口类   SpringBoot  Consul Client
		 
		 
		 6.网关服务   引入网关依赖 注意: 不要引入web  引入consul依赖

  
  c.编码阶段(业务代码实现)
  
	   1. 城市表 city  单表
	   2. 标签表 tag   单表
	   3. 班级表 clazz  tagId外键
	   4. 小组表 group  clazzId 外键
	   5. 学生表 student  cityId 外键  clazzid外键  groupid外键  
	             维护学生标签关系表  student_tag  sid tid     
	
	    
		城市服务开发: city
			
			1.整合 mybatis 操作 mysql数据库 环境
				a.引入 mybatis-springboot  mysql druid

			
			
		标签服务开发:
			1.整合 mybatis 操作 mysql数据库 环境
				a.引入 mybatis-springboot  mysql druid
				
		班级服务开发:
			1.整合 mybatis 操作 mysql数据库 环境
				a.引入 mybatis-springboot  mysql druid
			
		
		小组服务开发
			1.整合 mybatis 操作 mysql数据库 环境
				a.引入 mybatis-springboot  mysql druid
		
		学生服务开发
			1.整合 mybatis 操作 mysql数据库 环境
				a.引入 mybatis-springboot  mysql druid
  
	   
  
    