package org.example.system.controller;

import org.example.Container;
public class SystemController {
    public void exit() {
        Container.getScanner().close();
    }
}
