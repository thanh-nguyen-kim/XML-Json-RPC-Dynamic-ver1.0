/**
 * 
 */
package com.rpc.server;

//import java.util.Set;
import com.rpc.utils.*;
//import javax.servlet.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.jabsorb.JSONRPCBridge;
//import org.jabsorb.*;
/**
 * @author Thanh
 *
 */
public class JsonRPCListener implements ServletContextListener{

//	public JsonRPCListener() {
//		
//		// TODO Auto-generated constructor stub
//	}
	
	@Override
	public void contextInitialized(ServletContextEvent event){
		Utils CalcJson =new Utils();
		JSONRPCBridge globalBridge=JSONRPCBridge.getGlobalBridge();
		globalBridge.registerObject("CalcJson", CalcJson);
		//System.out.println("Init Calc");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
