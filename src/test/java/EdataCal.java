public enum EdataCal {

    data1(1111, 3, 3333),
    data2(-10, 15, -150);

    int a;
    int b;
    int multy;


    EdataCal(int a, int b, int multy) {
        this.a = a;
        this.b = b;
        this.multy = multy;
    }

    //Getters
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getMulty() {
        return multy;
    }
}
