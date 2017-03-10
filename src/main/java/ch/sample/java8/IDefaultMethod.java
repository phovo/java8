package ch.sample.java8;

public interface IDefaultMethod {
	double caculate(int a);
	default double sqrt(int a) {
		System.out.println("sqrt-------------------");
		System.out.println(Math.sqrt(a));
		return Math.sqrt(a);
	}
}
