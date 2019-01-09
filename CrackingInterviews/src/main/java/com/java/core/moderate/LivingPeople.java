package com.java.core.moderate;

public class LivingPeople {
	public static int maxAlive(Person[] people, int min, int max) {
		int[] populationDeltas = getDeltas(people, min, max);
		int maxAliveYear = findMaxAliveYear(populationDeltas);
		return maxAliveYear + min;
	}

	private static int[] getDeltas(Person[] people, int min, int max) {
		int[] deltas = new int[max - min + 2];
		for (Person person : people) {
			deltas[person.birth - min]++;
			deltas[person.death + 1 - min]--; // We consider him/her alive on
												// death year
		}
		return deltas;
	}

	private static int findMaxAliveYear(int[] deltas) {
		int alive = 0;
		int maxAlive = 0;
		int maxYear = 0;
		for (int i = 0; i < deltas.length; i++) {
			alive += deltas[i];
			if (alive > maxAlive) {
				maxAlive = alive;
				maxYear = i;
			}
		}
		return maxYear;
	}
	public static void main(String[] args) {
		System.out.println("*** Test 16.10: Living People\n");
		Person[] people = new Person[4];
		people[0] = new Person(1943, 1988);
		people[1] = new Person(1923, 1999);
		people[2] = new Person(1903, 1958);
		people[3] = new Person(1920, 1979);
		test(people, 1900, 2017);
	}
	
	private static void test(Person[] people, int startDate, int endDate) {
		int max = LivingPeople.maxAlive(people, startDate, endDate);
		System.out.println("Max alive year: " + max);
	}
}

class Person {
	int birth;
	int death;

	Person(int birth, int death) {
		this.birth = birth;
		this.death = death;
	}
}