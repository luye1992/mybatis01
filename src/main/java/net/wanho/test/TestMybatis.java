package net.wanho.test;


import net.wanho.entity.User;
import net.wanho.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import util.MybatisUtil;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    private SqlSession sqlSession;
    private UserMapper userMapper;


@Before
    public void before(){

//    InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//
//    SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
//
//     sqlSession = sf.openSession();

    sqlSession = MybatisUtil.getSession();
    userMapper = sqlSession.getMapper(UserMapper.class);

}

@Test
    public void testAddUser(){
    User user = new User(null,"zhangsan","123");
    sqlSession.update("net.wanho.mapper.UserMapper.addUser",user);
    sqlSession.commit();
    sqlSession.close();

}

    @Test
    public void testUpdateUser(){
        User user = new User(6,"666","123");
        sqlSession.update("net.wanho.mapper.UserMapper.updateUser",user);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testdeleteUser(){
        User user = new User(8,"666","123");
//        sqlSession.update("net.wanho.mapper.UserMapper.deleteUser",user);
//        sqlSession.commit();
//        sqlSession.close();

        SqlSession sqlSession = MybatisUtil.getSession();
        sqlSession.update("net.wanho.mapper.UserMapper.deleteUser",user);
        sqlSession.commit();
        MybatisUtil.closeSession();

    }

    @Test
    public void testGetALL(){


        SqlSession session = MybatisUtil.getSession();

       List<User> users = session.selectList("net.wanho.mapper.UserMapper.getAllUser");
        System.out.println(users);
        MybatisUtil.closeSession();

    }
    @Test
    public void testGetUserById(){


//        SqlSession session = MybatisUtil.getSession();
//
//        User user = session.selectOne("net.wanho.mapper.UserMapper.getUserById",2);
//        System.out.println(user);
//        MybatisUtil.closeSession();

        User user = userMapper.getUserById(2);
        System.out.println(user);
        MybatisUtil.closeSession();
    }

    @Test
    public void testAddUserReturnKey() {
        User user = new User(null,"zhangsan","123");
        userMapper.addUserReturnKey(user);
        System.out.println(user.getId());
    }
}
