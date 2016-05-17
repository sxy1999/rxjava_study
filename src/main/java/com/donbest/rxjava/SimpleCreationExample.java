package com.donbest.rxjava;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class SimpleCreationExample {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		Observable<String> observable = Observable.from(list);
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
