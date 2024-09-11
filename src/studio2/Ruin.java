package studio2;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		boolean outcome = false;
		
		System.out.println("What is your starting amount? ");
		int startAmount = in.nextInt();
		int tempStartAmount = startAmount;
		System.out.println("What is your win chance?");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit?");
		int winLimit = in.nextInt();
		System.out.println("How many days to simulate?");
		int totalSimulations = in.nextInt();
		
		double expectedRuin;
		
		double a = (1-winChance)/winChance;
		
		if(winChance == .5) {
			
		expectedRuin = 1 - startAmount/winLimit;
			
		}
		else {
			
		expectedRuin = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
			
		}
		
		int successCount = 0;
		int ruinCount = 0;	
		int playCount = 0;
		String dayOutcome = "";
		
		for (int count = 1; count <= totalSimulations; count++) {
			
			while (outcome == false)	{
				
				playCount++;
				double chance = Math.random();
				
				
				if (chance > winChance) {
					startAmount--;
				}
				else if (chance <= winChance) {
					startAmount++;
				}
				
				if (startAmount == winLimit) {
					dayOutcome = "WIN";
					outcome = true;
					successCount++;
				}
				
				else if (startAmount == 0) {
					dayOutcome = "LOSE";
					outcome = true;
					ruinCount++;
				}
				
				
				
			}
			
			System.out.println("Simulation " + count + ": " + playCount + " " + dayOutcome);
			playCount = 0;
			outcome = false;
			startAmount = tempStartAmount;
			
		}
		System.out.println("Losses: "+ruinCount+" Simulatiuons: "+totalSimulations);
		System.out.println("Ruin Rate from Simulation: "+((double)ruinCount/totalSimulations) + " Expected Ruin Rate: " + expectedRuin);
		
	}

}
