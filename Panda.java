class Panda extends Animal {
    public Panda(String name, String species) {

        super(name, species);
    }

    @Override
    public void giveFood() {
        hunger = hunger - 25; // change hunger, thist, boredom values on the item type given
        thirst = thirst + 15;
        boredom = boredom + 15;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 60); // increases the total cost by x amount

        if (hunger < 0) {
            hunger = 0; // makes sure value doesnt go below 0
        }
    }

    @Override
    public void giveWater() {
        hunger = hunger + 40;
        thirst = thirst - 80;
        boredom = boredom + 10;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);

        if (thirst < 0) {
            thirst = 0;
        }
    }

    @Override
    public void giveToy() {
        hunger = hunger + 40;
        thirst = thirst + 15;
        boredom = boredom - 40;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 10);

        if (boredom < 0) {
            boredom = 0;
        }
    }


}
