package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static String path = "D:\\progs\\java\\netology\\specFiles\\csv-json\\src\\main\\java\\ru\\netology\\";
    static String[] columnMapping = { "id", "firstName", "lastName", "country", "age" };
    static String parseResult1 = "1, John, Smith, USA, 25";
    static String parseResult2 = "2, Inav, Petrov, RU, 23";
    static List<Employee> employees = App.parseXML(path + "data.xml");

    // 1
    @Test
    public void csvParseTest()
    {
        List<Employee> csvList = App.parseCSV(columnMapping, path + "data.csv");

        Assertions.assertEquals(parseResult1, csvList.get(0).toString());
        Assertions.assertEquals(parseResult2, csvList.get(1).toString());
    }

    @Test
    public void xmlParseTest() {
        List<Employee> xmlList = App.parseXML(path + "data.xml");

        Assertions.assertEquals(parseResult1, xmlList.get(0).toString());
        Assertions.assertEquals(parseResult2, xmlList.get(1).toString());
    }

    @Test
    public void jsonParseTest() {
        List<Employee> json = App.readJSON(path + "data.json");

        Assertions.assertEquals(parseResult1, json.get(0).toString());
        Assertions.assertEquals(parseResult2, json.get(1).toString());
    }

    // 2
    @Test
    public void hamcrestCSV() {
        List<Employee> csvList = App.parseCSV(columnMapping, path + "data.csv");

        assertThat(csvList, hasItem(employees.get(0)));
    }

    @Test
    public void hamcrestJSON() {
        List<Employee> jsonList = App.readJSON(path + "data.json");

        assertThat(jsonList, hasItems(employees.get(0), employees.get(1)));
    }
}

