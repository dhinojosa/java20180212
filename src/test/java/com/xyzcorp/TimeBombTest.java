package com.xyzcorp;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class TimeBombTest {
    @Test
    public void testMulticatchSQLAndIOException() {
        TimeBomb timeBomb = new TimeBomb();

        try {
            timeBomb.thisWillThrowASQLException();
            timeBomb.thisWillThrowAIOException();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMulticatchMalformedURLAndIOException() {
        TimeBomb timeBomb = new TimeBomb();

        try {
            timeBomb.thisWillThrowAMalformedURLException();
            timeBomb.thisWillThrowAIOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGoingThroughMultipleExceptions() {
        TimeBomb timeBomb = new TimeBomb();

        try {
            timeBomb.thisWillThrowAMalformedURLException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            timeBomb.thisWillThrowAIOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUsingAssertJ() {
        TimeBomb timeBomb = new TimeBomb();
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                timeBomb.thisWillThrowAIOException();
            }
        }).isInstanceOf(IOException.class);
    }
}









