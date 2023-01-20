package ch03.sec09;

public class BitShiftExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int value = 772;
		
		byte byte1 = (byte) (value >>> 24);		// 24bit = 3byte
		int int1 = byte1 & 255;					
		System.out.println("첫 번째 바이트 부호 없는 값: " + int1);	// 끝에 1byte(8bit)만 읽음. 앞에 2byte는 다 [00000000]이기 때문.
		
		byte byte2 = (byte) (value >>> 16);
		int int2 = Byte.toUnsignedInt(byte2);
		System.out.println("두 번째 바이트 부호 없는 값: " + int2);	// 끝에 1byte(8bit)만 읽음. 앞에 2byte는 다 [00000000]이기 때문.
		
		byte byte3 = (byte) (value >>>8);
		int int3 = byte3 & 255;
		System.out.println("세 번째 바이트 부호 없는 값: " + int3);	// 끝에 1byte(8bit)만 읽음. 앞에 2byte는 다 [00000000]이기 때문.
		
		byte byte4 = (byte) value;
		int int4 = Byte.toUnsignedInt(byte4);
		System.out.println("네 번째 바이트 부호 없는 값: " + int4);	// 끝에 1byte(8bit)만 읽음. 앞에 2byte는 다 [00000000]이기 때문.

	}

}
