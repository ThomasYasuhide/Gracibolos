package br.com.gracibolos.jdbc.teste;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class enderecoIp {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("IP : "+ip.getHostAddress());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
