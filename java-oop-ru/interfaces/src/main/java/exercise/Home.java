package exercise;

interface Home {
    double getArea();
    default short compareTo(Home another) {
        double currentFlatArea = getArea();
        double anotherHomeArea = another.getArea();
        if (currentFlatArea > anotherHomeArea) {
            return 1;
        } else if (currentFlatArea == anotherHomeArea) {
            return 0;
        }
        return -1;
    }
}
