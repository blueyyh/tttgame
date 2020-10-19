package com.bix.interview.ttt;

import java.io.ByteArrayInputStream;

/**
 * I should use junit, but just for demo I don't want to include maven and make it simple *
 */
public class GameTest {

    private ByteArrayInputStream testIn;


    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    public void test_palyer_x_win() {

        final String testString = "1\n\r2\n\r3\n\r4\n\r5\n\r6\n\r7\n\r8\n\r9\n\r";
        provideInput(testString);

        Main.main(new String[0]);
        assert "X".equals(Main.winner);

    }

    public void test_draw() {

        final String testString = "1\n\r2\n\r3\n\r4\n\r7\n\r5\n\r6\n\r9\n\r8\n\r";
        provideInput(testString);
        Main.winner = null;
        Main.main(new String[0]);
        assert "DRAW".equals(Main.winner);

    }

    public static void main(String[] args) {
        System.out.println("******Test Player X win*****");
        GameTest test = new GameTest();
        test.test_palyer_x_win();
        System.out.println("");
        System.out.println("");
        System.out.println("******Test Draw*******");
        GameTest test2 = new GameTest();
        test2.test_draw();
    }
}
