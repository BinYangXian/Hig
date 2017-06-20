package cn.itheima.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.dao.UserMapper;
import cn.itheima.pojo.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SqlSessionFactory factory;
	@Override
	public User selectUser(User user) {
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		return mapper.selectUserByUidAndPwd(user);
	}

}
