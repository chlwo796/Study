package ch05.day04;

public class ArrayEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Banchan b1 = new Banchan();
//		Banchan b2 = new Banchan();
//		Banchan b3 = new Banchan();
//		
//		Banchan[] banArr = {b1, b2, b3};

//		위의 코드들을 합친 코드(객체생성과 동시에 배열주소에 바로 넣는다)
		Banchan[] banArr = { new Banchan(), new Banchan(), new Banchan() };
		System.out.println(banArr[0]); // 첫번째(0) Banchan 객체의 주소
		System.out.println(banArr[1]); // 두번째(1) Banchan 객체의 주소
		System.out.println(banArr[2]); // 세번째(2) Banchan 객체의 주소

//		0열 주소에 조림류 10,5 입력해보기
		banArr[0].setKind("조림류");
		banArr[0].setMakeFood(10);
		banArr[0].setSaleFood(5);

		System.out.println(banArr[0].getKind());
		System.out.println(banArr[0].getMakeFood());
		System.out.println(banArr[0].getSaleFood());

//		[1]주소에 국류 7,3
		banArr[1].setKind("국류");
		banArr[1].setMakeFood(7);
		banArr[1].setSaleFood(3);

		System.out.println(banArr[1].getKind());
		System.out.println(banArr[1].getMakeFood());
		System.out.println(banArr[1].getSaleFood());

//		[2]주소에 샐러드류 15 13
		banArr[2].setKind("샐러드류");
		banArr[2].setMakeFood(15);
		banArr[2].setSaleFood(13);

		System.out.println(banArr[2].getKind());
		System.out.println(banArr[2].getMakeFood());
		System.out.println(banArr[2].getSaleFood());

//		문제1. 클래스 Hospital 병원 클래스를 만들고
//		필드는 진료과목 - 치과, 내과, 정형외과, 통증의학과
//		의사명 - 김수영, 최진민, 박명호, 정경미
//		진료일 - 20230117, 20230116, 20230112, 20230110
//		입출력 만들어보기

		Hospital[] hs = { new Hospital(), new Hospital(), new Hospital(), new Hospital() };

		System.out.println("진료과목\t의사명\t진료일");

		hs[0].setMedicalDep("치과");
		hs[0].setDoctorName("김수영");
		hs[0].setTreatmentDay("20230117");

		hs[1].setMedicalDep("내과");
		hs[1].setDoctorName("최진민");
		hs[1].setTreatmentDay("20230116");

		hs[2].setMedicalDep("정형외과");
		hs[2].setDoctorName("박명호");
		hs[2].setTreatmentDay("20230112");

		hs[3].setMedicalDep("통증의학과");
		hs[3].setDoctorName("정경미");
		hs[3].setTreatmentDay("20230110");

		System.out.println(hs[0].getMedicalDep() + "\t" + hs[0].getDoctorName() + "\t" + hs[0].getTreatmentDay());
		System.out.println(hs[1].getMedicalDep() + "\t" + hs[1].getDoctorName() + "\t" + hs[1].getTreatmentDay());
		System.out.println(hs[2].getMedicalDep() + "\t" + hs[2].getDoctorName() + "\t" + hs[2].getTreatmentDay());
		System.out.println(hs[3].getMedicalDep() + "\t" + hs[3].getDoctorName() + "\t" + hs[3].getTreatmentDay());
		
//		반복문을 활용하는 것이 훨씬 용이하다.
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