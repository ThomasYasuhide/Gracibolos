package br.com.gracibolos.jdbc.teste;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EnderecoIp {
	
	
	
	public static void main(String[] args) {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("IP : "+ip.getHostAddress());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
