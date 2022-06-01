import model.BoardImpl;
import model.BoardLib;
import model.BruteSolve;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasicBoardTests {

    int[][] board1 = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}};

    int[][] board2 =  {
            {0,0,1,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,2},
            {0,0,0,0,0,5,0,0,3},
            {0,0,0,0,0,0,0,0,4},
            {0,7,0,0,0,0,0,0,5},
            {0,0,0,0,0,0,0,0,6},
            {7,8,9,0,0,0,0,0,7},
            {4,5,6,0,0,0,0,0,8},
            {1,2,3,4,5,6,7,8,9}};

    @Test
    public void emptyBoard(){
        BoardImpl bimpl1 = new BoardImpl(board1);

        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                assertEquals(0,bimpl1.getValue(r,c));
            }
        }
    }

    @Test
    public void isClue(){
        BoardImpl bimpl1 = new BoardImpl(board1);
        BoardImpl bimpl2 = new BoardImpl(board2);

        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                assertFalse(bimpl1.isClue(r,c));
            }
        }

        for (int c=0;c<9;c++){
            assertTrue(bimpl2.isClue(8,c));
        }
    }

    @Test
    public void basicBoard(){
        BoardImpl bimpl2 = new BoardImpl(board2);

        for (int c=0;c<9;c++){
            assertEquals(0,bimpl2.getValue(1,c));
        }

        assertEquals(1,bimpl2.getValue(0,2));
        assertEquals(5,bimpl2.getValue(2,5));
        assertEquals(7,bimpl2.getValue(4,1));
        assertEquals(7,bimpl2.getValue(8,6));
    }

    @Test
    public void editNum(){
        BoardImpl bimpl = new BoardImpl(board2);
        bimpl.printBoard();
        System.out.print('\n');

        bimpl.editNum(0,0,5);
        assertEquals(5,bimpl.getValue(0,0));
        assertFalse(bimpl.isClue(0,0));
        bimpl.printBoard();

        //cannot edit a clue cell
        assertTrue(bimpl.isClue(0,2));
        bimpl.editNum(0,2,5);
        assertEquals(0,bimpl.getValue(2,1));
        bimpl.printBoard();
    }

    @Test
    public void isRowLegal(){
        BoardImpl bimpl = new BoardImpl(board2);

        assertFalse(bimpl.isRowLegal(0));
        assertTrue(bimpl.isRowLegal(8));
    }

    @Test
    public void isColumnLegal(){
        BoardImpl bimpl = new BoardImpl(board2);

        assertTrue(bimpl.isColumnLegal(8));
        assertFalse(bimpl.isColumnLegal(0));
    }

    @Test
    public void isGridLegal(){
        BoardImpl bimpl = new BoardImpl(board2);

        assertFalse(bimpl.isGridLegal(0,0));
        assertTrue(bimpl.isGridLegal(6,0));
        assertFalse(bimpl.isSolved());


        BoardImpl sol = new BoardImpl(BoardLib.board1sol);
        assertTrue(sol.isGridLegal(0,0));
        assertTrue(sol.isGridLegal(3,0));
        assertTrue(sol.isGridLegal(6,0));
        assertTrue(sol.isGridLegal(0,3));
        assertTrue(sol.isGridLegal(3,3));
        assertTrue(sol.isGridLegal(6,3));
        assertTrue(sol.isGridLegal(0,6));
        assertTrue(sol.isGridLegal(3,6));
        assertTrue(sol.isGridLegal(6,6));

    }

    @Test
    public void badGridTest(){
        BoardImpl bimpl = new BoardImpl(BoardLib.badgrids);

        assertFalse(bimpl.isGridLegal(0,0));
        assertFalse(bimpl.isGridLegal(3,0));
        assertFalse(bimpl.isGridLegal(6,0));
        assertFalse(bimpl.isGridLegal(0,3));
        assertFalse(bimpl.isGridLegal(3,3));
        assertFalse(bimpl.isGridLegal(6,3));
        assertFalse(bimpl.isGridLegal(0,6));
        assertFalse(bimpl.isGridLegal(3,6));
        assertFalse(bimpl.isGridLegal(6,6));

    }

    @Test
    public void solutionTest(){
        BoardImpl bimpl = new BoardImpl(BoardLib.board1sol);

        assertTrue(bimpl.isSolved());
        bimpl.printBoard();
    }

    @Test
    public void brute(){
        BoardImpl bimpl = new BoardImpl(BoardLib.board1);
        BruteSolve brute = new BruteSolve(bimpl);
        assertFalse(bimpl.isGridLegal(0,0));
        assertTrue(bimpl.isCellLegal(0,0));

        /*brute.next();
        brute.next();
        brute.next();
        brute.previous();*/
        brute.solve();

        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                System.out.print(bimpl.getValue(r,c)+ " ");
            }
            System.out.print('\n');
        }

    }

}
