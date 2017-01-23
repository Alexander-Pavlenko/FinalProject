package model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Alexandr on 05.12.2016.
 */

@Data
public class Place implements Serializable {
    private int column;
    private int row;
    private double price;
    private State state = State.FREE;
    static final long SerialVersionUID = 8330345577629462498L;
    public Place(){}
    public Place(int column, int row, double price) {
        this.column = column;
        this.row = row;
        this.price = price;
    }
    public Place(int column, int row){
        this.column = column;
        this.row = row;
    }
    @Override
    public String toString(){
        return "" + state.getStringName() ;
    }

}
