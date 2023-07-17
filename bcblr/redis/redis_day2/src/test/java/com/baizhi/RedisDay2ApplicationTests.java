package com.baizhi;

import com.baizhi.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = RedisDay2Application.class)
@RunWith(SpringRunner.class)
public class RedisDay2ApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;




	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testRedisTemplate(){


		//设置key的序列化   //string  list  set   zset
		redisTemplate.setKeySerializer(new StringRedisSerializer());  //字符串序列化方式



		//设置value的续列化
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		//为了保证jackson反序列化成功必须将转换对象类型一并存储到json中以便日后反序列化
		ObjectMapper objectMapper =new ObjectMapper();
		//转换json时将原始类型保留在json中
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		//修改日期格式
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy年MM月dd"));
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);



		/*redisTemplate.opsForSet().add("sets",new User("21","xxxx",23,new Date()));


		redisTemplate.opsForList().leftPushAll("namesss",new User("21","xxxx",23,new Date()),new User("21","xxxx",23,new Date()));

		redisTemplate.opsForZSet().add("zsets",new User("21","xxxx",23,new Date()),100);

		//hash特殊 key  key jdk
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.opsForHash().put("maps","name",new User("21","xxxx",23,new Date()));
*/


		redisTemplate.opsForList().leftPush("names",new User("21","乐乐乐乐",23,new Date()),new User("21","犯规得分高分的",23,new Date()));

		//redisTemplate.opsForList().rightPush("names","","");


		/*
		//序列化
		User v = new User();
		v.setId(UUID.randomUUID().toString()).setName("校长").setAge(23).setBir(new Date());
		redisTemplate.opsForValue().set("user", v);


		User user = (User) redisTemplate.opsForValue().get("user");

		System.out.println(user);*/

		/*redisTemplate.opsForValue().set("aa","小黑");
		Object aa = redisTemplate.opsForValue().get("aa");
		System.out.println(aa);*/
		//Set keys = redisTemplate.keys("序列化的内容");
		//keys.forEach(key-> System.out.println(key));
	}




	//使用绑定key的操作
	@Test
	public void testStringRedisTemplateBoundKeys(){

		//name zhangsan     xiaohei  .....

		BoundValueOperations<String, String> nameValueOperations = stringRedisTemplate.boundValueOps("name");//绑定字符串类型的key

		nameValueOperations.append("xxxxx");
		String s = nameValueOperations.get();
		System.out.println(s);
		nameValueOperations.set("this is xiaohei");
		String s1 = nameValueOperations.get();
		System.out.println(s1);

		BoundListOperations<String, String> names = stringRedisTemplate.boundListOps("names");
		BoundSetOperations<String, String> sets = stringRedisTemplate.boundSetOps("sets");
		BoundZSetOperations<String, String> zsets = stringRedisTemplate.boundZSetOps("zsets");
		BoundHashOperations<String, Object, Object> stringObjectObjectBoundHashOperations = stringRedisTemplate.boundHashOps("");



	}





	//非绑定key的使用
	@Test
	public void testStringRedisTemplate() {

		//jedis key 相关操作
		Set<String> keys = stringRedisTemplate.keys("*");
		keys.forEach(key-> System.out.println(key));

		//参数1: key   参数2:时间  参数3:单位
		stringRedisTemplate.expire("name",10, TimeUnit.HOURS);

		Long name = stringRedisTemplate.getExpire("name");
		System.out.println(name);

		//string list set zset hash相关
		ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();

		stringStringValueOperations.set("age","张三");//string类型操作
		stringStringValueOperations.get("age");
		Map<String,String> map = new HashMap<String,String>();
		map.put("content","this is content");
		map.put("address","北京");


		ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();//list类型操作
		stringStringListOperations.rightPushAll("names","张三","小王");
		stringRedisTemplate.opsForSet().add("sets","zhangsan","lisi","wangwu");//set类型操作
		stringRedisTemplate.opsForZSet().add("zsets","zhangsan",12);//zset类型操作
		stringRedisTemplate.opsForHash().put("maps","name","xxxxx");//hash类型操作


	}

}
