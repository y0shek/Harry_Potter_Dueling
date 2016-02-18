///////////////////////////////////////////////////////////////////////////////
// Title:            Harry Potter Duel
// Files:            HarryPotterDuel.java
// Semester:         CS302 Fall 2012
//
// Author:           Joshua Kellerman jkellerman@wisc.edu
// CS Login:         andrew
// Lecturer's Name:  Deppeler
// Lab Section:      327 Lab 2
//
//                   PAIR PROGRAMMERS COMPLETE THIS SECTION
// Pair Partner:     Josh Kellerman
// CS Login:         kellerma
// Lecturer's Name:  Deppeler
// Lab Section:      327 Lab 2
//
// Credits:          Cay Horstmann, Deborah Deppelere, Codelab, Nick
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Random;
import java.util.Scanner; 

public class HarryPotterDuel
{
	public static void main(String[] args)
	{

// Now we display the welcome message:

		System.out.println("Welcome to Harry Potter Dueling.\n");
		System.out.println("This is a text-based Wizard Dueling game.");
		System.out.println("Select your strategy from the menus that" +
				" follow. \nGood luck!\n\n");

//declare and initialize a Scanner
		Scanner in = new Scanner(System.in);

//get seed value from user and use it to make the random number generator
		System.out.print("Give this game some smarts!\n");
		System.out.print("Please enter a seed value [integer]: "); 

//you may assume the user enters an integer for the seed. Create rng object
		int seed = in.nextInt(); 
		Random rng = new Random(seed);

//declare and initialize any other needed variables
		int harry_duel = 0;
		int harry_train = 0;
		int voldemort_duel = 0;
		int totalPotterDamage = 0; 
		int totalVoldemortDamage = 0;
		int userChoice = 0;
		int numberOfDuels = 0;
		int numberOfHeals = 0;
		int playerWins = 0;
		int playerLoss = 0;
		int volWins = 0;
		int volLoss = 0;
		int playerVolTie = 0;
		boolean duelBoolean;
		boolean trainBoolean;
		
		
//Set initial damage for spells for Harry
		int harDamageStupefy = 10;
		int harDamageImpedimenta = 10;
		int harDamageFurnunculus = 10; 
		int harDamageExpelliarmus = 10;
		int harDamageProtego = 0;

//Set initial damage for spells for Voldemort
		int volDamageStupefy = 10;
		int volDamageImpedimenta = 10;
		int volDamageFurnunculus = 10;
		int volDamageExpelliarmus = 10;
		int volDamageProtego = 0;

//Set initial Health Values for the Player and Computer

		int potterHealth = 50;
		int voldemortHealth = 50;

//Set Integers to Spells for Casting for Harry
		final int HAR_STUPEFY = 1;
		final int HAR_IMPEDIMENTA = 2;
		final int HAR_FURNUNCULUS = 3;
		final int HAR_EXPELLIARMUS = 4;
		final int HAR_PROTEGO = 5;

//Set Integers to Spells for Casting for Voldemort
		final int VOL_STUPEFY = 1;
		final int VOL_IMPEDIMENTA = 2;
		final int VOL_FURNUNCULUS = 3;
		final int VOL_EXPELLIARMUS = 4;
		final int VOL_PROTEGO = 5;

//Print Initial Health Values and Spell Damages
		System.out.println();
		System.out.println("WELCOME TO POTTER DUELING!");
		System.out.println("MAY LUCK BE ON YOUR SIDE TODAY:");
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("STARTING HEALTH");
		System.out.println("---------------------------------------------");
		System.out.println("Harry Potter's Health is: " + potterHealth);
		System.out.println("Voldemort's Health is:    " + voldemortHealth);
		System.out.println("-------------------------------------------------");
		
		System.out.println("PLEASE REVIEW THE SPELL " +
				"DAMAGES BEFORE BEGINNING: ");
		System.out.println("-------------------------------------------------");
		System.out.println("Harry's Spell Damages:");
		
		System.out.println("Stupefy=" +" "+ (harDamageStupefy));
		System.out.println("Impedimenta=" +" "+ (harDamageImpedimenta));
		System.out.println("Furnunculus=" +" "+ (harDamageFurnunculus));
		System.out.println("Expelliarmus=" +" "+ (harDamageExpelliarmus));
		System.out.println("Protego=" +" "+ (harDamageProtego));
		System.out.println("-------------------------------------------------");
		System.out.println("Voldemort's Spell Damages:");
	
		System.out.println("Stupefy=" +" "+ (volDamageStupefy));
		System.out.println("Impedimenta=" +" "+ (volDamageImpedimenta));
		System.out.println("Furnunculus=" +" "+ (volDamageFurnunculus));
		System.out.println("Expelliarmus=" +" "+ (volDamageExpelliarmus));
		System.out.println("Protego=" +" "+ (volDamageProtego));
		System.out.println("-------------------------------------------------");
		
		System.out.println("----Hierarchy of Spells----");
		System.out.println("Stupefy defeats Impedimenta.");
		System.out.println("Impedimenta defeats Furnunculus.");
		System.out.println("Furnunculus defeats Expelliarmus.");
		System.out.println("Expelliarmus defeats Stupefy.");
		System.out.println("Protego defeats all Other Spells.");
		System.out.println("Expelliarmus or Impedimenta defeat each other" +
				" depending on which has the higher damage value.");
		System.out.println("If Expelliarmus and Impedimenta have the same" +
				" damage value then both players are hurt.");
		System.out.println("If the same spells are cast the one with the" +
				" higer damage value wins.");
		System.out.println("If the same spells have the same damage value" +
				" then both players are hurt.");
		System.out.println("-------------------------------------------------");

//Give the user some direction/help
		System.out.print("Please Review the Material Above " +
				"Before Continuing\n");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println("Below is the Game Menu. You may enter a value now:");
		
////////////////////////////////////////////////////////////////////////////////
//begin game loop///////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
		
while (potterHealth > 0 && voldemortHealth > 0) {

// Set sentinel boolean values for Duel and Train Menus

duelBoolean = false;
trainBoolean = false;

//Print Player Menu
		System.out.println("\n>====-------------MAIN MENU-------------====<\n");
		System.out.println("Harry's Health: " + potterHealth + 
				",  Voldemort's Health: " + voldemortHealth);
		System.out.println("\nPlease enter what you want to do, Apprentice: ");
		System.out.println("1 - Status Report");
		System.out.println("2 - Duel");
		System.out.println("3 - Train");
		System.out.println("4 - Heal");
		System.out.println("5 - Forfeit");
		System.out.print("Enter Choice Number Here: ");
		
//Check integer input validation	
	if (!in.hasNextInt()){
		System.out.println("\nERROR! Not an Integer. Please enter an Integer.\n");
		in.next();
		continue;
	}

	
//Prompt user for their decision	

userChoice = in.nextInt();
	
	if (userChoice < 1 || userChoice > 5) {
		System.out.println("\nERROR! Please enter an integer between 1-5.\n");
		continue;
	}

	
////////////////////////////////////////////////////////////////////////////////
//#1 - if user chooses to view spell damage report//////////////////////////////
////////////////////////////////////////////////////////////////////////////////

//print game Report

	if (userChoice == 1){
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("****STATUS REPORT****");
		System.out.println("Harry's Health:             " + (potterHealth));
		System.out.println("Voldemort's Health:         " + (voldemortHealth));
		System.out.println("Number of Duels:            " + (numberOfDuels));
		System.out.println("Times Harry Healed (Max 3): "
			+ (numberOfHeals));
		
		System.out.println("\nSPELL DAMAGES:");
		System.out.println("Stupefy defeats Impedimenta             " +
				"       P:" + harDamageStupefy + " V:" + volDamageStupefy);
		
		System.out.println("Impedimenta defeats Furnunculus, Expelliarmus  " +
				"P:" + harDamageImpedimenta + " V:" + 
				volDamageImpedimenta);
		
		System.out.println("Furnunculus defeats Expelliarmus     " +
				"          P:" + harDamageFurnunculus + " V:" + 
				volDamageFurnunculus);
		
		System.out.println("Expelliarmus defeats Stupefy, Impedimenta " +
				"     P:" + harDamageExpelliarmus + " V:" + 
				volDamageExpelliarmus);
		
		System.out.println("Protego defeats All Other Spells           " +
				"    P:0  V:0");
		
		System.out.println();
		System.out.println("----WIN/LOSS/TIE----");
		System.out.println("Win:  " + "P: " + playerWins + " V: " + volWins);
		System.out.println("Loss: " + "P: " + playerLoss + " V: " + volLoss);
		System.out.println("Number of Ties: " + playerVolTie);	
		System.out.println("\n-------------------------------------------------");
		System.out.println("SCROLL UP FOR MORE OF THE REPORT IF YOU NEED TO.");
		System.out.println("-------------------------------------------------");
		}

////////////////////////////////////////////////////////////////////////////////
// #2 - if user chooses to duel/////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

	if (userChoice == 2){
		
//randomly choose spell for computer to cast

	voldemort_duel = rng.nextInt(5)+1;

//print Duel menu within while loop with duel boolean for input validation
	while (duelBoolean == false){

		System.out.println("\n----DUELING MENU----\n");
		System.out.print("1. Stupify: ");
		System.out.print("      P: " + harDamageStupefy + " ");
		System.out.println("V: " + volDamageStupefy);
		System.out.print("2. Impedimenta: ");
		System.out.print("  P: " + harDamageImpedimenta + " ");
		System.out.println("V: " + volDamageImpedimenta);
		System.out.print("3. Furnunculus: ");
		System.out.print("  P: " + harDamageFurnunculus + " ");
		System.out.println("V: " + volDamageFurnunculus);
		System.out.print("4. Expelliarmus: ");
		System.out.print(" P: " + harDamageExpelliarmus + " ");
		System.out.println("V: " + volDamageExpelliarmus);
		System.out.print("5. Protego: ");
		System.out.print("      P: " + harDamageProtego + " ");
		System.out.println(" V: " + volDamageProtego);
		System.out.print("Enter 1-5 for which spell to cast: ");

//Check Input Validation
	
		if (!in.hasNextInt()){
			System.out.println("\nERROR! Not an Integer. " +
					"Please enter an Integer.");
			in.next();
			continue;
		}
	
	harry_duel = in.nextInt();
	System.out.println();
		
		if (harry_duel < 1 || harry_duel > 5) {
			System.out.println("ERROR! Please enter an integer between 1-5.");
			continue;
		}
		
		else { 
			duelBoolean = true;
		}
}

// DUELING LOGIC: PLAYERS CHOICE compared to each VOLDEMORT CHOICE
	
////////////////////////////////////////////////////////////////////////////////	
////// When Stupefy is chosen by the User and Voldemort either chooses//////////
////// Expelliarmus, Protego, Stupefy, or Impedimenta //////////////////////////
////////////////////////////////////////////////////////////////////////////////		
		
	if (harry_duel == HAR_STUPEFY){
		
		if(voldemort_duel == VOL_PROTEGO)  {
			totalPotterDamage += volDamageProtego;
			System.out.println("Voldemort used Protego!");
			System.out.println("Voldemort defeats your Stupify with" +
					" his Protego but you do not receive any damage.");
		}
		
		else if (voldemort_duel == VOL_FURNUNCULUS)  {
			totalPotterDamage = 0;
			totalVoldemortDamage = 0;
			System.out.println("Voldemort used Furnunculus!");
			System.out.println("Your spells cancel out! Nobody recieves " +
					"damage.");
		}
		
		else if (voldemort_duel == VOL_EXPELLIARMUS)  {
			System.out.println("Voldemort used Expelliarmus");
			totalPotterDamage += volDamageExpelliarmus;
			System.out.println("Voldemort defeats your Stupefy with his" +
					" Expelliarmus and you receive damage.");
		}
		
		else if (voldemort_duel == VOL_IMPEDIMENTA)  {
			System.out.println("Voldemort used Impedimenta!");
			totalVoldemortDamage += harDamageStupefy;
			System.out.println("Your Stupefy defeats Voldemort's Impedimenta" +
					" and Voldemort receives damage.");
		}
		
		else if (voldemort_duel == VOL_STUPEFY)  {
			System.out.println("Voldemort used Stupefy!");
			
			if (volDamageStupefy > harDamageStupefy)  {
						totalPotterDamage += volDamageStupefy;
						System.out.println("Voldemort's Stupefy is stronger " +
								"than your Stupefy! You receive damage.");
			}
			else if (harDamageStupefy > volDamageStupefy)  {
				totalVoldemortDamage += harDamageStupefy;
				System.out.println("Your Stupefy is stronger than Voldemort's" +
						" Stupefy! Voldemort receives damage.");
			}
			else if (harDamageStupefy == volDamageStupefy)  {
						totalPotterDamage += volDamageStupefy;
						totalVoldemortDamage += harDamageStupefy;
						System.out.println("Your Stupefy is evenly matched " +
								"with Voldemort's Stupefy. Both take damage.");
			}
		}
	}
	
////////////////////////////////////////////////////////////////////////////////	
///// When Impedimenta is chosen by the User and Voldemort either chooses //////
///// Stupefy, Protego, Expelliarmus, Furnunculus, Impedimenta /////////////////
////////////////////////////////////////////////////////////////////////////////
	
	if (harry_duel == HAR_IMPEDIMENTA){ 
		
		if (voldemort_duel == VOL_PROTEGO) {
			System.out.println("Voldemort used Protego!");
			totalPotterDamage += volDamageProtego;
			System.out.println("Voldemort Defeats your Impedimenta with his " +
					"Protego but you do not receive any damage.");
		}
		
		else if (voldemort_duel == VOL_FURNUNCULUS) {
			System.out.println("Voldemort used Furnunculus!");
			totalVoldemortDamage += harDamageImpedimenta;
			System.out.println("Your Impedimenta defeated Voldemort's" +
					" Furnunculus! Voldemort receives damage.");
		}
		
		else if (voldemort_duel == VOL_STUPEFY){
			System.out.println("Voldemort used Stupefy!");
			totalPotterDamage += volDamageStupefy;
			System.out.println("Voldemort's Stupefy defeats your Impedimenta" +
					" and you take damage.");
		}
		
		else if (voldemort_duel == VOL_IMPEDIMENTA)  {
			System.out.println("Voldemort used Impedimenta!");
			
			if (volDamageImpedimenta > harDamageImpedimenta)  {
				totalPotterDamage += volDamageImpedimenta;
				System.out.println("Voldemort's Impedimenta is stronger than" +
						" your Impedimenta. You receive damage.");
			}
			
			else if (volDamageImpedimenta < harDamageImpedimenta)  {
				totalVoldemortDamage += harDamageImpedimenta;
				System.out.println("Your Impedimentia is stronger than" +
						" Voldemort's Impedimenta. Voldemort receives damage.");
			}
			
			else if (volDamageImpedimenta == harDamageImpedimenta)  {
				totalPotterDamage += volDamageImpedimenta;
				totalVoldemortDamage += harDamageImpedimenta;
				System.out.println("Your Impedimenta is evenly matched with" +
						"Voldemort's Impedimentia. Both receive damage.");
			}
		}
		
		else if (voldemort_duel == VOL_EXPELLIARMUS)  {
			System.out.println("Voldemort used Expelliarmus!");
			
			if (volDamageExpelliarmus > harDamageImpedimenta)  {
				totalPotterDamage += volDamageExpelliarmus;
				System.out.println("Voldemort's Expelliarmus is stronger" +
						" than your Impedimenta and you receive damage.");
			}
			
			else if (harDamageImpedimenta > volDamageExpelliarmus)  {
				totalVoldemortDamage += harDamageImpedimenta;
				System.out.println("Your Impedimenta is stronger than " +
						"Voldemort's Expelliarmus. Voldemort receives damage.");
			}
			
			else if (harDamageImpedimenta == volDamageExpelliarmus)  {
				totalVoldemortDamage += harDamageImpedimenta;
				totalPotterDamage += volDamageExpelliarmus;
				System.out.println("Your Impedimenta is evenly matched with" +
						" Voldemort's Expelliarmus. Both receive damage.");
			}
		}
		
	}

////////////////////////////////////////////////////////////////////////////////
///// When Furnunculus is chosen by the User and Voldemort either chooses //////
///// Stupefy, Protego, Expelliarmus, Furnunculus, Impedimenta /////////////////
////////////////////////////////////////////////////////////////////////////////

				
	if (harry_duel == HAR_FURNUNCULUS){
		
		if (voldemort_duel == VOL_PROTEGO) {
			totalPotterDamage += volDamageProtego;
			System.out.println("Voldemort used Protego!");
			System.out.println("Voldemort defeats your Furnunculus with his" +
					" Protego but you do not receive any damage.");
		}
		
		else if (voldemort_duel == VOL_IMPEDIMENTA) {
			System.out.println("Voldemort used Impedimenta!");
			totalPotterDamage += volDamageImpedimenta;
			System.out.println("Voldemort defeats your Furnunculus with his" +
					" Impedimenta and you receive damage.");
		}
		
		else if (voldemort_duel == VOL_STUPEFY)  {
			System.out.println("Voldemort used Stupefy!");
			System.out.println ("Your spells cancel out! Nobody recieves " +
					"damage.");
		}
		
		else if (voldemort_duel == VOL_FURNUNCULUS)  {
			System.out.println("Voldemort used Furnunculus!");
			
			if (volDamageFurnunculus > harDamageFurnunculus)  {
				totalPotterDamage += volDamageFurnunculus;
				System.out.println ("Voldemort's Furnunculus is stronger " +
						"than your Furnunculus and you receive damage.");
			}
			
			else if (harDamageFurnunculus > volDamageFurnunculus)  {
				totalVoldemortDamage += harDamageFurnunculus;
				System.out.println ("Your Furnunculus is stronger than" +
						" Voldemort's Furnunculus and" +
						" Voldemort receives damage.");
			}
			
			else if (harDamageFurnunculus == volDamageFurnunculus)  {
				totalVoldemortDamage += harDamageFurnunculus;
				totalPotterDamage += volDamageFurnunculus;
				System.out.println("Your Furnunculus is evenly matched with" +
						" Voldemort's Furnunculus. Both receive damage.");
			}
		}
		
		else if (voldemort_duel == VOL_EXPELLIARMUS)  {
			System.out.println("Voldemort used Expelliarmus!");
			totalVoldemortDamage += harDamageFurnunculus;
			System.out.println("Your Furnunculus defeats Voldemort's" +
					" Expelliarmus. Voldemort receives damage.");
		}
			
	}

////////////////////////////////////////////////////////////////////////////////
///// When Expelliarmus is chosen by the User and Voldemort either chooses /////
///// Stupefy, Protego, Expelliarmus, Furnunculus, Impedimenta /////////////////
////////////////////////////////////////////////////////////////////////////////

	if (harry_duel == HAR_EXPELLIARMUS){
		
		if (voldemort_duel == VOL_PROTEGO)  {
			totalPotterDamage += volDamageProtego;
			System.out.println("Voldemort used Protego!");
			System.out.println("Voldemort defeats your Expelliarmus with" +
					" his Protego but you do not receive damage.");
		}
		
		else if (voldemort_duel == VOL_EXPELLIARMUS)  {
			System.out.println("Voldemort used Expelliarmus!");
			
			if (volDamageExpelliarmus == harDamageExpelliarmus)  {
				totalPotterDamage += volDamageExpelliarmus;
				totalVoldemortDamage += harDamageExpelliarmus;
				System.out.println("Your Expelliarmus is evenly matched with " +
						"Voldemort's Expelliarmus. Both receive damage.");
			}
			
			else if (volDamageExpelliarmus > harDamageExpelliarmus)  {
				totalPotterDamage += volDamageExpelliarmus;
				System.out.println("Voldemort's Expelliarmus is stronger " +
						"than your Expelliarmus. You receive damage.");
			}
			
			else if (harDamageExpelliarmus > volDamageExpelliarmus) {
				totalVoldemortDamage += harDamageExpelliarmus;
				System.out.println("Your Expelliarmus is stronger than " +
						"Voldemort's Expelliarmus. Voldemort receives damage.");
			}
		}
		
		else if (voldemort_duel == VOL_IMPEDIMENTA)   {
			System.out.println("Voldemort used Impedimenta!");
			
			if (volDamageImpedimenta > harDamageExpelliarmus)  {
				totalPotterDamage += volDamageImpedimenta;
				System.out.println("Voldemort's Impedimenta is stronger " +
						"than your Expelliarmus and you receive damage.");
			}
			
			else if (harDamageExpelliarmus > volDamageImpedimenta)   {
				totalVoldemortDamage += harDamageExpelliarmus;
				System.out.println("Your Expelliarmus is stronger than " +
						"Voldemort's Impedimenta. Voldemort receives damage.");
			}
		}
		
		else if (voldemort_duel == VOL_STUPEFY)  {
			System.out.println("Voldemort used Stupefy!");
			totalVoldemortDamage += harDamageExpelliarmus;
			System.out.println("Your Expelliarmus defeats Voldemort's " +
					"Stupefy. Voldemort receives damage.");
		}
		
		else if (voldemort_duel == VOL_FURNUNCULUS)  {
			System.out.println("Voldemort used Furnunculus!");
			totalPotterDamage += volDamageFurnunculus;
			System.out.println("Voldemort's Furnunculus defeats your " +
					"Expelliarmus and you receive damage.");
		}
	}
	
////////////////////////////////////////////////////////////////////////////////
///// When Protego is chosen by the User and Voldemort either chooses //////////
///// Stupefy, Protego, Expelliarmus, Furnunculus, Impedimenta /////////////////
////////////////////////////////////////////////////////////////////////////////
	
	if (harry_duel == HAR_PROTEGO)  {
		
		if (voldemort_duel == VOL_PROTEGO)  {
			totalPotterDamage += volDamageProtego;
			totalVoldemortDamage += harDamageProtego;
			System.out.println("Voldemort used Protego!");
			System.out.println("Both you and Voldemort cast Protego. No" +
					" damage is received by either player.");
		}
		
		else if (voldemort_duel == VOL_STUPEFY)  {
			totalVoldemortDamage += harDamageProtego;
			System.out.println("Voldemort used Stupefy!");
			System.out.println("Your Protego defeats Voldemort's Stupefy " +
					"but Voldemort does not receive damage.");
		}
		
		else if (voldemort_duel == VOL_IMPEDIMENTA) {
			totalVoldemortDamage += harDamageProtego;
			System.out.println("Voldemort used Impedimenta!");
			System.out.println("Your Protego defeats Voldemort's Impedimenta " +
					"but Voldemort does not receive damage.");
		}
		
		else if (voldemort_duel == VOL_FURNUNCULUS) {
			totalVoldemortDamage += harDamageProtego;
			System.out.println("Voldemort used Furnunculus!");
			System.out.println("Your Protego defeats Voldemort's Furnunculus " +
					"but Voldemort does not receive damage.");
		}
		
		else if (voldemort_duel == VOL_EXPELLIARMUS) {
			totalVoldemortDamage += harDamageProtego;
			System.out.println("Voldemort used Expelliarmus!");
			System.out.println("Your Protego defeats Voldemort's " +
					"Expelliarmus but Voldemort does not receive damage.");
		}

	}
	
//evaluate winner and update health value accordingly after Dueling
	
	    if (totalVoldemortDamage != 0 && totalPotterDamage
	    		!= totalVoldemortDamage) {
			voldemortHealth = voldemortHealth - totalVoldemortDamage;
			potterHealth = potterHealth - totalPotterDamage;
			playerWins++;
			volLoss++;
			
		} else if (totalPotterDamage != 0 && totalPotterDamage
				!= totalVoldemortDamage) {
			potterHealth = potterHealth - totalPotterDamage;
			voldemortHealth = voldemortHealth - totalVoldemortDamage;
			volWins++;
			playerLoss++;
	
		} else if (totalPotterDamage != 0 && totalVoldemortDamage
				!= 0 && (totalPotterDamage == totalVoldemortDamage)) {
			playerVolTie++;
			voldemortHealth = voldemortHealth - totalVoldemortDamage;
			potterHealth = potterHealth - totalPotterDamage;
			
		} else if ( harry_duel == HAR_PROTEGO){
			playerWins++;
			volLoss++;
			voldemortHealth = voldemortHealth - totalVoldemortDamage;
			potterHealth = potterHealth - totalPotterDamage;
			
		} else if ( voldemort_duel == VOL_PROTEGO){
			volWins++;
			playerLoss++;
			voldemortHealth = voldemortHealth - totalVoldemortDamage;
			potterHealth = potterHealth - totalPotterDamage;
			
		}


//Clear total damage values for next round.
	numberOfDuels++;
	totalVoldemortDamage = 0;
	totalPotterDamage = 0;
}	
	
	
////////////////////////////////////////////////////////////////////////////////
//#3 - If user chooses to train ////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

//check that player has sufficient health

if (userChoice == 3 && potterHealth != 5){ 
	
while (trainBoolean == false){
	System.out.println("\n----TRAINING MENU----\n");
	System.out.println("Below is the list of spells you can train:");
	System.out.println();
	System.out.printf("Stupefy:%9d", HAR_STUPEFY);
	System.out.println();
	System.out.printf("Impedimenta:%5d", HAR_IMPEDIMENTA);
	System.out.println();
	System.out.printf("Furnunculus:%5d", HAR_FURNUNCULUS);
	System.out.println();
	System.out.printf("Expelliarmus:%4d", HAR_EXPELLIARMUS);
	System.out.println();
	System.out.print("Please enter which spell you want to train: ");

	
//Check input validation

		if (!in.hasNextInt()){
			System.out.println("\nERROR! Not an Integer. " +
					"Please enter an Integer.");
			in.next();
			continue;
		}

	harry_train = in.nextInt();
	System.out.println();
		
		if (harry_train < 1 || harry_train > 4) {
			System.out.println("ERROR! Please enter an integer between 1-4.");
			continue;
		}
		
		else { trainBoolean = true; }
	}


//update training accordingly and tell user if maximum training.

	if (harry_train == 1 && harDamageStupefy < 25) {
		harDamageStupefy += 5;
		potterHealth -= 5;	
		System.out.println("Harry's Stupefy strengthens by 5 but he " +
				"sacrifices 5 health points.");
	} 
		
		else if (harry_train == 1 && harDamageStupefy == 25) {
			System.out.println("You have reached the maximum training on" +
					" this spell. Harry takes 5 damage for trying to train.");
			potterHealth -= 5;
		}

		if (harry_train == 2 && harDamageImpedimenta < 25) {
			harDamageImpedimenta += 5;
			potterHealth -= 5;	
			System.out.println("Harry's Impedimenta strengthens by 5 but he " +
					"sacrifices 5 health points.");
		}
		
		else if (harry_train == 2 && harDamageImpedimenta == 25) {
			System.out.println("You have reached the maximum training on " +
					"this spell. Harry takes 5 damage for trying to train.");
			potterHealth -= 5;
		}
		
		if (harry_train == 3 && harDamageFurnunculus < 25) {
			harDamageFurnunculus += 5;
			potterHealth -= 5;	
			System.out.println("Harry's Furnunculus strengthens by 5 but he " +
					"sacrifices 5 health points.");
		}
		
		else if (harry_train == 3 && harDamageFurnunculus == 25) {
			System.out.println("You have reached the maximum training" +
					" on this spell. Harry takes 5 damage for trying to train.");
			potterHealth -= 5;
		}
		
		if (harry_train == 4 && harDamageExpelliarmus < 25) {
			harDamageExpelliarmus += 5;
			potterHealth -= 5;
			System.out.println("Harry's Expelliarmus strengthens by 5 but he " +
					"sacrifices 5 health points.");
		}
		
		else if (harry_train == 4 && harDamageExpelliarmus == 25) {
			System.out.println("You have reached the maximum training on" +
					" this spell. Harry takes 5 damage for trying to train.");
			potterHealth -= 5;
		}
}

//Check if player does not have enough Health to train

		else if (userChoice == 3 && potterHealth == 5) {
		System.out.println("\nYou do not have enough health to train." +
				" Heal if you can!");
		}

////////////////////////////////////////////////////////////////////////////////
//#4 - If user chooses to Heal /////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

//Update number of heals and player Health and check if player has reached
//allowed number of heals.

	if (userChoice == 4) {
		if (numberOfHeals <= 2) {
			potterHealth = 50;
			numberOfHeals ++;
			System.out.println();
			System.out.println("You healed yourself! Harry's health = " +
			potterHealth + "!");
		} 
		
		else {
			System.out.println("You are out of White Magic! " +
					"You no longer can heal!!!!");
		}
	}

////////////////////////////////////////////////////////////////////////////////
//#5 if user chooses to forfeit/////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

	if (userChoice == 5){
		System.out.println("-------------------------------------------------");
		System.out.println("\nYou forfeit and LOSE! pansy....");
		System.out.println("Next time try not to forfeit.");
		System.out.println("Voldemort only had " + voldemortHealth + 
				" health points left.\n");
		System.out.println("--------Restart and Try Again!--------");
		System.out.println();
		break;
	}
	
////////////////////////////////////////////////////////////////////////////////
//end of game loop//////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	
}

//print end-game report
if ((potterHealth > voldemortHealth) && userChoice != 5){
	System.out.println();
	System.out.println("-----------------------------------------------------");
	System.out.println("\"Congratulations, You Won with " + potterHealth +
			" health value points!\"");
	System.out.println();
	
	
} else if ((voldemortHealth > potterHealth) && userChoice != 5) {
	System.out.println();
	System.out.println("-----------------------------------------------------");
	System.out.println("\"Sorry, Voldemort has defeated you with " + 
			voldemortHealth + " health value points.\"");
	System.out.println();
	
	
} else if ((voldemortHealth == potterHealth) && userChoice != 5) {
	System.out.println();
	System.out.println("-----------------------------------------------------");
	System.out.println("\"You and Voldemort Tied. You have " + potterHealth +
			" health points, while Voldemort has " + voldemortHealth +
			" health points.\"");
	System.out.println();
}

//This will always be the last thing to print to the user
		System.out.println("-------------------------------------------------");
		System.out.println("                 ENDGAME REPORT                  ");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println("Harry's Health:" +" "+ (potterHealth));
		System.out.println("Voldemort's Health:" +" "+ (voldemortHealth));
		System.out.println("Number of Duels:"+" "+ (numberOfDuels));
		System.out.println("\n----WINS/TIES----");
		System.out.println("Harry's wins: " + playerWins);
		System.out.println("Voldemort's wins: " + volWins);
		System.out.println("Number of Ties: " + playerVolTie);	
		System.out.println();
		System.out.println("Thanks for playing!");
		System.out.println("NOW GO OUTSIDE AND ENJOY THE BEAUTIFUL DAY!");
		
//end main

	}

//end class	

}