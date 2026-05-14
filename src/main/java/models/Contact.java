package models;

import lombok.*;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.ToString;


@Setter
@Getter
@ToString
@Builder

public class Contact {


    private String Name;
    private String LastName;
    private String TelephoneNumber;
    private String Email;
    private String Adress;
    private String Description;





}
