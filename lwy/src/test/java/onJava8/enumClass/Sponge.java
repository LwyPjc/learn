package onJava8.enumClass;

public enum Sponge {
    BLUE("蓝色",1),
    RED("红色",2);
    private String name;
    private int index;

    private Sponge(String name,int index){
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


}
