
public class Practice7Test {
	
	
	public Practice7Test() {
	}
	
	protected boolean emptyInitialTest() {
		try {
			List list = new ArrayList();
			if (list.size() == 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected boolean basicStoreRemoveTest() {
		// Obvious, I think...
		String sample = "Hello world!";
		
		try {
			List list = new ArrayList();
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
	
	protected boolean storeManyTest() {
		// Milan Kundera
		String[] work = {"The Joke", "Life is Elsewhere",
				"The Book of Laughter and Forgetting", "The Unbearable Lightness of Being",
				"Immortality", "The Festival of Insignificance"};

		try {
			List list = new ArrayList();
			
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
	
	protected boolean increaseCapacityTest() {
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
			List list = new ArrayList();
			
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
	
	protected long timingTest() {
		long start = System.currentTimeMillis();

		try {
			List list = new ArrayList();
			for (int i = 0; i < 5000; i++) {
				if (i % 10 == 0 && list.size() > 0) {
					list.remove(0);
				} else {
					list.add(Integer.MAX_VALUE);
				}
			}
		} catch (Exception e) {
			return Long.MAX_VALUE;
		}
		return System.currentTimeMillis() - start;
	}
	
	public void runTest () {
		int grade = 0;
		
		if (emptyInitialTest()) {
			grade += 10;
			System.out.println("[+10%] Passed empty original container test");
		} else {
			System.out.println("[    ] Failed empty original container test");
		}
		
		if (basicStoreRemoveTest()) {
			grade += 20;
			System.out.println("[+20%] Passed basic store/remove test");
		} else {
			System.out.println("[    ] Failed basic store/remove test");
		}
		
		if (storeManyTest()) {
			grade += 40;
			System.out.println("[+40%] Passed multiple store/retrieve/remove test");
		} else {
			System.out.println("[    ] Failed multiple store/retrieve/remove test");
		}
		
		if (increaseCapacityTest()) {
			grade += 20;
			System.out.println("[+20%] Passed increase capacity test");
		} else {
			System.out.println("[    ] Failed increase capacity test");
		}
		
		long time = timingTest();
		if (time < 200) {
			grade += 10;
			System.out.println("[+10%] Passed timing test in " + time + "ms.");
		} else {
			System.out.println("[    ] Failed timing test -- took " + time + "ms. (Should be less than 200ms.)");
		}
		
		System.out.println("Grade for this assignment: " + grade + "%");
	}

	
	public static void main(String[] args) {
		Practice7Test test = new Practice7Test();
		test.runTest();
	}
	
}
