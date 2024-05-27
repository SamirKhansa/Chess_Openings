package com.example.chessopenings;

public class Contacts {
    private String name;
    private String Position;
    private String Description;
    private String[] Variations;
    private String ImageName;

    private int position1;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", Moves='" + Position + '\''+
                '}';
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String[] getVariations() {
        return Variations;
    }

    public void setPosition1(int position1) {
        this.position1 = position1;
    }

    public int getPosition1() {
        return position1;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public void setVariations(String[] variations) {
        Variations = variations;
    }

    public Contacts(String name, String Position, String Description, String[] variations, int position, String ImageName ){
        this.name=name;
        this.Position=Position;
        this.Description=Description;
        this.Variations=variations;
        this.position1=position;
        this.ImageName=ImageName;


    }
}
