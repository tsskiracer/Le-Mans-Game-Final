import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	private static Scanner davisIsAJerk = new Scanner(System.in);
	private static int numLaps;
	private static ArrayList<Car> players = new ArrayList<Car>();
	
	public static void main(String[] args) {
		Track.intializeTrack();
		startUp();
		race();
	}
	
	public static void startUp()
	{
		System.out.println("Hello and Welcome to the Game of Le Mans.");
		System.out.println("How many players will be playing today? (Up to 4)");
		int numPlayers=davisIsAJerk.nextInt();
		
		while(true)
		{
			
			if(numPlayers <= 0 || numPlayers >= 4)
				System.out.println("Please enter a valid number");
			else
				break;
		}
		System.out.println();
		System.out.println("And how many laps would you like to do?");
		numLaps=davisIsAJerk.nextInt();
		
		while(true)
		{
			
			if(numLaps <= 0)
				System.out.println("Please enter a valid number");
			else
				break;
		}
		System.out.println();
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(new P919H());
		cars.add(new F1Car());
		for (int i=0; i<numPlayers; i++)
			{
				System.out.println("Player " + (i + 1) + ". CHOOSE YOUR CAR!");
				int x = 1;
				for (Car car : cars) {
					System.out.println(x + ". " + car);
					x++;
				}
				int choice;
				while(true)
				{
					choice = davisIsAJerk.nextInt() - 1;
					if(choice < 0 || choice >= (x))
						System.out.println("Please enter a valid number");
					else
						break;
				}
				players.add(cars.get(choice));
				cars.remove(choice);
			}
	}
	
	public static void race()
	{
		boolean racing = true;
		Scanner userInput = new Scanner(System.in);
		while(racing) {
			for (Car car : players) {
				System.out.println(car);
				System.out.println("Press enter to race. ");
				userInput.nextLine();
				if(car.position >= 28 && car.position <= 38)
				{
					System.out.println("Would you like to pit? (Y or N)");
					if(davisIsAJerk.nextLine().toLowerCase().startsWith("y"))
					{
						car.pit();
						System.out.println("You went to the pits. ");
					}
					else
					{
						racing = moveCar(car);
						if(!racing)
							break;
					}
					
				}
				else if(car.position == 5 || car.position == 22 || car.position == 27)
				{
					car.applyUpgrades();
					moveCar(car);
				}
				else
				{
					racing = moveCar(car);
					if(!racing)
						break;
				}
				System.out.println("\n");
			}
		}
	}
	
	public static boolean moveCar(Car car)
	{
		car.race();
		System.out.println(car);
		if(car.getLaps() >= numLaps)
		{
			System.out.println(car + " wins the race! ");
			return false;
		}
		else
			return true;
	}
}
