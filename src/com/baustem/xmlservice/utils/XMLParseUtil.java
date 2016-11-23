package com.baustem.xmlservice.utils;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLParseUtil {
	
	
	/**
	 * 解析xml,得到所有节点和文本数据
	 * @param xmlFilePath
	 * @param kList
	 * @param vList
	 * @throws DocumentException
	 */
	
	public static void parseXML(String xmlFilePath,List<String> kList,List<String> vList) throws DocumentException{  
		
	    SAXReader sax=new SAXReader();
	    File xmlFile=new File(xmlFilePath);
	    
	    Document document=sax.read(xmlFile);
	    Element root=document.getRootElement();
	    
	    getNodes(root,kList,vList);
	    
	}  

	/** 
	 * 从指定节点开始,递归遍历所有子节点 
	 * 
	 */  
	private static void getNodes(Element node,List<String> kList,List<String> vList){  
	    //当前节点的名称、文本内容和属性  
	    String nodeN = node.getName();
	    String nodeV = node.getText();
	    kList.add(nodeN);
	    vList.add(nodeV);
	    //当前节点的所有属性的list 
	    @SuppressWarnings("unchecked")
		List<Attribute> listAttr=node.attributes(); 
	    for(Attribute attr:listAttr){
	        String name=attr.getName();
	        String value=attr.getValue();
	        kList.add(name);
	        vList.add(value);
	    }  
	    //递归遍历当前节点所有的子节点  
	    @SuppressWarnings("unchecked")
		List<Element> listElement=node.elements();
	    for(Element e:listElement){
	        getNodes(e,kList,vList);
	    }  
	}
	

}
