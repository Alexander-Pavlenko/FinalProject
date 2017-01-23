package model;

/**
 * Created by Alexandr on 17.12.2016.
 */
public enum  State {
    FREE("Free"),
    BUSY("Busy"),
    BOOKED("booked");

    private String name;

    State(String name) {
        this.name = name;
    }
    public String returnName(){
        return name;
    }
    public String getStringName(){
        return this.name;
    }
    public static State getFormatFilm(String name){
        for (State state : values()) {
            if(state.name.equals(name))
                return state;

        }
        return State.BOOKED;
    }
    @Override
    public String toString(){
        return name;
    }
}
