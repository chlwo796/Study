package ch03.sec09;

public class BitShiftExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int value = 772;
		
		byte byte1 = (byte) (value >>> 24);		// 24bit = 3byte
		int int1 = byte1 & 255;					
		System.out.println("ù ��° ����Ʈ ��ȣ ���� ��: " + int1);	// ���� 1byte(8bit)�� ����. �տ� 2byte�� �� [00000000]�̱� ����.
		
		byte byte2 = (byte) (value >>> 16);
		int int2 = Byte.toUnsignedInt(byte2);
		System.out.println("�� ��° ����Ʈ ��ȣ ���� ��: " + int2);	// ���� 1byte(8bit)�� ����. �տ� 2byte�� �� [00000000]�̱� ����.
		
		byte byte3 = (byte) (value >>>8);
		int int3 = byte3 & 255;
		System.out.println("�� ��° ����Ʈ ��ȣ ���� ��: " + int3);	// ���� 1byte(8bit)�� ����. �տ� 2byte�� �� [00000000]�̱� ����.
		
		byte byte4 = (byte) value;
		int int4 = Byte.toUnsignedInt(byte4);
		System.out.println("�� ��° ����Ʈ ��ȣ ���� ��: " + int4);	// ���� 1byte(8bit)�� ����. �տ� 2byte�� �� [00000000]�̱� ����.

	}

}
