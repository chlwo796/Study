package javaChap13.example05;

public class Applicant<T> {
	public T kind;

	public Applicant(T kind) {
		super();
		this.kind = kind;
	}
}
