package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = ctx.getBean("userDao",UserDao.class);
        
        User user = new User();
        user.setId("dazzul");
        user.setName("김다솔");
        user.setPassword("1111");
        
        dao.add(user);
        
        System.out.println(user.getId() + " 등록 성공");
        
        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        
        System.out.println("조회 성공!");
    }
}
