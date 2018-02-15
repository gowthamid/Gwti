package test;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ProtrocolCheck {
	public static void main(String args[])
	{
		//byte[] ipAddr = new byte[]{10, 77, 34, (byte) 157};
		try {
			TrustManager[] trustManager;
			  trustManager = new TrustManager[] { new X509TrustManager() {  

				  public X509Certificate[] getAcceptedIssuers() {  
					  return null;  
				  }  

				  @Override
				  public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				  throws CertificateException {
					  //Accept all
				  }

				  @Override
				  public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				  throws CertificateException {
					  //Accept all
				  }  

			  } }; 
			InetAddress ip=InetAddress.getByName("10.77.34.157");
			//System.out.println(ip.getHostName()+" "+ip.getHostAddress()+" "+ip.getAddress());
			SSLContext ctx = SSLContext.getInstance("SSL");
			ctx.init(null, trustManager, null);
			SSLSocketFactory sf = ctx.getSocketFactory();
			
			SSLSocket ss = (SSLSocket) sf.createSocket(ip, 8443);
			
			String[] protocols=ss.getEnabledProtocols();
			for(String protocol:protocols)
				System.out.println(protocol);
			
			ss.close();
			
		} 
		catch(ConnectException e){
			//e.getMessage();
			e.printStackTrace();
				}
		catch (NoSuchAlgorithmException | IOException | KeyManagementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
	}
}
