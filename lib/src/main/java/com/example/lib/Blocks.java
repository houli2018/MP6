package com.example.lib;

import com.example.lib.Bit;

public class Blocks {
    Bit[][] board;

    AllBlock currentBlocks;

    Blocks() {
        board = new Bit[8][11];
    }

    public void upDateBoard() {
        if (currentBlocks == null) {
            return;

        }
        for (int i = 0; i < currentBlocks.bits.length; i++) {
            board[currentBlocks.bits[i].Xvalue][currentBlocks.bits[i].Yvalue] = currentBlocks.bits[i];

        }

    }

    public class AllBlock {
        public Bit[] bits;
        public void moveAllDown() {
            if (bits == null || bits.length == 0) {
                return;
            }
            for (int i = 0; i < bits.length; i++) {
                bits[i].moveDown();
            }
        }
        public void moveAllLeft() {
            if (bits == null || bits.length == 0) {
                return;
            }
            for (int i = 0; i < bits.length; i++) {
                bits[i].moveLeft();
            }
        }
        public void moveAllRight() {
            if (bits == null || bits.length == 0) {
                return;
            }
            for (int i = 0; i < bits.length; i++) {
                bits[i].moveRight();
            }
        }
    }
    public class IBlock extends AllBlock {
        IBlock() {
            bits = new Bit[4];
            for (int i = 0; i < bits.length; i++) {
                bits[i].setXvalue(i + 2);
                bits[i].setYvalue(0);
            }
        }
    }
    public class LBlock extends AllBlock {
        LBlock() {
            bits = new Bit[4];
            bits[0].setXvalue(2);
            bits[0].setYvalue(0);
            bits[1].setXvalue(2);
            bits[1].setYvalue(1);
            bits[2].setXvalue(3);
            bits[2].setYvalue(1);
            bits[3].setXvalue(4);
            bits[3].setYvalue(1);
        }
    }
    public class OBlock extends AllBlock {
        OBlock() {
            bits = new Bit[4];
            bits[0].setXvalue(2);
            bits[0].setYvalue(0);
            bits[1].setXvalue(3);
            bits[1].setYvalue(0);
            bits[2].setXvalue(2);
            bits[2].setYvalue(1);
            bits[3].setXvalue(3);
            bits[3].setYvalue(1);
        }
    }
    public class SBlock extends AllBlock {
        SBlock() {
            bits = new Bit[4];
            bits[0].setXvalue(2);
            bits[0].setYvalue(0);
            bits[1].setXvalue(3);
            bits[1].setYvalue(0);
            bits[2].setXvalue(3);
            bits[2].setYvalue(1);
            bits[3].setXvalue(4);
            bits[3].setYvalue(1);
        }
    }
    public class TBlock extends AllBlock {
        TBlock() {
            bits = new Bit[4];
            bits[0].setXvalue(3);
            bits[0].setYvalue(0);
            bits[1].setXvalue(2);
            bits[1].setYvalue(1);
            bits[2].setXvalue(3);
            bits[2].setYvalue(1);
            bits[3].setXvalue(4);
            bits[3].setYvalue(1);
        }
    }
}
