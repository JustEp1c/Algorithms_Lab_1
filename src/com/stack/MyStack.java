package com.stack;

import java.util.Stack;

public class MyStack extends Stack {

    //Класс реализации стека и сортировки

    public MyStack() {
        Main.N_op += 1;
    }

    public Object get() {
        Main.N_op += 5;
        int     len = size();

        if (len == 0) return null;

        return elementAt(len - 1);
    }

    public  Object remove() {
        Main.N_op += 2;
        return pop();
    }

    public Object set(Object object) {
        Main.N_op += 2;
        return push(object);
    }

    public int count() {
        Main.N_op += 2;
        return this.size();
    }

    public MyStack  sort() {

        int childStackCount = this.count() / 2;
        MyStack childStack1 = new MyStack();
        MyStack childStack2 = new MyStack();
        MyStack childStack3 = new MyStack();
        Main.N_op += 2;

        for (int i = 0; i < childStackCount; i++) {

            int upperElement = (int) this.remove();
            childStack1.set(upperElement);
            Main.N_op += 4;
        }
        while ((this.count() != 0 && childStack1.count() != 0 || childStack3.count() != 0)) {
            Main.N_op += 5;

            while (this.count() != 0 || childStack1.count() != 0) {
                Main.N_op += 3;
                firstStageOfSorting(childStack1, childStack2);
                if (this.count() != 0 || childStack1.count() != 0) {
                    secondStageOfSorting(childStack1, childStack3);
                    Main.N_op += 3;
                }

            }

            if (childStack3.count() != 0) {
                Main.N_op += 1;
                int childStack2Count = childStack2.count();
                int childStack3Count = childStack3.count();
                Main.N_op += 2;
                for (int i = 0; i < childStack2Count; i++) {

                    int upperElement = (int) childStack2.remove();
                    this.set(upperElement);
                    Main.N_op += 4;
                }
                for (int i = 0; i < childStack3Count; i++) {

                    int upperElement = (int) childStack3.remove();
                    childStack1.set(upperElement);
                    Main.N_op += 4;
                }
            }

        }
        Main.N_op += 1;
        return childStack2;

    }

    public void firstStageOfSorting(MyStack childStack1, MyStack childStack2) {

        int checker = 0;
        Main.N_op += 1;
        while (checker == 0) {
            Main.N_op += 1;
            if (this.get() == null) {
                checker = 1;
                Main.N_op += 2;
            }
            if (childStack1.get() == null) {
                checker = 2;
                Main.N_op += 2;
            }

            if (checker == 0) {
                Main.N_op += 1;
                int upperElement1 = (int) this.get();
                int upperElement2 = (int) childStack1.get();
                Main.N_op += 4;

                if (upperElement1 <= upperElement2) {
                    Main.N_op += 1;
                    childStack2.set(upperElement1);
                    int lastBiggerElement = (int) this.remove();
                    Main.N_op += 3;
                    if (this.get() == null || (int) this.get() < lastBiggerElement) {

                        checker = 1;
                        Main.N_op += 5;
                    }
                }
                else {
                    childStack2.set(upperElement2);
                    int lastBiggerElement = (int) childStack1.remove();
                    Main.N_op += 2;
                    if (childStack1.get() == null || (int) childStack1.get() < lastBiggerElement) {

                        checker = 2;
                        Main.N_op += 5;
                    }
                }
            }

        }
        if (checker == 1) {
            int topElement;
            Main.N_op += 2;
            do {
                topElement = (int) childStack1.get();
                childStack2.set(topElement);
                childStack1.remove();
                Main.N_op += 6;
            }
            while (childStack1.get() != null && (int) childStack1.get() > topElement);
        }

        if (checker == 2) {
            int topElement;
            Main.N_op += 2;
            do {
                topElement = (int) this.get();
                childStack2.set(topElement);
                this.remove();
                Main.N_op += 6;
            }
            while (this.get() != null && (int) this.get() > topElement);
        }
    }

    public void secondStageOfSorting(MyStack childStack1, MyStack childStack3) {

        int checker = 0;
        Main.N_op += 1;
        while (checker == 0) {
            Main.N_op += 1;
            if (this.get() == null) {
                checker = 1;
                Main.N_op += 2;
            }
            if (childStack1.get() == null) {
                checker = 2;
                Main.N_op += 2;
            }

            if (checker == 0) {
                Main.N_op += 1;
                int upperElement1 = (int) this.get();
                int upperElement2 = (int) childStack1.get();
                Main.N_op += 4;

                if (upperElement1 <= upperElement2) {
                    Main.N_op += 1;
                    childStack3.set(upperElement1);
                    int lastBiggerElement = (int) this.remove();
                    Main.N_op += 2;
                    if (this.get() == null || (int) this.get() < lastBiggerElement) {
                        checker = 1;
                        Main.N_op += 5;
                    }
                }
                else {
                    childStack3.set(upperElement2);
                    int lastBiggerElement = (int) childStack1.remove();
                    Main.N_op += 2;
                    if (childStack1.get() == null || (int) childStack1.get() < lastBiggerElement) {
                        checker = 2;
                        Main.N_op += 5;
                    }
                }
            }

        }
        if (checker == 1) {
            int topElement;
            Main.N_op += 2;
            do {
                topElement = (int) childStack1.get();
                childStack3.set(topElement);
                childStack1.remove();
                Main.N_op += 6;
            }
            while (childStack1.get() != null && (int) childStack1.get() > topElement);
        }

        if (checker == 2) {
            int topElement;
            Main.N_op += 2;
            do {
                topElement = (int) this.get();
                childStack3.set(topElement);
                this.remove();
                Main.N_op += 6;
            }
            while (this.get() != null && (int) this.get() > topElement);
        }
    }

}
