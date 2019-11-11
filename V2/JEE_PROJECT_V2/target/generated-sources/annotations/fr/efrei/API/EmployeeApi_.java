package fr.efrei.API;

import fr.efrei.API.AdressApi;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-11T19:32:05")
@StaticMetamodel(EmployeeApi.class)
public class EmployeeApi_ { 

    public static volatile SingularAttribute<EmployeeApi, String> home_phone;
    public static volatile SingularAttribute<EmployeeApi, String> work_phone;
    public static volatile SingularAttribute<EmployeeApi, String> last_name;
    public static volatile ListAttribute<EmployeeApi, AdressApi> adresses;
    public static volatile SingularAttribute<EmployeeApi, Integer> id;
    public static volatile SingularAttribute<EmployeeApi, String> first_name;
    public static volatile SingularAttribute<EmployeeApi, String> email;
    public static volatile SingularAttribute<EmployeeApi, String> cell_phone;

}