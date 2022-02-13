package com.webclient.integrationtest.webclientintegrationtest.helper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

public class Utility {


    public static void main(String[] args) {
        Utility u = new Utility();
        u.checkDate();
    }

    private void checkDate() {
        //Date d = new Date("2010-10-01T10:01:10");

        LocalDateTime ldt = LocalDateTime.parse("2010-10-01T10:01:10");

        OffsetDateTime odt = OffsetDateTime.parse("2010-10-01T10:01:10Z");

        System.out.println("Local Date is " + ldt.toString());
        System.out.println("Offset Date is " + odt.toString());
    }
}
