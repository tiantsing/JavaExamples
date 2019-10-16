/**   
 * Copyright © 2019 tiantsing. All rights reserved.
 * 
 * 功能描述：
 * @Package: tk.mybatis.simple.mapper 
 * @author: tianq   
 * @date: 2019年9月26日 下午11:24:25 
 */
package tk.mybatis.simple.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**   
* Copyright: Copyright (c) 2019 tiantsing
* 
* @ClassName: BaseMapperTest.java
* @Description: 基础测试类
*
* @version: v1.0.0
* @author: tianq
* @date: 2019年9月26日 下午11:24:25 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年9月26日     tianq           v1.0.0               修改原因
*/
public class BaseMapperTest {
	private static SqlSessionFactory sqlSessionFactory;
	@BeforeClass
	public static void init() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch(IOException ignore) {
			ignore.printStackTrace();
		}
	}
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
