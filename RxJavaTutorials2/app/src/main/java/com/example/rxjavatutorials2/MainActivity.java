package com.example.rxjavatutorials2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subscribers.ResourceSubscriber;

public class MainActivity extends AppCompatActivity {

    Button button;

    TextView textView;

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*
                Single Observable : Always emit only one value or throw an exception
                The Single Observer always emits only once so there are no OnNext() method
                 */
                Single<String>  stringSingle = getStringSingle();
                stringSingle.observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull String s) {
                      Log.d("Name",s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("Error","Error"+e.getMessage());
                    }
                });
                /*
                Maybe is an Observable that may or may not emit the value.
                 */

                Maybe<String> stringMaybe = getStringMaybe();

                stringMaybe.observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new MaybeObserver<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull String s) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


                /*
                Cold Observable : If you create an Observable based on a static range of element
                from 1 to 1 Millions , that observable would emit the same sequences of items no
                matter how frequently those items are observed.

                Cold observable is providing item in lazy way

                Cold Observable bs hme data Sequence order me dega chaye kitna bhi data Observable
                bhej de. Koi farak nhi padega..

                Refer following example...
                 */

                Observable.range(1,1000).observeOn(Schedulers.io()).subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                       Log.d("Integer",""+integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                       Log.d("error",""+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("Complete","done");
                    }
                });

                /*
                Another way to make Cold Observable
                 */

                Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {

                        for(int i=0; i<1000; i++){

                            emitter.onNext(i);
                        }
                        emitter.onComplete();
                    }
                });

                observable.observeOn(Schedulers.io()).subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.d("Integer",""+integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("error",""+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("Complete","done");
                    }
                });


                /*
                Hot Observable : Hot Observable emits data on its own Pace. And it is up to the Observer
                to keep it up.

                when the Observer is not able to Consume item as quickly they produce by Observable need to be
                buffered or handled in some other way as they will fill us memory causing out of
                 Memory Exeception.

                 Mainly some of task get Skipped.

                 */

                Observable<Integer>  observable1 = PublishSubject.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                        for(int i=0; i<1000; i++){

                            emitter.onNext(i);
                        }
                        emitter.onComplete();
                    }
                });

            /*    observable1.observeOn(Schedulers.io()).subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.d("Integer",""+integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("error",""+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("Complete","done");
                    }
                });

             */

                /*

                FlowAble Observable : FlowAble allows you to process items that emitted faster from
                the source than some of the following step can handle.

                FlowAble Comes into Picture when there is a case when Observable is Emitting huge Number
                of Value which can't be consumed by Observer.

                Assume that you have source that can emit a million per second. However Use those item
                to do network Request

                we use Flowable boz when the Observable emmitted the data at a extreme speed the Observer
                can't catch it. so that is issue with Simple Observable so we need back Pressure.
                 */


                observable1.toFlowable(BackpressureStrategy.BUFFER).onBackpressureBuffer(1000).observeOn(Schedulers.io())
                        .subscribe(new ResourceSubscriber<Integer>() {
                            @Override
                            public void onNext(@NonNull Integer integer) {
                                Log.d("Integer",""+integer);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.d("error",""+e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                Log.d("Complete","done");
                            }
                        });



               /*
               Observable: Observable are nothing nut a data Stream. Observable pack the data that can
               pass around a one thread to another thread. They basically emit the data periodically
               only once in a life cycle based on there configuration.

               Mtlb Observable jo hai vo data ko Collect kr ke bhejta hai Stream ki tarah ek thread se
               dusre thread me.

               Observer : Observer consume the dataStream emitted by the Observable. Observer
               subscribe to the Observable using subscribeOn() method. And Receive data emitted by
               Observable..

               Mtlb Observer ka Kaam Hai jo bhi data Stream Observable ke dwara bheja gya hai usea
               accept krna..

               */

                Observable<String> booknameObservable = getBookNameObservable();

                Observer<String> booknameObserver =getBookNameObserver();

                booknameObservable.observeOn(Schedulers.io()).
                        subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(booknameObserver);
            }
        });


    }

    private Maybe<String> getStringMaybe() {

        return Maybe.just("Java");
    }

    private Single<String> getStringSingle() {

        return Single.just("Sohil");
    }

    // Recieve data by Subscriber

    private Observer<String> getBookNameObserver() {

        return new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("main","Disposable");
                disposable = d;

            }

            @Override
            public void onNext(@NonNull String s) {

                Log.d("main",s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

               Log.d("main","Error"+e.getMessage());
            }

            @Override
            public void onComplete() {

             Log.d("main","Completed");

            }
        };
    }

    private Observable<String> getBookNameObservable() {

        return Observable.just("c,","c++","java","Android");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        disposable.dispose();
    }
}