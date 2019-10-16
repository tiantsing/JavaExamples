/**   
 * Copyright © 2019 tiantsing. All rights reserved.
 * 
 * 功能描述：
 * @Package: tk.mybatis.simple.mapper 
 * @author: tianq   
 * @date: 2019年9月22日 下午9:54:28 
 */
package tk.mybatis.simple.mapper;

import java.util.List;

import tk.mybatis.simple.bean.SysRole;
import tk.mybatis.simple.bean.SysUser;

/**   
* Copyright: Copyright (c) 2019 tiantsing
* 
* @ClassName: UserMapper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: tianq
* @date: 2019年9月22日 下午9:54:28 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年9月22日     tianq           v1.0.0               修改原因
*/
public interface UserMapper {
	/**
	 * 
	* @Function: UserMapper.java
	* @Description: 通过id查询用户
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: tianq
	* @date: 2019年9月22日 下午10:45:40 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2019年9月22日     tianq           v1.0.0               修改原因
	 */
	SysUser selectById(Long id);
	/**
	 * 
	* @Function: UserMapper.java
	* @Description: 查询所有的用户
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: tianq
	* @date: 2019年9月26日 下午11:04:51 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2019年9月26日     tianq           v1.0.0               修改原因
	 */
	List<SysUser> selectAll();
	/**
	 * 
	* @Function: UserMapper.java
	* @Description: 根据用户id获取角色信息
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: tianq
	* @date: 2019年10月5日 下午8:00:32 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2019年10月5日     tianq           v1.0.0               修改原因
	 */
	List<SysRole> selectRolesByUserId(Long userId);
	/**
	 * 
	* @Function: UserMapper.java
	* @Description: 
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: tianq
	* @date: 2019年10月14日 下午10:54:15 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2019年10月14日     tianq           v1.0.0               修改原因
	 */
	int insert(SysUser sysUser);
}
