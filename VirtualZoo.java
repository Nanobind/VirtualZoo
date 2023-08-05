import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Your name, student number and FAN here

 * Samuel Robey

 * 2308401
 *
 * robe0950
 *
 *
 */


public class VirtualZoo {

    int numAnimals; //initalises number of animals
    static int totalCost; //initialises total cost

    ArrayList<String> names = new ArrayList<>(); //initalises name list
    public static int getTotalCost() {

        return totalCost;
    }
    public static void setTotalCost(int totalCost) {

        VirtualZoo.totalCost = totalCost;//sets total cost to classes input
    }
    public VirtualZoo() {

    }

    public void beginSimulation() {
        displayWelcome(); //calls the display welcome method
        ArrayList<Animal> zooAnimals = animalSelection(); //creates an array of animals
        weekCycle(zooAnimals); //starts week cycle
    }

    public int askNumberAnimals() throws InputMismatchException{


        while(true){

            Scanner scan = new Scanner(System.in);

            System.out.println("How many animals are at your zoo?"); //prompts number of animals

            try
            {
                numAnimals = scan.nextInt();

                if(numAnimals < 0){ //if num is negative
                    System.out.println("Please enter a positive number of animals");

                } else {
                    System.out.println();
                    return numAnimals;
                }
            }
            catch(InputMismatchException e) //if user doesn't input number, throw this exception
            {
                System.out.println("Please enter a valid number of animals");
            }
        }
    }

    public String askAnimalName(int id){

        while(true) {

            Scanner scan = new Scanner(System.in);
            System.out.println("What is the name of animal #" + id+"?"); //asks user for name of animal
            String name = scan.nextLine();

                if(names.contains(name)){ //checks if the inputted name is already in the names array
                    System.out.println("That name is already taken");

                }else{
                    names.add(name); //ads the name to the name array
                    return name;
                }
        }
    }

    public Animal askAnimalSpecies(String name){

        while(true){

            Scanner scan = new Scanner(System.in);
            System.out.println("What is the species of " + name + "?");
            String species = scan.nextLine();

            final String species1 = species.substring(0, 1).toUpperCase() + species.substring(1).toLowerCase(); //turns the inputted species to one with only the first letter capitalised
            switch (species.toLowerCase()) {
                case "tiger"-> {
                    species = species1;
                    return new Tiger(name, species); //creates an animal object based on case
                }case "elephant" ->{
                    species = species1;
                    return new Elephant(name, species);
                }case "rhino" ->{
                    species = species1;
                    return new Rhino(name, species);
                }case "panda" ->{
                    species = species1;
                    return new Panda(name, species);
                }case "monkey" ->{
                    species = species1;
                    return new Monkey(name, species);
                }
                default -> System.out.println("That is not a valid species"); //runs if user inputs an animal type that is that specified

            }

        }

    }

    private ArrayList<Animal> animalSelection() {
        ArrayList<Animal> allZooAnimals = new ArrayList<>(); //creates array of all animals
        askNumberAnimals();

        for(int y = 1; y <= numAnimals; y ++){

            askAnimalName(y);//calls the ask animal name method for each number of animals
            Animal animal = askAnimalSpecies(names.get(y - 1));//asks the species of the animal, which name is appended in the names array

            allZooAnimals.add(animal);//add this animal object to the array of animals
        }

        return allZooAnimals;
    }

    public void askItem(Animal animal){

        int t = 0; //initalises loop breaker

        while(t == 0){

            Scanner scan = new Scanner(System.in);
            System.out.println("What item would you like to give " + animal.getName()+"?"); //asks for the item thats being given to the animal specified
            String items = scan.nextLine();

            switch (items.toLowerCase()) {//to lower case turns the user input lowercase, meaning that case type of the input doesnt matter
                case "food" -> {

                    if(Objects.equals(animal.getLastItemGiven(), "food")){//if the user input is equal to the item given yesterday
                        System.out.println("You cannot give the same item as yesterday");
                    }else{ // if the input isn't the item given yesterday, set the value of last item given to the case
                        animal.setLastItemGiven("food");
                        animal.giveFood();

                        t++; //increment t to break the loop
                    }
                    if(animal.isDead()){// if the giving of an item results in the death of animal

                        System.out.println(animal.getName()+" is dead");
                        totalCost = totalCost + 1000;
                    }

                }case "water" ->{

                    if(Objects.equals(animal.getLastItemGiven(), "water")){
                        System.out.println("You cannot give the same item as yesterday");
                    }else{

                        animal.setLastItemGiven("water");
                        animal.giveWater();
                        t++;
                    }
                    if(animal.isDead()){

                        System.out.println(animal.getName()+" is dead");
                        totalCost = totalCost + 1000;
                    }

                }case "toy" ->{

                    if(Objects.equals(animal.getLastItemGiven(), "toy")){
                        System.out.println("You cannot give the same item as yesterday");
                    }else{

                        animal.setLastItemGiven("toy");
                        animal.giveToy();
                        t++;
                    }
                    if(animal.isDead()){
                        System.out.println(animal.getName()+" is dead");
                        totalCost = totalCost + 1000;
                    }

                }
                default -> System.out.println("That is not a valid item"); //if the user inputs an item that is not one of the cases above
            }

        }
    }
    public void weekCycle(ArrayList<Animal> zooAnimals){

        for(int i= 0; i <=6; i++ ){ //loops through each day of the week

            String[] DaysOfWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}; //array of all the days of the week

            System.out.println();
            System.out.println("The current day is "+DaysOfWeek[i]);//print the day of the week that co-insides with the index in array
            System.out.println();
            for(Animal z: zooAnimals){
                System.out.println(z.toString());//call the to string in the animal class for each animal in the zooAnimal array

            }

            for(Animal y: zooAnimals){

                if(!y.isDead()){ //asks the user to give an item to an animal if it isnt dead
                    askItem(y);
                }
            }
        }
        System.out.println();
        System.out.println("Total week cost = $" + totalCost); //prints the total cost of the week
    }

    //-------------------------operational methods------------------------------

    /**
     * Defines the Welcome Message text
     */
    private void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|   Use this application to simulate running a zoo with many animals   |");
        System.out.println("|           This program is intended for zoo employees only            |");
        System.out.println("+----------------------------------------------------------------------+");
    }













}
