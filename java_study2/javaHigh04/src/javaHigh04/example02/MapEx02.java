package javaHigh04.example02;

import java.util.HashMap;
import java.util.Map;

public class MapEx02 {

	public static void main(String[] args) {
		// ��ȭ��ȣ -> ����Ʈ, �ּ� ��ȸ

		Map<String, Data> shopMap = new HashMap<String, Data>();
		Shop shop1 = new Shop("1111", new Data(100, "�̻�1��"));
		Shop shop2 = new Shop("1234", new Data(80, "�̻�12��"));
		Shop shop3 = new Shop("2222", new Data(90, "�̻�3��"));
		Shop shop4 = new Shop("2345", new Data(100, "�̻�4��"));
		Shop shop5 = new Shop("3333", new Data(70, "�̻�5��"));
		
		shopMap.put(shop1.getPhone(), shop1.getData());
		shopMap.put(shop2.getPhone(), shop2.getData());
		shopMap.put(shop3.getPhone(), shop3.getData());
		shopMap.put(shop4.getPhone(), shop4.getData());
		shopMap.put(shop5.getPhone(), shop5.getData());
		
		System.out.println(shopMap.get(shop1.getPhone()));
		Data shop1Data = shopMap.get(shop1.getPhone());
		System.out.println("���� �ڵ��� ��ȣ " + shop1.getPhone());
		System.out.println("���� ����Ʈ " + shop1Data.getPoint());
		System.out.println("���� �ּ� " + shop1Data.getAddress());
		
		Data shop4Data = shopMap.get(shop4.getPhone());
		System.out.println("���� �ڵ��� ��ȣ " + shop4.getPhone());
		System.out.println("���� ����Ʈ " + shop4Data.getPoint());
		System.out.println("���� �ּ� " + shop4Data.getAddress());
	}

}