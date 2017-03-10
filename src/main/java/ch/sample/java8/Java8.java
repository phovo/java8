package ch.sample.java8;



public class Java8 {
	public static void main(String[] args) {
		ForeEachSample.forEach();
		DefaultMethods.instance.sqrt(5);
		Lambda.lambda();

		StreamSample.sequentialStream();
		StreamSample.parallelStream();
		StreamSample.sampleStream();
		ConcurrencyAPI.concurrencyAPI();
	}
}

