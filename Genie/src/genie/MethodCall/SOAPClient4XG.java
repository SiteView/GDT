package genie.MethodCall;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;



public class SOAPClient4XG {
	public static void copy(InputStream in, OutputStream out)
			throws IOException {
		synchronized (in) {
			synchronized (out) {
				byte[] buffer = new byte[256];
				while (true) {
					int bytesRead = in.read(buffer);
					if (bytesRead == -1)
						break;
					out.write(buffer, 0, bytesRead);
				}
			}
		}
	}
	
//	public static String localConnection(String SoapUrl,String APIname,String s,String inputParams){//获取本地数据(WN1000RP)验证
//		BufferedReader in = null;
//		String result="";
//		try {
//			String SOAPUrl =  SoapUrl;
//			//String SOAPUrl = "http://www.mywifiext.com/soap/server_sa/";
//			//String SOAPUrl = "http://192.168.1.250:80/soap/server_sa/";
//			String xmlFile2Send =getRoot()+"File/Authenticate.xml";
//			URL url = new URL(SOAPUrl);
//			URLConnection connection = url.openConnection();
//			HttpURLConnection httpConn = (HttpURLConnection) connection;
//			FileInputStream fin = new FileInputStream(xmlFile2Send);
//			ByteArrayOutputStream bout = new ByteArrayOutputStream();//可以捕获内存缓冲区的数据，转换成字节数组。
//			copy(fin, bout);
//			fin.close();
//			byte[] b = bout.toByteArray();//获取内存缓冲中的数据
//			httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//			httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//			httpConn.setRequestProperty("User-Agent", "SOAP Sdk");
//			httpConn.setRequestProperty("Cache-Control", "no-cache");
//			httpConn.setRequestProperty("Connection", "Keep-Alive");
//			httpConn.setRequestProperty("SOAPAction", "urn:NETGEAR-ROUTER:service:DeviceConfig:1#Authenticate");
//			httpConn.setRequestMethod("POST");
//			httpConn.setDoOutput(true);// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在 http正文内，因此需要设为true, 默认情况下是false;   
//			httpConn.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;  
//			httpConn.connect();
//			OutputStream out = httpConn.getOutputStream();//向httpUrlConnection输出请求
//			out.write(b);
//			out.close();
//			InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());//从httpUrlConnection读入通过请求返回来的数据
//			in = new BufferedReader(isr);
//			String inputLine;
//			StringBuffer sb = new StringBuffer();
//			while ((inputLine = in.readLine()) != null){
//			sb.append(inputLine+"\n");
//			}
//			if(sb.toString()!=null){
//				System.out.println("验证结果:"+sb.toString());
//				result=localflowConnection(SoapUrl,APIname,s,inputParams);
//			}
//			return result;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				in.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
	
	
	
	
	//ExtenderAndGenieAPI(Local)
	public static String localflowConnection(String SoapUrl,String APIname,String s,String inputParams){//获取本地数据(WN1000RP,WNR3500Lv2)
		BufferedReader in = null;
		String xmlFile2Send="";
		String SOAPUrl="";
		HttpURLConnection httpConn=null;
		try {
			 SOAPUrl = SoapUrl;
			//String SOAPUrl = "http://www.mywifiext.com/soap/server_sa/";
			//String SOAPUrl = "http://192.168.1.250:80/soap/server_sa/";
			//String SOAPUrl = "http://routerlogin.net:5000/soap/server_sa/";
			System.out.println("APIname:"+APIname);
//			if(APIname.equals("GetEnable")){
//				xmlFile2Send =getRoot()+"File/weattherreq.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("GetAPInfo")){
//				xmlFile2Send =getRoot()+"File/GetAPInfo.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("SetExtenderMode")){
//				xmlFile2Send =getRoot()+"File/SetExtenderMode.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("ConfigurationStarted")){
//				xmlFile2Send =getRoot()+"File/ConfigurationStarted.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("SetRouterWLANNoSecurity")){
//				xmlFile2Send =getRoot()+"File/SetRouterWLANNoSecurity.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("SetRouterWLANWEPByKeys")){
//				xmlFile2Send =getRoot()+"File/SetRouterWLANWEPByKeys.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("SetRouterWLANWPAPSKByPassphrase")){
//				xmlFile2Send =getRoot()+"File/SetRouterWLANWPAPSKByPassphrase.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("GetRouterWLANInfo")){
//				xmlFile2Send =getRoot()+"File/GetRouterWLANInfo.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("SetWLANNoSecurity")){
//				xmlFile2Send =getRoot()+"File/SetWLANNoSecurity.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("SetWLANWEPByKeys")){
//				xmlFile2Send =getRoot()+"File/SetWLANWEPByKeys.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("SetWLANWPAPSKByPassphrase")){
//				xmlFile2Send =getRoot()+"File/SetWLANWPAPSKByPassphrase.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("ConfigurationFinished")){
//				xmlFile2Send =getRoot()+"File/ConfigurationFinished.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("GetRouterWLANWEPInfo")){
//				xmlFile2Send =getRoot()+"File/GetRouterWLANWEPInfo.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("GetRouterWLANWPAInfo")){
//				xmlFile2Send =getRoot()+"File/GetRouterWLANWPAInfo.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//			}else if(APIname.equals("SetEnable")){
//				xmlFile2Send =getRoot()+"File/SetEnable.xml";
//				URL url = new URL(SOAPUrl);
//				URLConnection connection = url.openConnection();
//				 httpConn = (HttpURLConnection) connection;
//				FileInputStream fin = new FileInputStream(xmlFile2Send);
//				ByteArrayOutputStream bout = new ByteArrayOutputStream();
//				copy(fin, bout);
//				fin.close();
//				byte[] b = bout.toByteArray();
//				httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//				httpConn.setRequestProperty("Cache-Control", "no-cache");
//				httpConn.setRequestProperty("Pragma", "no-cache");
//				httpConn.setRequestProperty("SOAPAction", s);
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.connect();
//				OutputStream out = httpConn.getOutputStream();
//				out.write(b);
//				out.close();
//		}else{
				String key;
				String value;
				String body;
				StringBuffer xml=new StringBuffer();
				System.out.println("Arguments:"+s);
				System.out.println("SoapUrl:"+SOAPUrl);
				String params=inputParams;
				System.out.println("input params:"+params);
				if(!(params.equals(""))){
					System.out.println("1111");
					String [] keyvalue = params.split(";");
					xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
					xml.append("<SOAP-ENV:Envelope \r\n");
					xml.append("xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n");
					xml.append("xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" \r\n");
					xml.append("xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\">\r\n");
					xml.append("<SOAP-ENV:Body>\r\n");
					xml.append("<"+APIname+">\r\n");
					for (int i = 0; i < keyvalue.length; i++) {
						String [] zoo = keyvalue[i].split(",");
					    key=zoo[0];
						value=zoo[1];
						if(value.equals(" ")){
							value="";
						}
						System.out.println("key:"+key);
						System.out.println("value:"+value);
						xml.append("<"+key+" xsi:type=\"xsd:string\" xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\">"+value+"</"+key+">\r\n");
					}
					xml.append("</"+APIname+">\r\n");
					xml.append("</SOAP-ENV:Body>\r\n");
					xml.append("</SOAP-ENV:Envelope>\r\n");
					body=xml.toString();
					System.out.println("body:"+body);
				}else{
					System.out.println("2222");
					xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
					xml.append("<SOAP-ENV:Envelope \r\n");
					xml.append("xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n");
					xml.append("xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" \r\n");
					xml.append("xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\">\r\n");
					xml.append("<SOAP-ENV:Body>\r\n");
					xml.append("<"+APIname+">\r\n");
					xml.append("</"+APIname+">\r\n");
					xml.append("</SOAP-ENV:Body>\r\n");
					xml.append("</SOAP-ENV:Envelope>\r\n");
//					xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
//					xml.append("<SOAP-ENV:Envelope \r\n");
//					xml.append("xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n");
//					xml.append("xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" \r\n");
//					xml.append("xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\">\r\n");
//					xml.append("<SOAP-ENV:Body>\r\n");
//					xml.append("<M1:"+APIname+" xmlns:M1=\""+s+">\r\n");
//					xml.append("</M1:"+APIname+">\r\n");
//					xml.append("</SOAP-ENV:Body>\r\n");
//					xml.append("</SOAP-ENV:Envelope>\r\n");
					body=xml.toString();
					System.out.println("body:"+body);
				}
				
				URL url = new URL(SOAPUrl);
				URLConnection connection = url.openConnection();
				httpConn = (HttpURLConnection) connection;
				httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
				httpConn.setRequestProperty("Cache-Control", "no-cache");
				httpConn.setRequestProperty("Pragma", "no-cache");
				httpConn.setRequestProperty("SOAPAction", s);
				httpConn.setRequestMethod("POST");
				httpConn.setDoOutput(true);
				httpConn.setDoInput(true);
				httpConn.connect();
				PrintWriter ouputstream = new PrintWriter(httpConn.getOutputStream());
				ouputstream.write(body);
				ouputstream.flush();
				
//			}	
				
			
			InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
			in = new BufferedReader(isr);
			String inputLine;
			StringBuffer sb = new StringBuffer();
			while ((inputLine = in.readLine()) != null){
			sb.append(inputLine+"\n");
			}
			return sb.toString();
			   
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

//	public static String localRun(String s){//获取本地数据(WNR3500Lv2)
//		BufferedReader in = null;
//		try {
//			String SOAPUrl = "http://routerlogin.net/soap/server_sa/";
//			String xmlFile2Send =getRoot()+"File/weattherreq.xml";
//			URL url = new URL(SOAPUrl);
//			URLConnection connection = url.openConnection();
//			HttpURLConnection httpConn = (HttpURLConnection) connection;
//			FileInputStream fin = new FileInputStream(xmlFile2Send);
//			ByteArrayOutputStream bout = new ByteArrayOutputStream();
//			copy(fin, bout);
//			fin.close();
//			byte[] b = bout.toByteArray();
//			httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
//			httpConn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
//			httpConn.setRequestProperty("SOAPAction", s);
//			httpConn.setRequestMethod("POST");
//			httpConn.setDoOutput(true);
//			httpConn.setDoInput(true);
//			httpConn.connect();
//			OutputStream out = httpConn.getOutputStream();
//			out.write(b);
//			out.close();
//			InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
//			in = new BufferedReader(isr);
//			String inputLine;
//			StringBuffer sb = new StringBuffer();
//			while ((inputLine = in.readLine()) != null){
//			sb.append(inputLine+"\n");
//			}
//			return sb.toString();
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				in.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
	
	
	
	public static String remoteRun(String a,String fcml){//请求远程验证并获得sessionId为进行数据交互即会话做准备(WNR3500Lv2)
		URL url;
		String result=null;
		String sessionId="";
		try {
			url = new URL("https://genie.netgear.com/fcp/authenticate");
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			httpConn.setDoOutput(true);// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在 http正文内，因此需要设为true, 默认情况下是false;   
			httpConn.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;  
			PrintWriter ouputstream = new PrintWriter(httpConn.getOutputStream());
			String body = "<authenticate type=\"basic\" username=\"siteviewgenietest@gmail.com\" password=\"siteview\"/>";
		    ouputstream.write(body);//写入字符串
		    ouputstream.flush();
		    httpConn.connect();
		    String cookieVal = null;
			String key=null;
			     for (int i = 1; (key = httpConn.getHeaderFieldKey(i)) != null; i++ ) {
			               if (key.equalsIgnoreCase("set-cookie")) {
			                cookieVal = httpConn.getHeaderField(i);
			                cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
			                sessionId=sessionId+cookieVal+";";
			               }
			            }
			System.out.println("sessionId:"+sessionId);
			if(sessionId!=null){
				result = RemoteConnectionRun(sessionId, a, fcml);
			}
		    InputStream inputstream= httpConn.getInputStream();
		    byte[] b = new byte[1024*100];
		    int len=0;
		    int temp=0;
		    while((temp=inputstream.read())!=-1){
		    	b[len] = (byte)temp;
		    	len++;
		    }
		   return result+sessionId;
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return null;
	}
	public static String RemoteConnectionRun(String sessionId,String a,String fcml){//获得sessionId后进行数据交互即会话(WNR3500Lv2)
		URL url;
		String result=null;
		try {
			url = new URL("https://genie.netgear.com/fcp/"+a);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setRequestProperty("Cookie", sessionId);
			PrintWriter ouputstream = new PrintWriter(httpConn.getOutputStream());
			String body = fcml;
		    ouputstream.write(body);
		    ouputstream.flush();
		    httpConn.connect();
		    InputStream inputstream= httpConn.getInputStream();
		    byte[] b = new byte[1024*100];
		    int len=0;
		    int temp=0;
		    while((temp=inputstream.read())!=-1){
		    	b[len] = (byte)temp;
		    	len++;
		    }
		   result=new String(b,0,len);
		   //System.out.println(result);
		   return result;
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return null;
	}
	
	
	
	
	//CallView
	public static void connection(String a,Map<String,String> map){//连接到远程 (WNR3500Lv2)
		URL url;
		try {
			url = new URL("https://genie.netgear.com/fcp/"+a);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			PrintWriter ouputstream = new PrintWriter(httpConn.getOutputStream());
			
			StringBuffer str = new StringBuffer("<"+a);
			
			Set set = map.keySet();
			for(Iterator it = set.iterator(); it.hasNext();){
				String key = (String)it.next();
				String value =  map.get(key);
				str.append(" "+key+"=\""+value+"\"");
			}
			str.append("/>");
			String body = str.toString();
		    ouputstream.write(body);
		    ouputstream.flush();
		    httpConn.connect();
		    InputStream inputstream= httpConn.getInputStream();
		    byte[] b = new byte[1024*100];
		    int len=0;
		    int temp=0;
		    while((temp=inputstream.read())!=-1){
		    	b[len] = (byte)temp;
		    	len++;
		    }
		    System.out.println(new String(b,0,len));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
	}
	public static final String PLUGIN_ID = "Genie";
	public static String getRoot(){
		  String path=null;
		  try {
		    path = FileLocator.toFileURL(
		    Platform.getBundle(PLUGIN_ID).getEntry("")).getPath();
		    path = path.substring(path.indexOf("/") + 1, path.length());
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  return path;
		} 
	
}
