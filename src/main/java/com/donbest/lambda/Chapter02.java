package com.donbest.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class Chapter02 {

	interface Mapper<V, M> {
		M map(V value);
	}
	
	public static <V, M> List<M> map(List<V> list, Mapper<V, M> mapper) {
		List<M> mappered = new ArrayList<M>(list.size());
		for(V v:list) {
			mappered.add(mapper.map(v));
		}
		
		return mappered;
	}
	
	public static void main(String[] args) {
		List<Integer> mapped=map(Arrays.asList(1,2,3,4,5,6,7,8,9), value -> value * value);
		
		Observable.from(mapped).subscribe(i -> {System.out.println(i);});
	}
}
