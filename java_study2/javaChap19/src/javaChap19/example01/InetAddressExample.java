package javaChap19.example01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("郴哪腔磐 IP林家 : " + local.getHostAddress());

		InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ia : iaArr) {
			System.out.println("www.naver.com IP 林家 : " + ia.getHostAddress());
		}
	}
}
