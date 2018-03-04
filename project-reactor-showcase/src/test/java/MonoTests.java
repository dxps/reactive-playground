import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

/**
 * @author vision8
 */
public class MonoTests {
	
	@Test
	void monoSimpleTest() {
		
		Mono.just("V")
				.log()
				.subscribe();
		
		// subscribe() is needed since without any
		// subscription the publisher won't do anything
		
		/*
		This will just printout the following lines:
		[DEBUG] (main) Using Console logging
		[ INFO] (main) | onSubscribe([Synchronous Fuseable] Operators.ScalarSubscription)
		[ INFO] (main) | request(unbounded)
		[ INFO] (main) | onNext(V)
		[ INFO] (main) | onComplete()
		*/
		
	}
	
	@Test
	void monoDoOnTest() {
		
		Mono.just("V")
				.log()
				.doOnSubscribe(subscription -> System.out.println(">>> Subscription: " + subscription))
				.doOnRequest(value -> System.out.println(">>> Request value: " + value))
				.doOnSuccess(s -> System.out.println(">>> Complete: " + s))
				// and subscribe with a simple consumer
				.subscribe(System.out::println);
	}
	
}
