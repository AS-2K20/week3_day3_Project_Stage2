package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.print.attribute.standard.PrinterLocation;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;



@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		String[] split_value = blogDetails.split(",");
		String title = split_value[0];
		String description =split_value[1];
		LocalDate postedOn = LocalDate.now() ;
		
		Blog blog = new Blog(title,description,postedOn);

		blog.setTitle(title);
		blog.setDescription(description);
		blog.setPostedOn(postedOn);
		System.out.println("Blog Title: "+title);
		System.out.println("Blog Description: "+description);
		System.out.println("Posted on: "+postedOn);
		
		User user = null;
		
		if(blog!=null) {
			request.setAttribute("blog", blog);
			request.setAttribute("user",user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		
	}

}
