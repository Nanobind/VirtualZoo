class Monkey extends Animal {
    public Monkey(String name, String species) {

        super(name, species);
    }

    @Override
    public void giveFood() {
        hunger = hunger - 30; // change hunger, thist, boredom values on the item type given
        thirst = thirst + 10;
        boredom = boredom + 10;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5); // increases the total cost by x amount

        if (hunger < 0) {
            hunger = 0; // makes sure value doesnt go below 0
        }
    }

    @Override
    public void giveWater() {
        hunger = hunger + 10;
        thirst = thirst - 40;
        boredom = boredom + 10;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);

        if (thirst < 0) {
            thirst = 0;
        }
    }

    @Override
    public void giveToy() {
        hunger = hunger + 10;
        thirst = thirst + 10;
        boredom = boredom - 15;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 15);

        if (boredom < 0) {
            boredom = 0;
        }
    }


}
