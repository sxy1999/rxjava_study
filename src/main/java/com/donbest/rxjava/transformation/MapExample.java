package com.donbest.rxjava.transformation;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

public class MapExample {

	public static void main(String[] args) throws InterruptedException {
		// Observable.from(DataGenerator.generateGrrekAlphabet())
		// .map((letterString) -> {
		// return letterString.toUpperCase();
		// })
		// .subscribe((letterString) -> {
		// System.out.println(letterString);
		// });

		ConnectableObservable<Long> obs = Observable.interval(100, TimeUnit.MILLISECONDS).publish();

		obs.observeOn(Schedulers.computation()).subscribe((seq) -> {
			System.out.println("current thread=" + Thread.currentThread().getName() + ", s1.seq=" + seq);
		});

		obs.observeOn(Schedulers.computation()).subscribe((seq) -> {
			System.out.println("current thread=" + Thread.currentThread().getName() + ", s2.seq=" + seq);
		});

		Thread.sleep(3000);
		System.out.println("Connecting...");

		obs.connect();

		Thread.sleep(5000);

		// System.out.println("---------------------------------------------------------------");
		//
		// Observable.from(DataGenerator.generateGrrekAlphabet())
		// .flatMap((letterString) -> {
		// String[] returnStrings = { letterString.toUpperCase(), letterString.toLowerCase() };
		// return Observable.from(returnStrings);
		// })
		// .subscribe((letterString) -> {
		// System.out.println(letterString);
		// });
	}

}
