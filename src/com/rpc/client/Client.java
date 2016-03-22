package com.rpc.client;

import java.net.URL;
import java.util.*;
import com.rpc.utils.*;

//import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
//import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL("http://localhost:8080/XML-Json_RPC_Dynamic_ver/xmlRpc"));
			config.setBasicUserName(Strings.userName);
			config.setBasicPassword(Strings.password);
		//config.setBasicEncoding();
			XmlRpcClient client = new XmlRpcClient();
			
			//client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
			client.setConfig(config);
			
			Vector<Integer> params = new Vector<Integer>();

			params.addElement(new Integer(17));
			params.addElement(new Integer(13));

			Object result = client.execute("calc.sum", params);

			int sum = ((Integer) result).intValue();
			System.out.println("The sum is: "+ sum);

		} catch (Exception exception) {
			System.err.println("Client: " + exception);
		}

	}

}
