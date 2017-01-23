package model;

/**
 * Created by Alexandr on 05.12.2016.
 */
public enum FormatFilm {
    COMMON("2D"),
    COMMON3D("3D"),
    COMMON4D("4D"),
    IMAX2D("IMAX 2D"),
    IMAX3D("IMAX 3D"),
    IMAX4D("IMAX 4D"),
    OTHER("Other");

    private final String name;

    FormatFilm(String name) {
        this.name = name;
    }
    public String returnName(){
        return name;
    }
    public String getStringName(){
        return this.name;
    }
    public static FormatFilm getFormatFilm(String name){
        for (FormatFilm formatFilm : values()) {
                if(formatFilm.name.equals(name))
                    return formatFilm;

        }
        return FormatFilm.OTHER;
    }
    @Override
    public String toString(){
        return name;
    }
}
