package com.donbest.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public class SimpleCreationExample {

	public static void main(String[] args) {

//		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
//		Observable<String> observable = Observable.from(list);
		Observable<String> obs=Observable.just("Hello world!");
		obs.subscribe(s -> System.out.println(s));
		Observable<String> observable= Observable.create(new Observable.OnSubscribe<String>() {

			@Override
			public void call(Subscriber<? super String> sub) {
				sub.onNext("Hello Wolrd!");
				sub.onCompleted();
			}
		});
		observable.subscribe(new Action1<String>() {
			@Override
			public void call(String text) {
				System.out.println(text);

			}
		}, new Action1<Throwable>() {
			@Override
			public void call(Throwable t) {
				System.err.println(t);
			}
		}, new Action0() {
			@Override
			public void call() {
				System.out.println("We've finished.");
			}
		});
	}
}
