package com.newsmanager.servlet;

import com.newsmanager.dao.NewsDao;
import com.newsmanager.entity.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "NewsServlet")
public class NewsServlet extends HttpServlet {
    private NewsDao newsDao;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oprate = request.getParameter("oprate");
        //如果该次请求是addnews，则是添加新闻请求
        if("addnews".equals(oprate)){
            String newsTitle = request.getParameter("newsTitle");
            String newsType = request.getParameter("newsType");
            String newsContent = request.getParameter("newsContent");
            newsDao.addNews(newsTitle, newsType, newsContent);
            response.sendRedirect("NewsServlet");
        }else if("delete".equals(oprate)){
            Integer newsId = Integer.parseInt(request.getParameter("newsId"));
            newsDao.deleteNewsById(newsId);
            response.sendRedirect("NewsServlet");
        }else if("pishan".equals(oprate)){
            String[] deleteId = request.getParameterValues("deleteId");
            for (int i = 0; i < deleteId.length; i++) {
                Integer newsId = Integer.parseInt(deleteId[i]);
                newsDao.deleteNewsById(newsId);
            }
            response.sendRedirect("NewsServlet");
        }else if("pishenhe".equals(oprate)){
            String[] deleteId = request.getParameterValues("deleteId");
            for (int i = 0; i < deleteId.length; i++) {
                Integer newsId = Integer.parseInt(deleteId[i]);
                newsDao.shenheNews(newsId);
            }
            response.sendRedirect("NewsServlet");
        }else if("toupdate".equals(oprate)){
            Integer newsId = Integer.parseInt(request.getParameter("newsId"));
            News news = newsDao.getNews(newsId);
            request.setAttribute("news",news);
            request.getRequestDispatcher("newsUpdate.jsp").forward(request,response);
        }else if("updatenews".equals(oprate)){
            Integer newsId = Integer.valueOf(request.getParameter("newsId"));
            String newsTitle = request.getParameter("newsTitle");
            String newsType = request.getParameter("newsType");
            String newsContent = request.getParameter("newsContent");
            newsDao.updateNews(newsId,newsTitle,newsType,newsContent);
            response.sendRedirect("NewsServlet");
        }
        else{
            Integer pageNumber = 1;
            Integer pageSize = 10;
            String pn = request.getParameter("pageNumber");
            if(pn!=null){
                pageNumber = Integer.valueOf(pn);
            }
            if(pageNumber<=1){
                pageNumber = 1 ;
            }
            //获得总条数
            int count = newsDao.getCount() ;
            //获得总页数
            int pageTotal = count%pageSize==0?count/pageSize:count/pageSize+1;
            if(pageNumber>=pageTotal){
                pageNumber = pageTotal;
            }

            //调用查询新闻集合的方法
            List<News> newsList = newsDao.getNewsList(pageNumber,pageSize);
            //添加到request作用域中
            request.setAttribute("newsList",newsList);
            //将当前页码传递到newsList.jsp
            request.setAttribute("pageNumber",pageNumber);
            request.setAttribute("pageTotal",pageTotal);

            //转发到newsList.jsp页面
            request.getRequestDispatcher("/newsList.jsp").forward(request,response);
        }



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    public void init() throws ServletException {
        newsDao = new NewsDao();
    }
}
