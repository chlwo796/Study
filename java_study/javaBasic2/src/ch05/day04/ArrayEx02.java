package ch05.day04;

public class ArrayEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Banchan b1 = new Banchan();
//		Banchan b2 = new Banchan();
//		Banchan b3 = new Banchan();
//		
//		Banchan[] banArr = {b1, b2, b3};

//		���� �ڵ���� ��ģ �ڵ�(��ü������ ���ÿ� �迭�ּҿ� �ٷ� �ִ´�)
		Banchan[] banArr = { new Banchan(), new Banchan(), new Banchan() };
		System.out.println(banArr[0]); // ù��°(0) Banchan ��ü�� �ּ�
		System.out.println(banArr[1]); // �ι�°(1) Banchan ��ü�� �ּ�
		System.out.println(banArr[2]); // ����°(2) Banchan ��ü�� �ּ�

//		0�� �ּҿ� ������ 10,5 �Է��غ���
		banArr[0].setKind("������");
		banArr[0].setMakeFood(10);
		banArr[0].setSaleFood(5);

		System.out.println(banArr[0].getKind());
		System.out.println(banArr[0].getMakeFood());
		System.out.println(banArr[0].getSaleFood());

//		[1]�ּҿ� ���� 7,3
		banArr[1].setKind("����");
		banArr[1].setMakeFood(7);
		banArr[1].setSaleFood(3);

		System.out.println(banArr[1].getKind());
		System.out.println(banArr[1].getMakeFood());
		System.out.println(banArr[1].getSaleFood());

//		[2]�ּҿ� ������� 15 13
		banArr[2].setKind("�������");
		banArr[2].setMakeFood(15);
		banArr[2].setSaleFood(13);

		System.out.println(banArr[2].getKind());
		System.out.println(banArr[2].getMakeFood());
		System.out.println(banArr[2].getSaleFood());

//		����1. Ŭ���� Hospital ���� Ŭ������ �����
//		�ʵ�� ������� - ġ��, ����, �����ܰ�, �������а�
//		�ǻ�� - �����, ������, �ڸ�ȣ, �����
//		������ - 20230117, 20230116, 20230112, 20230110
//		����� ������

		Hospital[] hs = { new Hospital(), new Hospital(), new Hospital(), new Hospital() };

		System.out.println("�������\t�ǻ��\t������");

		hs[0].setMedicalDep("ġ��");
		hs[0].setDoctorName("�����");
		hs[0].setTreatmentDay("20230117");

		hs[1].setMedicalDep("����");
		hs[1].setDoctorName("������");
		hs[1].setTreatmentDay("20230116");

		hs[2].setMedicalDep("�����ܰ�");
		hs[2].setDoctorName("�ڸ�ȣ");
		hs[2].setTreatmentDay("20230112");

		hs[3].setMedicalDep("�������а�");
		hs[3].setDoctorName("�����");
		hs[3].setTreatmentDay("20230110");

		System.out.println(hs[0].getMedicalDep() + "\t" + hs[0].getDoctorName() + "\t" + hs[0].getTreatmentDay());
		System.out.println(hs[1].getMedicalDep() + "\t" + hs[1].getDoctorName() + "\t" + hs[1].getTreatmentDay());
		System.out.println(hs[2].getMedicalDep() + "\t" + hs[2].getDoctorName() + "\t" + hs[2].getTreatmentDay());
		System.out.println(hs[3].getMedicalDep() + "\t" + hs[3].getDoctorName() + "\t" + hs[3].getTreatmentDay());
		
//		�ݺ����� Ȱ���ϴ� ���� �ξ� �����ϴ�.
		for(Hospital i : hs) {
			System.out.println(i.getMedicalDep() + "\t" + i.getDoctorName() + "\t" + i.getTreatmentDay());
		}
	}

}

class Banchan {
	String kind;
	int makeFood;
	int saleFood;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getMakeFood() {
		return makeFood;
	}

	public void setMakeFood(int makeFood) {
		this.makeFood = makeFood;
	}

	public int getSaleFood() {
		return saleFood;
	}

	public void setSaleFood(int saleFood) {
		this.saleFood = saleFood;
	}
}

class Hospital {
	String medicalDep;
	String doctorName;
	String treatmentDay;

	public String getMedicalDep() {
		return medicalDep;
	}

	public void setMedicalDep(String medicalDep) {
		this.medicalDep = medicalDep;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getTreatmentDay() {
		return treatmentDay;
	}

	public void setTreatmentDay(String treatmentDay) {
		this.treatmentDay = treatmentDay;
	}
}