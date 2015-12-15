package com.github.nemanjavuk.rps.ui;

import java.util.Scanner;

/**
 * Created by nemanja.
 */
public class KeyboardInput implements InputDevice {

    private Scanner keyboard;

    public KeyboardInput(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public String next() {
        return keyboard.next();
    }
}
