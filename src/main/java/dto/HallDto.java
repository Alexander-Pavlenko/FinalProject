package dto;

import Exceptions.StatusException;
import lombok.Data;
import model.Entity;
import model.Place;
import model.State;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexandr on 17.12.2016.
 */
@Data
public class HallDto extends Entity<Integer> {
    private int countColumn;
    private int countRow;
    private Place[][] places;
    private String name;

    public HallDto(){}
    public HallDto(int countColumn, int countRow, double price){
        this.countColumn = countColumn;
        this.countRow = countRow;
        places = new Place[countColumn][countRow];
        for (int i = 0; i < countColumn; i++) {
            for (int j = 0; j < countRow; j++) {
                places[i][j] = new Place(i,j, price);
            }
        }
    }

    private boolean checkPlace(Place place) throws StatusException {
        if(places[place.getColumn()][place.getRow()].getState().getStringName().equals(State.FREE.getStringName()))
            return true;
        throw new StatusException("Place BUSY");
    }
    public synchronized List<TicketDto> booking(String s){
        ArrayList<Place> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("(\\d+)\\|(\\d+)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            int i = Integer.parseInt(matcher.group(1));
            int j = Integer.parseInt(matcher.group(2));
            list.add(returnPlace(i,j));
        }
        for (Place place : list) {
            try {
                checkPlace(place);
            }
            catch (StatusException se){

            }
        }
        List<TicketDto> ticketDtos = new ArrayList<>();
        for (Place place : list) {
            this.changeStatusToBusy(place);
            TicketDto ticketDto = new TicketDto();
            ticketDto.setPlace(place);
            ticketDto.setPrice(place.getPrice());
            ticketDtos.add(ticketDto);

        }
        return ticketDtos;
    }
    public boolean reBooking(List<TicketDto> ticketDtos){
        for (TicketDto ticketDto : ticketDtos) {
            changeStatusToFree(ticketDto.getPlace());
        }
        return true;
    }
    private boolean changeStatusToFree(Place place){
        this.getPlaces()[place.getColumn()][place.getRow()].setState(State.FREE);
        return true;
    }
    private boolean changeStatusToBusy(Place place){
        this.getPlaces()[place.getColumn()][place.getRow()].setState(State.BUSY);
        return true;
    }

    private Place returnPlace(int i, int j){
        Place place = null;
        if(i >= this.getCountColumn() || i < 0 || j >= this.getCountRow() || j < 0)
            throw new ArrayIndexOutOfBoundsException();
        place = this.getPlaces()[i][j];
        return place;
    }


}
