package Boatshop.models;

import java.time.LocalDate;
import java.util.UUID;

public class Boat {
    private static LocalDate gyartasiev;
    private UUID id;
    private String modelName;
    private Allapot allapot;
    private Tipus tipus;

    public Boat()
    {
        this.id= UUID.randomUUID();

    }
    public Boat( String modelName, Allapot allapot, Tipus tipus, LocalDate gyartasiev) {
        this.modelName = modelName;
        this.allapot = allapot;
        this.tipus = tipus;
        this.gyartasiev=gyartasiev;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Allapot getAllapot() {
        return allapot;
    }

    public void setAllapot(Allapot allapot) {
        this.allapot = allapot;
    }

    public Tipus getTipus() {
        return tipus;
    }

    public void setTipus(Tipus tipus) {
        this.tipus = tipus;
    }

    public static LocalDate getGyartasiev() {
        return gyartasiev;
    }

    public void setGyartasiev(LocalDate gyartasiev) {
        this.gyartasiev = gyartasiev;
    }
}
