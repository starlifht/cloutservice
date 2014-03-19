package com.cloud.methods;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.List;

import com.cloud.methods.FileOp;

import org.jdom.Attribute;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


/**
 * 
 * @author starwang
 * XML 解析
 */
public class XML {
	//private final static String realPath=ServletActionContext.getServletContext().getRealPath("/")+"/";
	 public static String doc2String(Document doc) throws Exception {    //document转字符创 
	        Format format = Format.getPrettyFormat();     
	        format.setEncoding("UTF-8");// 设置xml文件的字符为UTF-8，解决中文问题     
	        XMLOutputter xmlout = new XMLOutputter(format);     
	        ByteArrayOutputStream bo = new ByteArrayOutputStream();     
	        xmlout.output(doc, bo);     
	        return bo.toString();     
	    }     
	   public static Document string2Doc(String xmlStr) throws Exception {   //字符串 转document  
	        java.io.Reader in = new StringReader(xmlStr);     
	        Document doc = (new SAXBuilder()).build(in);            
	        return doc;     
	    }  
	public static void createDoc() throws Exception {
		   Element carEl = new Element("car");
		    //创建vin属性，并设置值
		    carEl.setAttribute("vin", "123fhg5869705iop90");
		    
		    //创建注释
		    carEl.addContent(new Comment("Description of a car"));
		    
		    //创建一个make元素，设置文本内容
		    carEl.addContent(new Element("make").setText("Toyota"));
		    
		    //创建一个model元素，添加一个文本元素
		    carEl.addContent(new Element("model").setContent(new Text("Celica")));
		    
		    //创建一个year元素，添加文本内容
		    carEl.addContent(new Element("year").addContent("1997"));
		    
		    //创建一个color元素，文本内容是green
		    carEl.addContent(new Element("color").setText("green"));
		    
		    //创建一个license的元素
		    Element licenseEl = new Element("license");
		    //为license元素添加文本内容
		    licenseEl.addContent("1ABC234");
		    //创建一个state的属性，值为CA
		    licenseEl.setAttribute("state", "CA");
		    //将licenseEl添加到根元素中
		    carEl.addContent(licenseEl);
		    
		    //将car元素设置为根元素
		    Document doc = new Document(carEl);
		    //System.out.print(doc.getDocument().toString());
		    XMLOutputter output = new XMLOutputter(); //2是指缩进2个字符，true表示用换行，－－增强可读性 
		    FileOutputStream out = new FileOutputStream("dsf.xml"); 
		    output.output(doc, out);
	
	
	}
	public static void readXMLContent(Document doc) {
	  //  SAXBuilder builder = new SAXBuilder();
	    try {
	       // Document doc = builder.build(new File("dsf.xml"));
	        Element rootEl = doc.getRootElement();
	        //获得所有子元素
	        @SuppressWarnings("unchecked")
			List<Element> list = rootEl.getChildren();
	        //List<Element> list = rootEl.getChildren("disk");
	        for (Element el : list) {
	            //获取name属性值
	            String name = el.getAttributeValue("name");
	            if(name.equals("HTTPSampler.domain")){
	            	System.out.print(el.getChildText(name));
	            }
	            //获取子元素capacity文本值
	            String capacity = el.getChildText("title");
	            //获取子元素directories文本值
	            String directories = el.getChildText("make");
	            String files = el.getChildText("files");
	            System.out.println(el.getText());
	            System.out.println(el.getChildren());
	            System.out.println("分区容量:" + capacity);
	            System.out.println("目录数:" + directories);
	            System.out.println("文件数:" + files);
	            System.out.println("-----------------------------------");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public static void creatJMX(Document doc) {
		  //  SAXBuilder builder = new SAXBuilder();
		    try {
		    	//String s=FileOp.readFile("demo.jmx").toString();
		       // Document doc = builder.build(new File("dsf.xml"));
		        Element rootEl = doc.getRootElement().getChild("hashTree");
		        Element ThreadGroup=rootEl.getChild("hashTree").getChild("ThreadGroup");
		        Element loops =  ThreadGroup.getChild("elementProp").getChild("stringProp");
		        loops.setText("888");
		        List<Element> stringProp =  ThreadGroup.getChildren("stringProp");

		        //获得所有子元素
//		        @SuppressWarnings("unchecked")
//				List<Element> list = rootEl.getChildren();
		     
		        for (Element el : stringProp) {
		            //获取name属性值
		            String name = el.getAttributeValue("name");
		            if(name.equals("ThreadGroup.num_threads")){
		            	el.setText("999");
		            }
		            //获取子元素capacity文本值
		            FileOp.saveFile("d:\\qwe.jmx", doc2String(doc));
		            System.out.println("-----------------------------------");
		        }
		        System.out.println(rootEl.getChild(""));
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
	 public static void readNode(Element root, String prefix) {  
	        if (root == null) return;  
	        // 获取属性  
	        List<Attribute> attrs = root.getAttributes();  
	        if (attrs != null && attrs.size() > 0) {  
	            System.err.print(prefix);  
	            for (Attribute attr : attrs) {  
	               // System.err.print(attr.getValue() + " ");  
	            }  
	            System.err.println();  
	        }  
	        // 获取他的子节点  
	        List<Element> childNodes = root.getChildren();  
	        prefix += "\t";  
	        for (Element e : childNodes) {  
	            readNode(e, prefix);  
	        }  }
	public static void main(String[] args) throws Exception {
//        String s = "<?xml version=\"1.0\" encoding=\"GBK\"?><result><status>0</status></result>";
//
//		 SAXBuilder builder = new SAXBuilder(false);  
		String s=FileOp.readFile("demo.jmx").toString();
		System.out.println(s);
		//java.io.InputStream in = XML.class.getClassLoader().getResourceAsStream("c:/HTTP.jmx");  
        Document doc = string2Doc(s);  
       
//        // 获取根节点 <university>  
//        Element root = doc.getRootElement();  
//     //  readNode(root, "ThreadGroup.end_time"); 
//		//byte[] buff = new byte[100]; 
//        root.getChild("hashTree").getChild("hashTree").getChild("ThreadGroup").getChild("elementProp").setText("555");
//        System.out.println(doc2String(doc));
//        FileOp.saveFile("d:\\sdfsd.jmx", doc2String(doc));
//        System.out.print(root.getChild("hashTree").getChild("hashTree").getChild("ThreadGroup").getChildText("boolProp"));
        //HTTPSamplerProxy(doc);
	//readXMLContent();
        
	}

}
