import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

/**
 * A couple of <code>Observable</code> related tests.
 *
 * @author vision8
 */
public class ObservableTests {

    @Test
    void coldObservableWithJust() {

        Observable<String> stringObservable = Observable.just("One", "Two", "Three");
        // providing just the 'onNext' consumer
        stringObservable.subscribe(s -> System.out.println("Got: " + s));

    }

}
