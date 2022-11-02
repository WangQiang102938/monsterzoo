
public class Main {
	public static void main(String[] args) {

		Utils.Box.push("Game Start");

		Zoo zoo = new Zoo();
		zoo.addUser(new User("User1"));
		// zoo.addUser(new User("User2"));
		// zoo.addUser(new User("User3"));
		while (zoo.checkValid()) {
			zoo.run();
		}
		Utils.Box.pop("Game Over");

		Utils.Box.print("");

		Utils.Box.push("Result");
		zoo.printResult();
		Utils.Box.pop("");
	}
}
