import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

/**
 * This is not my code. It was provided to me as a way to test the time difference between
 * the self balancing tree and the normal one.
 */
public class ITimeMethods {

	private static final int DEFAULT_WARMUP_PASSES = 100;
	private static final int DEFAULT_PASSES = 1000;

	public static long timeComputation(Runnable computation) {
		return timeComputation(DEFAULT_PASSES, computation);
	}

	public static long timeComputation(int totalPasses, Runnable computation) {
		return timeComputation(DEFAULT_WARMUP_PASSES, totalPasses, computation);
	}
	// To propperly time code (microbenchmarking) you need serious profiling tools and this isn't one!
	// This method just measures how long it takes for a method to run in real life time but that
	// can be influened by a milion and one things from the garbage collector, what else runs in the
	// system, and decisions the VM takes at the time (The VM is not designed to be profiled like that!)
	// So the results of this can and likely will be different on successive runs
	// but it should at least give an indication of what is quicker than what.. xD 
	//
	// warmupPasses: Run the code a few times without measuring time, to make sure everything is loaded
	// 	and the VM has 'settled'.
	// totalPasses: Number of samples to take, long running methods require fewer than quick running ones!
	// computation: A runnable which when run performs the computation you want to time.
	//
	public static long timeComputation(int warmupPasses, int totalPasses, Runnable computation) {
		// Hijack the output and error streams (System.out and System.err)
		// We don't want them to do much, and printing to the screen may introduce
		// delays much larger than the execution time of the rest of the code in a
		// method and depended upon the operating system...
		// We temporarily disable them (i.e. discard anything they try to print)
		// and we will restore them when we finish our 'test'
		PrintStream outputRejectingStream = new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
			}
		});
		PrintStream out = System.out, err = System.err;
		System.setOut(outputRejectingStream);
		System.setErr(outputRejectingStream);

		// Warmup makes sure the computation has run a few times and the virutal machine
		// has loaded all classes it needs, filled up caches, etc. Not usually nessesary
		// to run many iterations
		while (warmupPasses-- > 0) {
			computation.run();
		}
		// Time to 'time' the computation.
		long startTime = System.nanoTime();
		for (int i = 0; i < totalPasses; i++) {
			computation.run();
		}

		long endTime = System.nanoTime();

		// Restore output and error streams
		System.setOut(out);
		System.setErr(err);
		//Result is the average execution time of a single call.
		return (endTime - startTime) / totalPasses;
	}

}
