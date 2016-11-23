package com.baustem.xmlservice.utils;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtil {

	public static String fileUpload(String realPath, HttpServletRequest request) {
		String fileName = "";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);

		try {

			List<FileItem> fileItems = fileUpload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					String fieldN = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					System.out.println("fileName: " + fieldN + "\t" + "value: "
							+ value);
				} else {
					 fileName = fileItem.getName();
					if (fileName.contains("/")) {
						String[] split = fileName.split("/");
						fileName = split[split.length - 1];
					}
					if (fileName.contains("\\")) {
						String[] split = fileName.split("\\\\");
						fileName = split[split.length - 1];
					}
					// 将文件写入到磁盘中
					if (!realPath.endsWith("/")) {
						realPath = realPath + "/";
					}
					File file = new File(realPath);
					if (!file.exists()) {
						file.mkdirs();
					} else {
						fileItem.write(new File(realPath + fileName));
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}

}
