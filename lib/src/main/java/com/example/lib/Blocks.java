package com.example.lib;

import com.example.lib.Bit;
import java.util.ArrayList;

public class Blocks {
    public static Integer score;

    public void cancleLines() {
        int l = this.scored();
        System.out.println(l);
        if (l < 0) {
            System.out.println(l);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[i][l].Yvalue = -1;

        }
        for (int j = l; j > 0; j--) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == null) {
                    continue;

                } else {
                    board[i][j].Yvalue++;
                }

            }

        }
        this.board = upDateBoard();
        cancleLines();

    }
    public int scored() {
        if (board == null) {
            return -2;

        }
        for (int j = board[0].length - 1; j >= 0; j--) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != null) {
                    count++;

                }


            }
            if (count == board.length) {
                System.out.print(j);
                return j;

            }

        }
        System.out.print(-1);
        return -1;
    }
    public Bit[][] board;

    public int[] edge;

    public void updateEdge() {
        if (edge == null) {
            edge = new int[8];
            for (int i = 0; i < edge.length; i++) {
                edge[i] = board[i].length;

            }

        }
        if (board == null) {
            board = new Bit[8][11];

        }
        for (int i = 0; i < board.length; i++) {
            boolean a = true;
            for (int j = 0; j < board[i].length; j++) {
                edge[i] = j;
                if (board[i][j] != null) {
                    a = false;
                    //System.out.println(i + "|" + edge[i]);
                    break;

                }

            }
            if (a) {
                edge[i]++;

            }

        }

    }
    //Very Important.

    public static ArrayList<AllBlock> currentBlocks;

    public Blocks() {
        board = new Bit[8][11];
    }

    public void createAllBlocks() {
        if (currentBlocks == null) {
            currentBlocks = new ArrayList<>(0);
        }
        double random = Math.random();
        if (random < 0.2) {
            updateEdge();
            currentBlocks.add(new IBlock());
            return;


        } else if (random < 0.4) {
            updateEdge();
            currentBlocks.add(new SBlock());
            return;

        } else if (random < 0.6) {
            updateEdge();
            currentBlocks.add(new TBlock());
            return;

        } else if (random < 0.8) {
            updateEdge();
            currentBlocks.add(new OBlock());
            return;

        } else {
            updateEdge();
            currentBlocks.add(new LBlock());
            return;

        }
    }

    public Blocks createBoard() {
        Blocks toReturn = new Blocks();
        return toReturn;

    }

    public Bit[][] upDateBoard() {
        if (currentBlocks == null) {
            return null;

        }
        board = new Bit[8][11];
        for (int j = 0; j < currentBlocks.size(); j++) {
            for (int i = 0; i < currentBlocks.get(j).bits.length; i++) {
                if (currentBlocks.get(j).bits[i].Yvalue == -1) {
                    continue;

                }
                board[currentBlocks.get(j).bits[i].Xvalue][currentBlocks.get(j).bits[i].Yvalue] = currentBlocks.get(j).bits[i];

            }


        }
        return this.board;

    }
    public void canclleLines1() {
        boolean createNew = false;
        while (true) {
            int toCancle = -1;
            for (int j = board[0].length - 1; j > 0; j--) {
                boolean line = true;
                for (int i = 0; i < board.length; i++) {
                    if (board[i][j] == null) {
                        line = false;


                    }



                }
                if (line) {
                    toCancle = j;
                    break;

                }
            }
            if (toCancle == -1) {
                break;

            }
            createNew = true;
            for (int i = 0; i < board.length; i++) {
                board[i][toCancle] = null;

            }
            for (int j = toCancle; j > 0; j--) {
                for (int i = 0; i < board.length; i++) {
                    board[i][j] = board[i][j - 1];
                    if (board[i][j] == null) {
                        continue;

                    }
                    board[i][j].Yvalue++;

                }

            }

        }
        if (createNew) {
            createAllBlocks();
            board = new Bit[8][11];
            for (int j = 0; j < currentBlocks.size(); j++) {
                for (int i = 0; i < currentBlocks.get(j).bits.length; i++) {
                    board[currentBlocks.get(j).bits[i].Xvalue][currentBlocks.get(j).bits[i].Yvalue] = currentBlocks.get(j).bits[i];

                }


            }

        }
    }
    public void moveAllDown() {
        if (currentBlocks == null) {
            return;

        }
        AllBlock input = currentBlocks.get(currentBlocks.size() - 1);
        if (input.bits == null || input.bits.length == 0 || input.unmovable) {
            return;
        }
        for (int i = 0; i < input.bits.length; i++) {
            input.bits[i].Yvalue++;
        }
        if (input.canNotMove()) {
            for (int i = 0; i < input.bits.length; i++) {
                input.bits[i].Yvalue--;
            }



        }
        cancleLines();
    }
    public void moveAllLeft() {
        if (currentBlocks == null) {
            return;

        }

        AllBlock input = currentBlocks.get(currentBlocks.size() - 1);
        if (input.bits == null || input.bits.length == 0 || input.unmovable) {
            return;
        }
        boolean canMove = true;
        for (int i = 0; i < input.bits.length; i++) {
            input.bits[i].Xvalue--;
            if (input.bits[i].Xvalue < 0 ) {
                canMove = false;

            } else if (board[input.bits[i].Xvalue][input.bits[i].Yvalue] != null) {
                boolean in = false;
                for (int j = 0; j < 4; j++) {
                    if ((board[input.bits[i].Xvalue][input.bits[i].Yvalue] == input.bits[j])) {
                        in = true;

                    }

                }
                if (!in) {
                    canMove = false;

                }

            }
        }
        if (!canMove) {
            for (int i = 0; i < input.bits.length; i++) {
                input.bits[i].Xvalue++;


            }
        }
    }
    public void moveAllRight() {
        if (currentBlocks == null) {
            return;

        }

        AllBlock input = currentBlocks.get(currentBlocks.size() - 1);
        if (input.bits == null || input.bits.length == 0 || input.unmovable) {
            return;
        }
        boolean canMove = true;
        for (int i = 0; i < input.bits.length; i++) {
            input.bits[i].Xvalue++;
            if (input.bits[i].Xvalue > 7) {
                canMove = false;

            } else if (board[input.bits[i].Xvalue][input.bits[i].Yvalue] != null) {
                boolean in = false;
                for (int j = 0; j < 4; j++) {
                    if ((board[input.bits[i].Xvalue][input.bits[i].Yvalue] == input.bits[j])) {
                        in = true;

                    }

                }
                if (!in) {
                    canMove = false;

                }

            }
        }
        if (!canMove) {
            for (int i = 0; i < input.bits.length; i++) {
                input.bits[i].Xvalue--;


            }
        }
    }


    public class AllBlock {
        public boolean unmovable = false;

        public boolean canNotMove() {
            if (bits == null || edge == null) {
                //System.out.println("true");
                return true;

            }
            for (int i = 0; i < 4; i++) {
                //System.out.println(bits[i].Xvalue + "/" + bits[i].Yvalue + ":" + edge[bits[i].Xvalue]);
                if (bits[i].Yvalue == edge[bits[i].Xvalue]) {
                    //System.out.println("true");
                    unmovable = true;
                    return true;

                }


            }
            //System.out.println("false");
            return false;
        }
        public boolean canNotRotate() {
            AllBlock input = currentBlocks.get(currentBlocks.size() - 1);
            boolean canMove = true;
            for (int i = 0; i < 4; i++) {
                if (board[input.bits[i].Xvalue][input.bits[i].Yvalue] != null) {
                    boolean in = false;
                    for (int j = 0; j < 4; j++) {
                        if ((board[input.bits[i].Xvalue][input.bits[i].Yvalue] == input.bits[j])) {
                            in = true;

                        }

                    }
                    if (!in) {
                        canMove = false;

                    }

                }

            }
            return !canMove;
        }
        public void rotate() {}
        public Bit[] bits;
    }
    public class IBlock extends AllBlock {
        IBlock() {
            bits = new Bit[4];
            for (int i = 0; i < 4; i++) {
                bits[i] = new Bit();

            }
            for (int i = 0; i < bits.length; i++) {
                bits[i].setXvalue(i + 2);
                bits[i].setYvalue(0);
            }
        }
        public int IRotate = 0;
        public void rotate() {
            if (this.canNotMove() || unmovable || canNotRotate()) {
                return;

            }
            if (IRotate % 2 == 0) {
                if (bits[3].Yvalue - 2 < 0 || bits[0].Yvalue + 1 > 10) {
                    return;
                }
                bits[0].Xvalue++;
                bits[0].Yvalue++;
                bits[2].Xvalue--;
                bits[2].Yvalue--;
                bits[3].Xvalue -= 2;
                bits[3].Yvalue -= 2;
                if (canNotRotate()) {
                    bits[0].Xvalue--;
                    bits[0].Yvalue--;
                    bits[2].Xvalue++;
                    bits[2].Yvalue++;
                    bits[3].Xvalue += 2;
                    bits[3].Yvalue += 2;
                    return;

                }
                IRotate++;
                return;
            } else {
                if (bits[3].Xvalue + 2 > 7 || bits[0].Xvalue - 1 < 0) {
                    return;
                }
                bits[0].Xvalue--;
                bits[0].Yvalue--;
                bits[2].Xvalue++;
                bits[2].Yvalue++;
                bits[3].Xvalue += 2;
                bits[3].Yvalue += 2;
                if (canNotRotate()) {
                    bits[0].Xvalue++;
                    bits[0].Yvalue++;
                    bits[2].Xvalue--;
                    bits[2].Yvalue--;
                    bits[3].Xvalue -= 2;
                    bits[3].Yvalue -= 2;
                    return;

                }

                IRotate++;
                return;
            }
        }
    }
    public class LBlock extends AllBlock {
        LBlock() {
            bits = new Bit[4];
            for (int i = 0; i < 4; i++) {
                bits[i] = new Bit();

            }
            bits[0].setXvalue(2);
            bits[0].setYvalue(0);
            bits[1].setXvalue(2);
            bits[1].setYvalue(1);
            bits[2].setXvalue(3);
            bits[2].setYvalue(1);
            bits[3].setXvalue(4);
            bits[3].setYvalue(1);
        }
        public int LRotate = 0;
        public void rotate() {
            if (this.canNotMove() || unmovable || canNotRotate()) {
                return;

            }
            if (LRotate % 4 == 0) {
                if (bits[0].Xvalue - 1 < 0 || bits[0].Yvalue + 1 > 10
                        || bits[3].Xvalue - 2 < 0 || bits[3].Yvalue - 2 < 0) {
                    return;
                }
                bits[0].Xvalue--;
                bits[0].Yvalue++;
                bits[2].Xvalue--;
                bits[2].Yvalue--;
                bits[3].Xvalue -=2;
                bits[3].Yvalue -=2;
                if (canNotRotate()) {
                    bits[0].Xvalue++;
                    bits[0].Yvalue--;
                    bits[2].Xvalue++;
                    bits[2].Yvalue++;
                    bits[3].Xvalue +=2;
                    bits[3].Yvalue +=2;
                    return;

                }
                LRotate++;
                return;
            } else if (LRotate % 4 == 1) {
                if (bits[0].Yvalue + 1 > 10 || bits[3].Xvalue - 2 < 0) {
                    return;
                }
                bits[0].Yvalue++;
                bits[0].Xvalue++;
                bits[2].Xvalue--;
                bits[2].Yvalue++;
                bits[3].Xvalue -= 2;
                bits[3].Yvalue += 2;
                if (canNotRotate()) {
                    bits[0].Yvalue--;
                    bits[0].Xvalue--;
                    bits[2].Xvalue++;
                    bits[2].Yvalue--;
                    bits[3].Xvalue += 2;
                    bits[3].Yvalue -= 2;
                    return;

                }
                LRotate++;
                return;
            } else if (LRotate % 4 == 2) {
                if (bits[3].Yvalue + 2 > 10 || bits[0].Xvalue + 1 > 7) {
                    return;
                }
                bits[0].Yvalue--;
                bits[0].Xvalue++;
                bits[2].Xvalue++;
                bits[2].Yvalue++;
                bits[3].Xvalue += 2;
                bits[3].Yvalue += 2;
                if (canNotRotate()) {
                    bits[0].Yvalue++;
                    bits[0].Xvalue--;
                    bits[2].Xvalue--;
                    bits[2].Yvalue--;
                    bits[3].Xvalue -= 2;
                    bits[3].Yvalue -= 2;
                    return;

                }
                LRotate++;
                return;
            } else {
                if (bits[3].Xvalue + 2 > 7 || bits[0].Yvalue - 1 < 0) {
                    return;
                }
                bits[0].Yvalue--;
                bits[0].Xvalue--;
                bits[2].Xvalue++;
                bits[2].Yvalue--;
                bits[3].Xvalue += 2;
                bits[3].Yvalue -= 2;
                if (canNotRotate()) {
                    bits[0].Yvalue++;
                    bits[0].Xvalue++;
                    bits[2].Xvalue--;
                    bits[2].Yvalue++;
                    bits[3].Xvalue -= 2;
                    bits[3].Yvalue += 2;
                    return;

                }
                LRotate++;
                return;
            }
        }
    }
    public class OBlock extends AllBlock {
        OBlock() {
            bits = new Bit[4];
            for (int i = 0; i < 4; i++) {
                bits[i] = new Bit();

            }
            bits[0].setXvalue(2);
            bits[0].setYvalue(0);
            bits[1].setXvalue(3);
            bits[1].setYvalue(0);
            bits[2].setXvalue(2);
            bits[2].setYvalue(1);
            bits[3].setXvalue(3);
            bits[3].setYvalue(1);
        }
        public void rotate() {
            return;
        }
    }
    public class SBlock extends AllBlock {
        SBlock() {
            bits = new Bit[4];
            for (int i = 0; i < 4; i++) {
                bits[i] = new Bit();

            }
            bits[0].setXvalue(2);
            bits[0].setYvalue(0);
            bits[1].setXvalue(3);
            bits[1].setYvalue(0);
            bits[2].setXvalue(3);
            bits[2].setYvalue(1);
            bits[3].setXvalue(4);
            bits[3].setYvalue(1);
        }

        public int SRotate = 0;
        public void rotate() {
            if (this.canNotMove() || unmovable || canNotRotate()) {
                return;

            }
            if (SRotate % 2 == 0) {
                if (bits[0].Yvalue + 1 > 10 || bits[3].Yvalue + 1 > 10 || bits[3].Xvalue - 2 < 0) {
                    return;

                }
                bits[0].Yvalue++;
                bits[3].Yvalue++;
                bits[3].Xvalue--;
                bits[3].Xvalue--;
                if (canNotRotate()) {
                    bits[0].Yvalue--;
                    bits[3].Yvalue--;
                    bits[3].Xvalue++;
                    bits[3].Xvalue++;
                    return;

                }
                SRotate++;
                return;


            } else {
                if (bits[0].Yvalue - 1 < 0 || bits[3].Yvalue - 1 < 0 || bits[3].Xvalue + 2 > 7) {
                    return;

                }
                bits[0].Yvalue--;
                bits[3].Yvalue--;
                bits[3].Xvalue++;
                bits[3].Xvalue++;
                if (canNotRotate()) {
                    bits[0].Yvalue++;
                    bits[3].Yvalue++;
                    bits[3].Xvalue--;
                    bits[3].Xvalue--;
                    return;

                }
                SRotate++;
                return;
            }

        }
    }
    public class TBlock extends AllBlock {
        TBlock() {
            bits = new Bit[4];
            for (int i = 0; i < 4; i++) {
                bits[i] = new Bit();

            }
            bits[0].setXvalue(3);
            bits[0].setYvalue(0);
            bits[1].setXvalue(2);
            bits[1].setYvalue(1);
            bits[2].setXvalue(3);
            bits[2].setYvalue(1);
            bits[3].setXvalue(4);
            bits[3].setYvalue(1);
        }
        public int TRotate = 0;
        public void rotate() {
            if (this.canNotMove() || unmovable) {
                return;

            }
            if (TRotate % 4 == 0) {
                if (bits[3].Yvalue + 1 > 10) {
                    return;
                }
                bits[3].Yvalue++;
                bits[3].Xvalue--;
                if (canNotRotate()) {
                    bits[3].Yvalue--;
                    bits[3].Xvalue++;
                    return;

                }
                TRotate++;
                return;
            } else if (TRotate % 4 == 1) {
                if (bits[0].Xvalue + 1 > 7) {
                    return;
                }
                bits[0].Yvalue ++;
                bits[0].Xvalue ++;
                if (canNotRotate()) {
                    bits[0].Yvalue --;
                    bits[0].Xvalue --;
                    return;

                }
                TRotate++;
                return;
            } else if (TRotate % 4 == 2) {
                if (bits[1].Yvalue - 1 < 0) {
                    return;
                }
                bits[1].Yvalue--;
                bits[1].Xvalue++;
                if (canNotRotate()) {
                    bits[1].Yvalue++;
                    bits[1].Xvalue--;
                    return;

                }
                TRotate++;
                return;
            } else {
                if (bits[1].Xvalue - 1 < 0) {
                    return;
                }
                bits[0].Yvalue--;
                bits[0].Xvalue--;
                bits[1].Yvalue++;
                bits[1].Xvalue--;
                bits[3].Yvalue--;
                bits[3].Xvalue++;
                if (canNotRotate()) {
                    bits[0].Yvalue++;
                    bits[0].Xvalue++;
                    bits[1].Yvalue--;
                    bits[1].Xvalue++;
                    bits[3].Yvalue++;
                    bits[3].Xvalue--;
                    return;

                }

                TRotate++;
                return;
            }
        }
    }
}
