class Elephant extends Animal {
    public Elephant(String name, String species) {
        super(name, species);
    }

    @Override
    public void giveFood() {
        hunger = hunger - 50; // change hunger, thist, boredom values on the item type given
        thirst = thirst + 30;
        boredom = boredom + 20;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 100); // increases the total cost by x amount

        if (hunger < 0) {
            hunger = 0; // makes sure value doesnt go below 0
        }
    }

    @Override
    public void giveWater() {
        hunger = hunger + 20;
        thirst = thirst - 50;
        boredom = boredom + 30;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);

        if (thirst < 0) {
            thirst = 0;
        }
    }

    @Override
    public void giveToy() {
        hunger = hunger + 30;
        thirst = thirst + 10;
        boredom = boredom - 40;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);

        if (boredom < 0) {
            boredom = 0;
        }
    }


}
