/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import escape.coordinate.*;
import escape.piece.*;
import escape.piece.EscapePiece.PieceName;

/**
 * This is a simple test, not really a unit test, to make sure tht the EscapeGameBuilder,
 * in the starting code, is actually working.
 * 
 * @version May 30, 2020
 */
class EscapeGameTests
{

	// #0
	@Test
	void test() throws Exception
	{
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		assertNotNull(egb);
	}

	// #1
	@Test
	void createSquareCoordinate()
	{
		SquareCoordinate sc = new SquareCoordinate(0, 0);
		assertNotNull(sc);
	}

	// #2
	@Test
	void initializeSquareCoordinate1()
	{
		int x = 1;
		int y = 1;
		MyCoordinate sc = new SquareCoordinate(x, y);
		assertEquals(x, sc.getX());
		assertEquals(y, sc.getY());
	}

	// #3
	@Test
	void initializeSquareCoordinate2()
	{
		int x = -2;
		int y = 3;
		MyCoordinate sc = new SquareCoordinate(x, y);
		assertEquals(x, sc.getX());
		assertEquals(y, sc.getY());
	}

	// #4
	@Test
	void initializeSquareCoordinate3()
	{
		int x = 15;
		int y = 0;
		MyCoordinate sc = new SquareCoordinate(x, y);
		assertEquals(x, sc.getX());
		assertEquals(y, sc.getY());
	}

	// #5
	@Test
	void squareCoordinateDistanceY()
	{
		int x1 = 1;
		int y1 = 1;
		int x2 = 1;
		int y2 = 2;
		MyCoordinate sc1 = new SquareCoordinate(x1, y1);
		MyCoordinate sc2 = new SquareCoordinate(x2, y2);
		assertEquals(1, sc1.DistanceTo(sc2));
	}

	// #6
	@Test
	void squareCoordinateDistanceX()
	{
		int x1 = 1;
		int y1 = 1;
		int x2 = 5;
		int y2 = 1;
		MyCoordinate sc1 = new SquareCoordinate(x1, y1);
		MyCoordinate sc2 = new SquareCoordinate(x2, y2);
		assertEquals(4, sc1.DistanceTo(sc2));
	}

	// #7
	@Test
	void squareCoordinateDistanceXY()
	{
		int x1 = 2;
		int y1 = 3;
		int x2 = 8;
		int y2 = 5;
		MyCoordinate sc1 = new SquareCoordinate(x1, y1);
		MyCoordinate sc2 = new SquareCoordinate(x2, y2);
		assertEquals(6, sc1.DistanceTo(sc2));
	}

	// #8
	@Test
	void squareCoordinateDistanceYX()
	{
		int x1 = -1;
		int y1 = -3;
		int x2 = 2;
		int y2 = 4;
		MyCoordinate sc1 = new SquareCoordinate(x1, y1);
		MyCoordinate sc2 = new SquareCoordinate(x2, y2);
		assertEquals(7, sc1.DistanceTo(sc2));
	}

	// #9
	@Test
	void squareCoordinateDistanceSelf()
	{
		int x1 = 3;
		int y1 = 4;
		int x2 = 3;
		int y2 = 4;
		MyCoordinate sc1 = new SquareCoordinate(x1, y1);
		MyCoordinate sc2 = new SquareCoordinate(x2, y2);
		assertEquals(0, sc1.DistanceTo(sc2));
	}

	// #10
	@Test
	void escapeGameManagerShouldCreate()
	{
		try {
			EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
			EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
			assertNotNull(egm);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Escape Game Builder threw exception: " + e.getMessage());
		}
	}

	// #11
	@Test
	void egmMakesCoordiate1()
	{
		int x = 1;
		int y = 1;
		try {
			EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
			EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
			MyCoordinate c = egm.makeCoordinate(x, y);
			assertNotNull(c);
			assertEquals(x, c.getX());
			assertEquals(y, c.getY());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Escape Game Builder threw exception: " + e.getMessage());
		}
	}

	// #12
	@Test
	void egmMakesCoordiate2()
	{
		int x = 2;
		int y = 4;
		try {
			EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
			EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
			MyCoordinate c = egm.makeCoordinate(x, y);
			assertNotNull(c);
			assertEquals(x, c.getX());
			assertEquals(y, c.getY());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Escape Game Builder threw exception: " + e.getMessage());
		}
	}

	// #13
	@Test
	void egmMakesCoordiate3()
	{
		int x = 8;
		int y = 9;
		try {
			EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
			EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
			MyCoordinate c = egm.makeCoordinate(x, y);
			assertNotNull(c);
			assertEquals(x, c.getX());
			assertEquals(y, c.getY());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Escape Game Builder threw exception: " + e.getMessage());
		}
	}

	// #14
	@Test
	void egbMakesEgm() throws Exception
	{
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		assertNotNull(egm);
	}

	// #15
	@Test
	void findP1Snail() throws Exception
	{
		int x = 4;
		int y = 4;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c = egm.makeCoordinate(x, y);
		EscapePiece piece = egm.getPieceAt(c);
		assertNotNull(piece);
		assertEquals(piece.getName(), PieceName.SNAIL);
		assertEquals(piece.getPlayer(), Player.PLAYER1);
		System.out.println("What the board looks like: "
				+ ((AlphaEscapeGameManager) egm).getBoardString());
	}

	// #16
	@Test
	void findP2Horse() throws Exception
	{
		int x = 10;
		int y = 12;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c = egm.makeCoordinate(x, y);
		EscapePiece piece = egm.getPieceAt(c);
		assertNotNull(piece);
		assertEquals(piece.getName(), PieceName.HORSE);
		assertEquals(piece.getPlayer(), Player.PLAYER2);
	}

	// #17
	@Test
	void findNothingOnClear() throws Exception
	{
		int x = 1;
		int y = 1;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c = egm.makeCoordinate(x, y);
		EscapePiece piece = egm.getPieceAt(c);
		assertNull(piece);
	}

	// #18
	@Test
	void findNothingOffBoard1() throws Exception
	{
		int x = -1;
		int y = -1;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c = egm.makeCoordinate(x, y);
		EscapePiece piece = egm.getPieceAt(c);
		assertNull(piece);
	}

	// #19
	@Test
	void findNothingOffBoard2() throws Exception
	{
		int x = 50;
		int y = 50;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c = egm.makeCoordinate(x, y);
		EscapePiece piece = egm.getPieceAt(c);
		assertNull(piece);
	}

	// #20
	@Test
	void findNothingOnBlock() throws Exception
	{
		int x = 3;
		int y = 5;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c = egm.makeCoordinate(x, y);
		EscapePiece piece = egm.getPieceAt(c);
		assertNull(piece);
	}

	// #21
	@Test
	void moveSucceedsOnValidMove() throws Exception
	{
		int x1 = 4;
		int y1 = 4;
		int x2 = 5;
		int y2 = 5;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertTrue(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c1));
		EscapePiece piece = egm.getPieceAt(c2);
		assertNotNull(piece);
		assertEquals(piece.getName(), PieceName.SNAIL);
		assertEquals(piece.getPlayer(), Player.PLAYER1);
	}

	// #22
	@Test
	void moveFailsOnBlock() throws Exception
	{
		int x1 = 4;
		int y1 = 4;
		int x2 = 3;
		int y2 = 5;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertFalse(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c2));
		EscapePiece piece = egm.getPieceAt(c1);
		assertNotNull(piece);
		assertEquals(piece.getName(), PieceName.SNAIL);
		assertEquals(piece.getPlayer(), Player.PLAYER1);
	}

	// #23
	@Test
	void moveSucceedsOnCapture() throws Exception
	{
		int x1 = 4;
		int y1 = 4;
		int x2 = 10;
		int y2 = 12;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertTrue(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c1));
		EscapePiece piece = egm.getPieceAt(c2);
		assertNotNull(piece);
		assertEquals(piece.getName(), PieceName.SNAIL);
		assertEquals(piece.getPlayer(), Player.PLAYER1);
	}

	// #24
	@Test
	void moveSucceedsOnExit() throws Exception
	{
		int x1 = 4;
		int y1 = 4;
		int x2 = 5;
		int y2 = 12;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertTrue(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c1));
		assertNull(egm.getPieceAt(c2));
	}

	// #25
	@Test
	void moveFailsOutOfBounds1() throws Exception
	{
		int x1 = 4;
		int y1 = 4;
		int x2 = 50;
		int y2 = 50;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertFalse(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c2));
		EscapePiece piece = egm.getPieceAt(c1);
		assertNotNull(piece);
		assertEquals(piece.getName(), PieceName.SNAIL);
		assertEquals(piece.getPlayer(), Player.PLAYER1);
	}

	// #26
	@Test
	void moveFailsOutOfBounds2() throws Exception
	{
		int x1 = 4;
		int y1 = 4;
		int x2 = -1;
		int y2 = -1;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertFalse(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c2));
		EscapePiece piece = egm.getPieceAt(c1);
		assertNotNull(piece);
		assertEquals(piece.getName(), PieceName.SNAIL);
		assertEquals(piece.getPlayer(), Player.PLAYER1);
	}

	// #27
	@Test
	void moveToSelfFails() throws Exception
	{
		int x1 = 4;
		int y1 = 4;
		int x2 = 4;
		int y2 = 4;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertTrue(egm.move(c1, c2));
		EscapePiece piece = egm.getPieceAt(c1);
		assertNotNull(piece);
		assertEquals(piece.getName(), PieceName.SNAIL);
		assertEquals(piece.getPlayer(), Player.PLAYER1);
	}

	// #28
	@Test
	void moveNoPieceFails1() throws Exception
	{
		int x1 = 3;
		int y1 = 3;
		int x2 = 5;
		int y2 = 5;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertFalse(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c1));
		assertNull(egm.getPieceAt(c2));
	}

	// #29
	@Test
	void moveNoPieceFails2() throws Exception
	{
		int x1 = -1;
		int y1 = -1;
		int x2 = 5;
		int y2 = 5;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertFalse(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c1));
		assertNull(egm.getPieceAt(c2));
	}

	// #30
	@Test
	void moveNoPieceFails3() throws Exception
	{
		int x1 = 3;
		int y1 = 3;
		int x2 = -1;
		int y2 = -1;
		EscapeGameBuilder egb = new EscapeGameBuilder("config/egc/test1.egc");
		EscapeGameManager<SquareCoordinate> egm = egb.makeGameManager();
		SquareCoordinate c1 = egm.makeCoordinate(x1, y1);
		SquareCoordinate c2 = egm.makeCoordinate(x2, y2);
		assertFalse(egm.move(c1, c2));
		assertNull(egm.getPieceAt(c1));
		assertNull(egm.getPieceAt(c2));
	}

}
