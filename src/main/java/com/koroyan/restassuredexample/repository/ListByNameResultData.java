package com.koroyan.restassuredexample.repository;

import com.koroyan.restassuredexample.pojos.response.GetListByNameResult;
import com.koroyan.restassuredexample.pojos.response.PersonIdentification;

import java.util.ArrayList;
import java.util.List;

public class ListByNameResultData {
    private static List<PersonIdentification> personIdentificationList;
    private static List<PersonIdentification> filteredPersonIdentificationList;
    private static GetListByNameResult listByNameResult;


    private static void initializeDatabase() {
        personIdentificationList = new ArrayList<>();
        personIdentificationList.add(new PersonIdentification(89, "Xavier,Bob D.", "708-96-6126", "1966-08-11"));
        personIdentificationList.add(new PersonIdentification(10, "Xavier,Joe I.", "640-94-6892", "2013-12-12"));
        personIdentificationList.add(new PersonIdentification(41, "Xavier,Jose V.", "611-16-6306", "1929-01-07"));
        personIdentificationList.add(new PersonIdentification(116, "Xavier,Orson Q.", "261-54-9130", "1966-06-08"));
    }

    public static GetListByNameResult getPersonByName(String name) {
        initializeDatabase();
        filteredPersonIdentificationList = new ArrayList<>();
        for (PersonIdentification person: personIdentificationList) {
            if (person.getName().contains(name)) {
                filteredPersonIdentificationList.add(person);
            }
        }
        listByNameResult = new GetListByNameResult(filteredPersonIdentificationList);
        return listByNameResult;
    }
}
