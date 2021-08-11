package com.example.rxjavatutorials2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Button button;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Observable<String> booknameObservable = getBookNameObservable();

                Observer<String> booknameObserver =getBookNameObserver();

                booknameObservable.observeOn(Schedulers.io()).
                        subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(booknameObserver);
            }
        });


    }

    // Recieve data by Subscriber

    private Observer<String> getBookNameObserver() {

        return new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

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
}