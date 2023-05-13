package com.bluenet.boot;

import java.util.Scanner;

public class ConsoleThread extends Thread {

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String scan = scanner.nextLine();
            String[] strings = scan.split(" ");
            switch (strings[0].toLowerCase()) {

            }
        }
    }

    @Override
    public void interrupt() {
        System.exit(0);
    }
}
