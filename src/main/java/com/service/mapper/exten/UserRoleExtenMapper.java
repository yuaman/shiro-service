/** 


*　　　┏┓　　　┏┓ 
*　　┏┛┻━━━┛┻┓ 
*　　┃　　　　　　　┃ 
*　　┃　　　━　　　┃ 
*　　┃　┳┛　┗┳　┃ 
*　　┃　　　　　　　┃ 
*　　┃　　　┻　　　┃ 
*　　┃　　　　　　　┃ 
*　　┗━┓　　　┏━┛ 
*　　　　┃　　　┃神兽保佑 
*　　　　┃　　　┃代码无BUG！ 
*　　　　┃　　　┗━━━┓ 
*　　　　┃　　　　　　　┣┓ 
*　　　　┃　　　　　　　┏┛ 
*　　　　┗┓┓┏━┳┓┏┛ 
*　　　　　┃┫┫　┃┫┫ 
*　　　　　┗┻┛　┗┻┛   
* @Title: UserRoleExtenMapper.java 
* @Package net.youhj.mapper.auth.exten 
* @Description: TODO[]
* @author gouliren@qq.com[王闯]    
* @date 2016年10月26日 上午10:11:28 
* @version V1.0   
*/
package com.service.mapper.exten;

import java.util.List;
import java.util.Map;

/** 
 * @ClassName: UserRoleExtenMapper 
 * @Description: TODO[] 
 * @author dmu_ypf@163.com[姚鹏飞] 
 * @date 2016年10月26日 上午10:11:28  
 */
public interface UserRoleExtenMapper {
	/** 
	* @Title: selectUserRoleMap 
	* @Description: TODO[] 
	* @param @param params
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws 
	*/
	public List<Map<String,Object>>  selectUserPermissMap(Map<String, Object> params);
}
