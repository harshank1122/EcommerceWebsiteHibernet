package com.ecommerce.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ecommerce.CategoryDao;
import com.ecommerce.ProductDao;
import com.ecommerce.user.Catagory;
import com.ecommerce.user.Product;

@MultipartConfig
public class ProductOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// Fetching category data
		
		String op = request.getParameter("operation");
		
		if(op.trim().equals("addcategory")) {
			//add category
			String title = request.getParameter("catTitel");
			String description = request.getParameter("catDiscription");
			
			Catagory catagory = new  Catagory();
			catagory.setCatagoryTitle(title);
			catagory.setCatagoryDescription(description);
			
			CategoryDao categoryDao = new CategoryDao();
			if(categoryDao.saveCategory(catagory)) {
				HttpSession session = request.getSession();
		        session.setAttribute("added", "Category added");
		        response.sendRedirect("admin.jsp");
		        return;
			}
			else {
				
			}
			
		}
		else if(op.trim().equals("addproduct")) {
			// add product
			String pName = request.getParameter("pName");
			String pDescription = request.getParameter("pDescription");
			int pPrice = Integer.parseInt(request.getParameter("pPrice"));
			int pDis = Integer.parseInt(request.getParameter("pDis"));
			int pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
			int catId = Integer.parseInt(request.getParameter("catId"));
			Part part = request.getPart("pPice");
			
			
			Product p = new Product();
			p.setPname(pName);
			p.setpDesc(pDescription);
			p.setPprice(pPrice);
			p.setPdiscount(pDis);
			p.setPquantity(pQuantity);
			p.setPphoto(part.getSubmittedFileName());
			
			// get category by id 
			
			CategoryDao categoryDao = new CategoryDao();
			Catagory cat = categoryDao.getCategoryById(catId);
			p.setCatagory(cat);
			
			
			ProductDao productDao = new ProductDao();
			if(productDao.saveProduct(p)) {
				
				try {
					// find the path
					String path = request.getRealPath("img")+File.separator + "Product" + File.separator + part.getSubmittedFileName() ;
					System.out.println(path);
					
					// uploding code..
					
					FileOutputStream fos = new FileOutputStream(path);
					InputStream is = part.getInputStream();
					
					byte[] data = new byte[is.available()];
					is.read(data);
					
					fos.write(data);
					fos.close();
				} catch (Exception e) {
					System.out.println("not uplode image");
				}
				
				HttpSession session = request.getSession();
		        session.setAttribute("added_pro", "Product added");
		        response.sendRedirect("admin.jsp");
		        return;
			}
			else {
				
			}
			
			
			
			
			
		}
		

		
	}

}
