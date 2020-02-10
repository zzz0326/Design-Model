package Week1;

import java.sql.*;
import java.util.Scanner;

public class Login {

    public static void main (String[] args) {
        LoginForm loginForm = new LoginForm();

        loginForm.display();
        loginForm.init();
        loginForm.validate();
        loginForm.display();

    }

    static class  LoginForm{
        private String Account;
        private String Password;
        private boolean login=false;
        void init(){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入账号: ");
            Account = sc.nextLine();
            System.out.println("请输入密码: ");
            Password = sc.nextLine();
        }
        void display(){
            System.out.println("当前的登陆状态为: ");
            if (login){
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }

        }
        void validate(){
            UserDAO userDAO = new UserDAO();
            login=userDAO.findUser(Account,Password);
        }

        class UserDAO{
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            static final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";

            // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
            //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";


            // 数据库的用户名与密码，需要根据自己的设置
            static final String USER = "root";
            static final String PASS = "123456";

            boolean findUser(String userName, String userPassword) {
                Connection conn = null;
                Statement stmt = null;
                try {
                    // 注册 JDBC 驱动
                    Class.forName(JDBC_DRIVER);

                    // 打开链接

                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();
                    String sql;
                    sql = "SELECT account, password FROM login";
                    ResultSet rs = stmt.executeQuery(sql);

                    while(rs.next()){
                        // 通过字段检索

                        if(userName.equals(rs.getString("account"))&&userPassword.equals(rs.getString("password"))){
                            System.out.println("登陆成功");
                            rs.close();
                            stmt.close();
                            conn.close();
                            return true;
                        }

                    }

                    rs.close();
                    stmt.close();
                    conn.close();
                    System.out.println("账号或密码错误");
                    return false;
                } catch (SQLException se) {
                    // 处理 JDBC 错误
                    se.printStackTrace();
                } catch (Exception e) {
                    // 处理 Class.forName 错误
                    e.printStackTrace();
                } finally {
                    // 关闭资源
                    try {
                        if (stmt != null) stmt.close();
                    } catch (SQLException se2) {
                    }// 什么都不做
                    try {
                        if (conn != null) conn.close();
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                }
                return false;
            }
        }
    }
}
