package org.example.system.controller;

import org.example.Container;

import java.util.Scanner;

public class SystemController {
    public void exit() {
        Container.getScanner().close();
    }
}
