package com.donbest.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> evenNumber = numbers.stream().filter((Integer number) -> {
			return number % 2 == 0;
		}).collect(Collectors.toList());
		System.out.println(evenNumber);

		numbers = Arrays.asList(1, 2, 3, 4, 5);
		Integer result = numbers.stream().map(number -> number * number).reduce(1, (acc, element) -> acc * element);
		System.out.println(result);
		
		IntStream.range(0, 10).forEach(System.out::println);

	}

}
