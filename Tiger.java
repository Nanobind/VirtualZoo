class Tiger extends Animal {
    public Tiger(String name, String species) {

        super(name, species);
    }

    @Override
    public void giveFood() {
        hunger = hunger - 30; // change hunger, thist, boredom values on the item type given
        thirst = thirst + 15;
        boredom = boredom + 15;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 30); // increases the total cost by x amount

        if (hunger < 0) { // makes sure value doesnt go below 0
            hunger = 0;
        }
    }

    @Override
    public void giveWater() {
        hunger = hunger + 15;
        thirst = thirst - 30;
        boredom = boredom + 15;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);

        if (thirst < 0) {
            thirst = 0;
        }
    }

    @Override
    public void giveToy() {
        hunger = hunger + 15;
        thirst = thirst + 15;
        boredom = boredom - 30;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);

        if (boredom < 0) {
            boredom = 0;
        }
    }


}
