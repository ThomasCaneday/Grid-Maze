import java.security.SecureRandom;
import java.util.Scanner;
public class GameGrid {
    public void run() {
        SecureRandom oRand = new SecureRandom();
        int[][] aiGrid = new int[10][10];
        int iWallChance = 10;
        int iTempNum;
        // LinkedList instance
        LinkedList oLinkedList = new LinkedList();
        // Total count of player moves
        int iPlayerMoves = 0;

        int iUserRow = 0; // ii1c
        int iUserCol = 0; // ii1c
        Scanner scan = new Scanner(System.in);
        String move;

        boolean bIsTrue = true; // ii1d

        // First nested for loop to see grid
        for(int x = 0; x < aiGrid.length; x++) {
            for(int y = 0; y < aiGrid[x].length; y++) {
                iTempNum = oRand.nextInt(100);

//                Check if wall should go here
                if(iTempNum < iWallChance) {
                    aiGrid[x][y] = 1;
                }
//                Else a path is inserted
                else {
                    aiGrid[x][y] = 0;
                }

                aiGrid[0][0] = 0; // ii1b
                System.out.print(aiGrid[x][y] + " ");
            }
            System.out.println();
        }

        // ii1e
        // User instructions printed to user until enters obstacle/wall
        while(bIsTrue) {
            System.out.println("Right (r) or down (d)? ");
            move = scan.nextLine();

//            iUserCol traverses y-axis now
            if(move.equals("d")) {
                iUserCol++;
                oLinkedList.addNode(iUserRow, iUserCol);
            }
//            iUserRow traverses x-axis now
            else if(move.equals("r")) {
                iUserRow++;
                oLinkedList.addNode(iUserRow, iUserCol);
            }
            else {
                System.out.println("Type either an r (right) or a d (down)");
            }

            if(aiGrid[iUserCol][iUserRow] == 1) {
                System.out.println("You failed, Thomas!");
                bIsTrue = false;
            }
            else {
                if ((iUserCol == 9) || (iUserRow == 9)) {
                    System.out.println("You won, Thomas!");
                    bIsTrue = false;
                }
            }
        }

        // Second while loop
        while(oLinkedList.headNode != null) {
            Node oHeadNode = oLinkedList.getHeadNode();
            aiGrid[oHeadNode.yPosition][oHeadNode.xPosition] = 3;
            oLinkedList.removeNode();
            iPlayerMoves++;
        }

        // Second nested for loop to see resulting grid
        for(int x = 0; x < aiGrid.length; x++) {
            for(int y = 0; y < aiGrid[x].length; y++) {

                if((x == iUserCol) && (y == iUserRow)) {
                    System.out.print("X ");
                }
                else {
                    System.out.print(aiGrid[x][y] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("Total number of player moves: " + iPlayerMoves);

        LinkedList oTestLL = oLinkedList; // change oLinkedList if you called it something else in your code.
        try{ oTestLL.addNode(333,0);System.out.println("***test-add-" + oTestLL.getHeadNode().xPosition);}
        catch(Exception ex){System.out.println("###test-add");}
        try{if(oTestLL.removeNode().xPosition == 333){System.out.println("***test-remove");}
        else{throw new Exception();}}catch(Exception ex){System.out.println("###test-remove");}
        try{int i=oTestLL.removeNode().xPosition;System.out.println("###test-empty");}
        catch(Exception ex){System.out.println("***test-empty");}

        System.out.println("Well done, Thomas Caneday");
    }
}
