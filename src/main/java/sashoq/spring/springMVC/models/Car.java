package sashoq.spring.springMVC.models;


import javax.validation.constraints.*;


public class Car {
    private int id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2,max = 25, message = "Name should be between 2 and 25 characters")
    private String name;
    @NotNull
    @Min(value = 1970,message = "Year should be greater than 1970")
    @Max(value = 2022,message = "Year should be less than 2022")
    private int year;
    @NotEmpty
    @Size(min = 2,max = 30,message = "country should be between 1 and 30 characters")
    private String country;

    public Car(int id, String name, int year, String country) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String  country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car() {
    }
}
