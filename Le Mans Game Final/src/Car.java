import java.util.Scanner;

public abstract class Car {
	protected String name;
	protected String[] vUp;
	protected int speed;
	protected int fuelAmt;
	protected int tireWear;
	protected int position;
	protected int laps;
	private Scanner davisIsAJerk = new Scanner(System.in);
	
	protected void applyUpgrades()
	{
		System.out.println("Which upgrade would you like to apply? ");
		int x = 1;
		for (String string : vUp)
		{
			System.out.println(x + ". " + string);
			x++;
		}
		int choice;
		while(true)
		{
			choice = davisIsAJerk.nextInt() - 1;
			if(choice < 0 || choice >= vUp.length)
				System.out.println("Please enter a valid number");
			else
				break;
		}
		System.out.println(vUp[choice] + " was applied. ");
		speed += (int)(Math.random() * 4);
		System.out.println("Current speed: " + speed);
	}
	
	public int getLaps()
	{
		return laps;
	}
	
	protected void race()
	{
		position += speed;
		if(position > 39)
		{
			position -= 40;
			laps++;
		}
		fuelAmt -= speed;
		tireWear -= speed+1/2;
	}
	
	protected void pit()
	{
		fuelAmt = 100;
		tireWear = 100;
	}
	
	@Override
	public String toString()
	{
		return name + " Position: " + position + " [Fuel: " + fuelAmt + "] [Tires: " + tireWear + "]";
	}
}
