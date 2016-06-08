package com.donbest.rxjava.composition;

import rx.Observable;
import rx.schedulers.Schedulers;

public class CompositionExample {

	public static void main(String[] args) throws InterruptedException {
		Object waitMonitor = new Object();

		synchronized (waitMonitor) {
			UserService userService = new UserService();
			
			System.out.println("{ \"userList\" : [ ");
			
			Observable.from(userService.fetchUserList())
				.filter((user) -> {
					return user.getSecurityStatus() != UserSecurityStatus.ADMINISTRATOR;
				})
				.toSortedList((user1, user2) -> {
					return user1.getSecurityStatus().compareTo(user2.getSecurityStatus());
				})
				.subscribeOn(Schedulers.io())
				.doOnCompleted(() -> {
					synchronized (waitMonitor) {
						waitMonitor.notifyAll();
					}
				})
				.subscribe((userList) -> {
					userList.forEach((user) -> {
						System.out.println(user.toJSON());
					});
				});
			waitMonitor.wait();
			
			System.out.println("] }");
		}
		System.exit(0);
	}

}
