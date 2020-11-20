/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape;

import escape.board.EscapeBoard;
import escape.coordinate.*;
import escape.coordinate.Coordinate.CoordinateType;
import escape.exception.EscapeException;
import escape.piece.EscapePiece;

/**
 * Implementation of the Escape Game Manager for the Alpha Release. This manager has very
 * little logic of its own and mostly outsources its tasks to other objects.
 * 
 * @version Nov 16, 2020
 */
public class AlphaEscapeGameManager<C extends MyCoordinate>
		implements EscapeGameManager<C>
{

	private CoordinateType coordType = null;
	private EscapeBoard board;

	/**
	 * Constructor that initializes an Alpha Escape Game Manager with the given coordinate
	 * type and board.
	 * 
	 * @param coordType
	 *            The CoordinateType that will be used for the Escape Game that this
	 *            manager manages.
	 * @param board
	 *            The board that will be used for the Escape Game that this manager
	 *            manages.
	 */
	public AlphaEscapeGameManager(CoordinateType coordType, EscapeBoard board)
	{
		this.coordType = coordType;
		this.board = board;
	}

	/**
	 * Attempts to move a piece from one given coordinate to another given coordinate.
	 * Returns true if the piece successfully moves and false if the piece cannot move for
	 * any reason. Prints an error message if the move cannot be completed.
	 * 
	 * @param from
	 *            The coordinate from which to move the target piece.
	 * @param to
	 *            The coordinate to which to move the target piece.
	 */
	@Override
	public boolean move(C from, C to)
	{
		// TODO Auto-generated method stub
		try {
			if (this.board.move(from, to)) {
				return true;
			}
			System.err.println("Movement Error: Move could not be completed");
		} catch (EscapeException e) {
			System.err.println("Movement Error: " + e.getMessage());
		}
		return false;
	}

	/**
	 * Retrieves the piece at the specified coordinate if such a piece exists. If no such
	 * piece exists or if the given coordinate if not on the board, returns null.
	 * 
	 * @param coordinate
	 *            The coordinate of the target piece.
	 * @return The piece at the specified coordinate or null if either the target
	 *         coordinate does not contain a piece or if the target coordinate is not on
	 *         the board.
	 */
	@Override
	public EscapePiece getPieceAt(C coordinate)
	{
		return this.board.getPieceAt(coordinate);
	}

	/**
	 * Generates a coordinate using the given numbers and of the same type as is
	 * appropriate for the escape game that this manager manages.
	 * 
	 * @param x
	 *            The x value of the coordinate to create.
	 * @param y
	 *            The y value of the coordinate to create.
	 * @return A coordinate with the specified values of a type that matches that used by
	 *         the escape game that this manager manages.
	 */
	@Override
	public C makeCoordinate(int x, int y)
	{
		if (this.coordType == null) {
			return (C) new SquareCoordinate(x, y);
		}
		return (C) CoordinateFactory.makeCoordinate(this.coordType, x, y);
	}

	public String getBoardString()
	{
		return this.board.toString();
	}

}
