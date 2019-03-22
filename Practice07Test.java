
public class Practice07Test {
	
	
	public Practice07Test() {
	}
	
	protected boolean emptyInitialTest(List<String> list) {
		try {
			if (list.size() == 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected boolean basicStoreRemoveTest(List<String> list) {
		// Obvious, I think...
		String sample = "Hello world!";
		
		try {
			list.add(sample);
			if (list.get(0).equals(sample)) {
				list.remove(0);
				if (list.size() == 0) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected boolean storeManyTest(List<String> list) {
		// Milan Kundera
		String[] work = {"The Joke", "Life is Elsewhere",
				"The Book of Laughter and Forgetting", "The Unbearable Lightness of Being",
				"Immortality", "The Festival of Insignificance"};

		try {
			for (int i = 0; i < work.length; i++) {
				list.add(i, work[i]);
			}
			
			if (list.size() != work.length) {
				return false;
			}
			
			for (int i = work.length-1; i >= 0; i--) {
				if (! list.remove(i).equals(work[i]))
					return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected boolean increaseCapacityTest(List<String> list) {
		// https://en.wikipedia.org/wiki/BFI_list_of_the_50_films_you_should_see_by_the_age_of_14
		String [] movies = {"The Adventures of Robin Hood", "Au revoir les enfants",
				"Back to the Future", "Beauty and the Beast", "Bicycle Thieves",
				"Billy Elliot", "A Day at the Races", "E.T. the Extra-Terrestrial",
				"Edward Scissorhands", "Etre et Avoir", "Finding Nemo", "It's a Wonderful Life",
				"Jason and the Argonauts", "Kes", "The Kid", "King Kong", "Kirikou et la sorciere",
				"La Belle et la Bete", "Le Voyage dans la Lune", "The 400 Blows",
				"Monsieur Hulot's Holiday", "My Life as a Dog", "My Neighbour Totoro",
				"The Night of the Hunter", "Oliver Twist", "The Outsiders", "Pather Panchali",
				"Playtime", "The Princess Bride", "Rabbit-Proof Fence", "Raiders of the Lost Ark",
				"The Railway Children", "The Red Balloon", "Romeo + Juliet", "The Secret Garden",
				"Show Me Love", "Singin' in the Rain", "Snow White and the Seven Dwarfs",
				"Some Like It Hot", "The Spirit of the Beehive", "Spirited Away", "Star Wars",
				"To Kill a Mockingbird", "Toy Story", "Walkabout", "Whale Rider", 
				"Where Is the Friend's Home?", "Whistle Down the Wind", "The White Balloon",
				"The Wizard of Oz"};
		try {
			for (int i = 0; i < movies.length; i++) {
				list.add(i, movies[i]);
			}
			if (list.size() == movies.length && list.get(41).equals(movies[41])) {
				// First movie I saw!
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected long timingTest(List<Integer> list) {
		long start = System.currentTimeMillis();

		try {
			for (int i = 0; i < 5000; i++) {
				if (i % 10 == 0 && list.size() > 0) {
					list.remove(0);
				} else {
					list.add(Integer.MAX_VALUE);
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();  // Uncomment this line if you see errors in timing test.
			return Long.MAX_VALUE;
		}
		return System.currentTimeMillis() - start;
	}
	
	public void runTest () {
		int grade = 0;
		List<String> list;
		
		list = new ArrayList<String>();
		if (emptyInitialTest(list)) {
			grade += 5;
			System.out.println("[+ 5%] Passed empty original container test (ArrayList)");
		} else {
			System.out.println("[    ] Failed empty original container test (ArrayList)");
		}
		list = new LinkedList<String>();
		if (emptyInitialTest(list)) {
			grade += 5;
			System.out.println("[+ 5%] Passed empty original container test (LinkedList)");
		} else {
			System.out.println("[    ] Failed empty original container test (LinkedList)");
		}
		
		list = new ArrayList<String>();
		if (basicStoreRemoveTest(list)) {
			grade += 10;
			System.out.println("[+10%] Passed basic store/remove test (ArrayList)");
		} else {
			System.out.println("[    ] Failed basic store/remove test (ArrayList)");
		}
		list = new LinkedList<String>();
		if (basicStoreRemoveTest(list)) {
			grade += 10;
			System.out.println("[+10%] Passed basic store/remove test (LinkedList)");
		} else {
			System.out.println("[    ] Failed basic store/remove test (LinkedList)");
		}
		
		list = new ArrayList<String>();
		if (storeManyTest(list)) {
			grade += 20;
			System.out.println("[+20%] Passed multiple store/retrieve/remove test (ArrayList)");
		} else {
			System.out.println("[    ] Failed multiple store/retrieve/remove test (ArrayList)");
		}
		list = new LinkedList<String>();
		if (storeManyTest(list)) {
			grade += 20;
			System.out.println("[+20%] Passed multiple store/retrieve/remove test (LinkedList)");
		} else {
			System.out.println("[    ] Failed multiple store/retrieve/remove test (LinkedList)");
		}
		
		list = new ArrayList<String>();
		if (increaseCapacityTest(list)) {
			grade += 20;
			System.out.println("[+20%] Passed increase capacity test (ArrayList only)");
		} else {
			System.out.println("[    ] Failed increase capacity test (ArrayList only)");
		}
		
		List<Integer> timinglist = new ArrayList<Integer>();
		long time = timingTest(timinglist);
		if (time < 20) {
			grade += 5;
			System.out.println("[+ 5%] Passed ArrayList timing test in " + time + "ms.");
		} else if (time == Long.MAX_VALUE) {
			System.out.println("[    ] Failed timing test -- there's an Exception in the ArrayList implementation.");
		} else {
			System.out.println("[    ] Failed timing test for ArrayList -- took " + time + "ms. (Should be less than 200ms.)");
		}
		timinglist = new LinkedList<Integer>();
		time = timingTest(timinglist);
		if (time < 35) {
			grade += 5;
			System.out.println("[+ 5%] Passed LinkedList timing test in " + time + "ms.");
		} else if (time == Long.MAX_VALUE) {
			System.out.println("[    ] Failed timing test -- there's an Exception in the LinkedList implementation.");
		} else {
			System.out.println("[    ] Failed timing test for LinkedList -- took " + time + "ms. (Should be less than 200ms.)");
		}
		
		System.out.println("Grade for this assignment: " + grade + "%");
	}

	
	public static void main(String[] args) {
		Practice07Test test = new Practice07Test();
		test.runTest();
	}
	
}
