package com.newsmanager.dao;

import com.newsmanager.entity.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2019/7/12 22:46:30
 * @description
 */
public class NewsDao {

    /**
     * 修改新闻
     * @param newsId
     * @param newsTitle
     * @param newsType
     * @param newsContent
     * @return
     */
    public  int updateNews(Integer newsId,String newsTitle,String newsType,String newsContent){
        int count = 0 ;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "update news set newsTitle = ? ,newsType = ? , newsContent = ? where newsId = ?";
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boke", "root", "root");
            //3.创建statement对象
            statement = connection.prepareStatement(sql);
            //设置参数
            statement.setString(1,newsTitle);
            statement.setString(2,newsType);
            statement.setString(3,newsContent);
            statement.setInt(4,newsId);

            //4.执行sql
            count = statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    /**
     * 根据新闻主键查询新闻对象
     * @param id
     * @return
     */
    public News getNews(Integer id){
        News news = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {


            String sql = "select * from news where newsId = ?";
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boke", "root", "root");
            //3.创建statement对象
            statement = connection.prepareStatement(sql);
            //设置参数
            statement.setInt(1,id);
            //4.执行sql并解析返回结果集
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int newsId = resultSet.getInt("newsId");
                String newsTitle = resultSet.getString("newsTitle");
                String newsContent = resultSet.getString("newsContent");
                String newsStatus = resultSet.getString("newsStatus");
                String newsType = resultSet.getString("newsType");
                Date createTime = resultSet.getDate("createTime");
                news = new News(newsId, newsTitle, newsContent, newsStatus, newsType, createTime);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return news;
    }

    /**
     * 审核新闻
     * @param id
     * @return
     */
    public int shenheNews(Integer id){
        int count = 0 ;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "update news set newsStatus = '已审核' where newsId = ?";
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boke", "root", "root");
            //3.创建statement对象
            statement = connection.prepareStatement(sql);
            //设置参数
            statement.setObject(1,id);

            //4.执行sql
            count = statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    /**
     * 删除新闻
     * @param id 新闻主键id
     * @return 数据库受影响行数
     */
    public int deleteNewsById(Integer id){
        int count = 0 ;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "delete from news where newsId = ?";
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boke", "root", "root");
            //3.创建statement对象
            statement = connection.prepareStatement(sql);
            //设置参数
            statement.setObject(1,id);

            //4.执行sql
            count = statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    /**
     * 方法描述 添加新闻
     * @param newsTitle
     * @param newsType
     * @param newsContent
     * @return 数据库受影响的行数
     */
    public int addNews(String newsTitle,String newsType,String newsContent){
        int row = 0 ;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "insert into news(newsTitle,newsContent,newsStatus,newsType,createTime) values(?,?,?,?,?)";
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boke", "root", "root");
            //3.创建statement对象
            statement = connection.prepareStatement(sql);
            //设置参数
            statement.setObject(1,newsTitle);
            statement.setString(2,newsContent);
            statement.setString(3,"未审核");
            statement.setString(4,newsType);
            //构造一个java.sql.Date对象
            Date date = new Date(new java.util.Date().getTime());
            statement.setDate(5,date);
            //4.执行sql
             row = statement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return row;
    }


    /**
     * 方法描述  查询所有新闻集合
     *
     * @param pageNumber 页码
     * @param pageSize   显示的记录行数
     * @return 当前页的文章类集合
     */
    public List<News> getNewsList(Integer pageNumber, Integer pageSize) {
        List<News> newList = new ArrayList<News>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //跳过的记录行数
            int startSize = (pageNumber-1)*pageSize;

            String sql = "select * from news limit "+startSize+","+pageSize;
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boke", "root", "root");
            //3.创建statement对象
            statement = connection.createStatement();
            //4.执行sql并解析返回结果集
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int newsId = resultSet.getInt("newsId");
                String newsTitle = resultSet.getString("newsTitle");
                String newsContent = resultSet.getString("newsContent");
                String newsStatus = resultSet.getString("newsStatus");
                String newsType = resultSet.getString("newsType");
                Date createTime = resultSet.getDate("createTime");
                News news = new News(newsId, newsTitle, newsContent, newsStatus, newsType, createTime);
                newList.add(news);
            }
            return newList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return newList;
    }

    /**
     * 获得记录的总条数
     * @return
     */
    public int getCount(){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int count = 0;

        try {
            String sql = "select count(*) from news";
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.驱动管理获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/boke", "root", "root");
            //3.创建statement对象
            statement = connection.createStatement();
            //4.执行sql并解析返回结果集
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                count =  resultSet.getInt(1);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

}
