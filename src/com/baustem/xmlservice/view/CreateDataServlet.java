package com.baustem.xmlservice.view;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baustem.xmlservice.timer.EPGTimerTask;
import com.baustem.xmlservice.timer.ProgramTimerTask;
import com.baustem.xmlservice.utils.ConfigUtils;
import com.baustem.xmlservice.utils.FileUploadUtil;

public class CreateDataServlet extends HttpServlet {

	private static final long serialVersionUID = 8026729999323858566L;


	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String realPath = ConfigUtils.getXmlPath();
		
		if(!realPath.endsWith("/")){
			realPath = realPath+"/";
		}
		
		String fileName = FileUploadUtil.fileUpload(realPath, request);
		
		File file = new File(realPath+fileName);
		
		
		if(file.getName().contains("EPG")){
			Timer timer = new Timer();
			timer.schedule(new EPGTimerTask(file.getAbsolutePath()), new Date());
			response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
		}else if(file.getName().contains("Program")){
			Timer timer = new Timer();
			timer.schedule(new ProgramTimerTask(file.getAbsolutePath()), new Date());
			response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
		}else{
			response.getWriter().write("create data base is wrong!");
		}
		
		
		

	}

}
