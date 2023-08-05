

abstract class Animal {


    String name; //initalises name variable
    String species; //initialises species variable
    int hunger = 50; //initalises hunger value
    int thirst = 50; //initalises thirst value
    int boredom = 50; //initialises boredom value

    String lastItemGiven; //initalises the last item given
    public abstract void giveFood(); //sets the abstract give food class

    public abstract void giveWater(); //sets the abstract give water class


    public abstract void giveToy(); //sets the abstract givetoy class

    public String getName() { //gets name

        return name;
    }

    public void setName(String name) { //sets name

        this.name = name;
    }

    public String getSpecies() { //gets species

        return species;
    }

    public void setSpecies(String species) { //sets species

        this.species = species;
    }

    public int getHunger() { //gets hunger

        return hunger;
    }

    public void setHunger(int hunger) { //sets hunger

        this.hunger = hunger;
    }

    public int getThirst() { //gets thirst

        return thirst;
    }

    public void setThirst(int thirst) { //sets thirst

        this.thirst = thirst;
    }

    public int getBoredom() { //gets boredom

        return boredom;
    }

    public void setBoredom(int boredom) {// sets boredom

        this.boredom = boredom;
    }


    public String getLastItemGiven() { //gets the last item given to the animal

        return lastItemGiven;
    }

    public void setLastItemGiven(String lastItemGiven) { //sets last item given of the animal

        this.lastItemGiven = lastItemGiven;
    }



    public Animal(String name, String species) { //constructor fo the animal class
        this.name = name;
        this.species = species;

    }

    public boolean isDead() {

        return hunger > 100 || thirst > 100 || boredom > 100; //returns only if either of each reach over 100, meaning the animal is dead

    }




    public String toString() {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }



}

