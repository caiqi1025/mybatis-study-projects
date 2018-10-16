package mybatis.mapper;

import mybatis.entity.User;

public interface UserMapper {

	/**
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 *
	 * @param userId
	 * @return
	 */
	public int delUser(Integer userId);
}
