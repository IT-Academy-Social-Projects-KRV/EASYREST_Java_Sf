package com.easyrestaurant.utils;

import com.easyrestaurant.core.PSQL;

import java.sql.SQLException;

public class CheckRestaurantExist {
    public void findRestaurant() throws SQLException {
        final String customNewRes = """
                INSERT INTO restaurants(name, address_id, description, description_markup, owner_id, status, creation_date) values('My new rest', 'Bulgaria, Sofia', 'test', '{"blocks":[{"key":"9n20j","text":"test2","type":"unstyled","depth":0,"inlineStyleRanges":[],"entityRanges":[],"data":{}}],"entityMap":{}}', 19, 0, 1675001286);
                """;
        final String myNewRes = "INSERT INTO restaurants(name, address_id, description," +
                " owner_id, status) values('My new rest'," +
                " 'Bulgaria, Sofia', 'test', 19, 0);";
        boolean ifExist = false;
        PSQL object = new PSQL();
        object.connectToDb();
        var res = object.executeQueryAndGetResults("SELECT * FROM Restaurants WHERE owner_id='19';");
        String sum = "";
        while(res.next()){
            //String id = res.getString("id");
            sum = res.getString("name");
//            System.out.println(sum);
            if(sum.equals("My new rest")){
                ifExist = true;
//                System.out.println("EXIST");
            }
        }
        if(!ifExist){
            object.executeQueryAndGetResults(customNewRes);
        }
        //Close DB
        object.tearDown();
    }
}
