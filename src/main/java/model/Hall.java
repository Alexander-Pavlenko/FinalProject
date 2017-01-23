package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * Created by Alexandr on 05.12.2016.
 */
@Setter
@Getter
public class Hall extends Entity<Integer> {
    private int countColume;
    private int countRow;
    private Place[][] places;
    private String name;


    public Hall(String name, int countColume, int countRow, double price) {
        this.countColume = countColume;
        this.countRow = countRow;
        this.places = new Place[countColume ][countRow ];
        for (int i = 0; i < countColume; i++) {
            for (int j = 0; j < countRow; j++) {
                this.places[i][j] = new Place(i,j,price);
            }
        }
        this.name = name;
    }
    public Hall(){}
    public void printPlaces(){
        for (Place[] place : places) {
            System.out.println();
            for (Place place1 : place) {
                System.out.print(place1 + "" + '\t');
            }
        }
    }
    @Override
    public String toString() {
        return "Hall{" +
                ", countColume=" + countColume +
                ", countRow=" + countRow +
                ", places=" + Arrays.toString(places) +
                ", name='" + name + '\'' +
                '}';
    }
}
