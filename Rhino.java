class Rhino extends Animal {
    public Rhino(String name, String species) {

        super(name, species);
    }

    @Override
    public void giveFood() {
        hunger = hunger - 25; // change hunger, thist, boredom values on the item type given
        thirst = thirst + 5;
        boredom = boredom + 25;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50); // increases the total cost by x amount

        if (hunger < 0) {
            hunger = 0; // makes sure value doesnt go below 0
        }
    }

    @Override
    public void giveWater() {
        hunger = hunger + 5;
        thirst = thirst - 25;
        boredom = boredom + 25;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);

        if (thirst < 0) {
            thirst = 0;
        }
    }

    @Override
    public void giveToy() {
        hunger = hunger + 20;
        thirst = thirst + 20;
        boredom = boredom - 50;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);

        if (boredom < 0) {
            boredom = 0;
        }
    }


}
