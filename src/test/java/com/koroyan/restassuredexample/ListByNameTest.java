package com.koroyan.restassuredexample;


import com.koroyan.restassuredexample.data.CommonData;
import com.koroyan.restassuredexample.pojos.response.GetListByNameResult;
import com.koroyan.restassuredexample.repository.ListByNameRepository;
import com.koroyan.restassuredexample.repository.ListByNameRepositoryImpl;
import com.koroyan.restassuredexample.steps.Step;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListByNameTest {

    private Step step;
    private ListByNameRepository listByNameRepository;


    @BeforeMethod
    public void initializeSteps() {
        step = new Step();
        listByNameRepository = new ListByNameRepositoryImpl();
    }


    @Test
    public void testPersonListByName() throws JSONException {
        GetListByNameResult apiList = step.getListByName(CommonData.PERSON_NAME);
        GetListByNameResult databaseList = listByNameRepository.getListByName(CommonData.PERSON_NAME);
        JSONAssert.assertEquals(apiList.toString(), databaseList.toString(), false);
    }
}
