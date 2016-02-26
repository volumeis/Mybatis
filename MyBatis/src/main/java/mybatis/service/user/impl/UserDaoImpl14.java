package mybatis.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.UserDao;

@Repository("userDaoImpl14")
public class UserDaoImpl14 implements UserDao {

	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public UserDaoImpl14(){
		System.out.println("::"+getClass() + " default constructor() Call...");
	}
	
	public void setSqlSession(SqlSession sqlSession){
		System.out.println("::"+getClass() + ".setSqlSession() Call...");
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("UserMapper10.addUser",user);
	}

	@Override
	public User getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return (User)sqlSession.selectOne("UserMapper10.getUser",userId);
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("UserMapper10.updateUser", user);
	}

	@Override
	public int removeUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("UserMapper10.removeUser", userId);
	}

	@Override
	public List<User> getUserList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("UserMapper10.getUserList",search);
	}

}
