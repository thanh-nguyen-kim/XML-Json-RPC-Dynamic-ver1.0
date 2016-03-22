package com.rpc.server;
//import java.io.IOException;
//import java.util.*;
//import com.rpc.utils.*;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.common.XmlRpcHttpRequestConfig;
import org.apache.xmlrpc.common.XmlRpcHttpRequestConfigImpl;
import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.XmlRpcServlet;

import com.rpc.utils.*;
//import com.sun.rowset.internal.XmlErrorHandler;
public class RPCServlet extends XmlRpcServlet{
	private boolean isAuthenticated(String username,String pass){
		System.out.println(username+"  "+pass);
		return (username.equals(Strings.userName))&&(pass.equals(Strings.password));
	}
	protected XmlRpcHandlerMapping newXmlRpcHandlerMapping() throws XmlRpcException{
		PropertyHandlerMapping mapping=(PropertyHandlerMapping) super.newXmlRpcHandlerMapping();
		AbstractReflectiveHandlerMapping.AuthenticationHandler handler =
				new AbstractReflectiveHandlerMapping.AuthenticationHandler(){
			public boolean isAuthorized(XmlRpcRequest pRequest){
				XmlRpcHttpRequestConfig config =
						(XmlRpcHttpRequestConfigImpl) pRequest.getConfig();
				return isAuthenticated(config.getBasicUserName(),
						config.getBasicPassword());
			};
		};
		mapping.setAuthenticationHandler(handler);
		return mapping;
	}
}
