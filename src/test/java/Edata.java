public enum Edata {

    data1(1234, "4356", "2"),
    data2(1235, "3156", "3");


    int att;
    String hidden;
    String expected;


    Edata(int att, String hidden, String expected) {
        this.att = att;
        this.hidden = hidden;
        this.expected = expected;
    }

     //Getters
    public int getAtt() {
        return att;
    }

    public String getHidden() {
        return hidden;
    }

    public String getExpected() {
        return expected;
    }
}
