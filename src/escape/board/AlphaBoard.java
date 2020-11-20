/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.board;

import java.util.HashMap;
import escape.coordinate.Coordinate.CoordinateType;
import escape.coordinate.MyCoordinate;
import escape.exception.EscapeException;
import escape.piece.*;
import escape.util.StringManager;

/**
 * An implementation of the Board interface for the Alpha release. This board
 * implementation keeps track of the location of each piece, as well as the location of
 * special terrain.
 * 
 * @version Nov 16, 2020
 */
public class AlphaBoard implements EscapeBoard
{
	private HashMap<String, LocationType> spaces;
	private HashMap<String, MyEscapePiece> pieces;
	private CoordinateType coordType;
	private int xMax;
	private int yMax;
	private MovementValidator validator;

	/**
	 * Constructor for AlphaBoard to set up the basic characteristics of the board. Takes
	 * in the dimensions of the board (or an indication that the board is finite), and the
	 * board's coordinate type. The pieces and terrain of the board are set after
	 * construction.
	 * 
	 * @param xMax
	 *            The maximum x coordinate if the board is finite, otherwise null
	 * @param yMax
	 *            The maximum y coordinate if the board is finite, otherwise null
	 * @param coordType
	 *            The coordinate type of the board
	 */
	public AlphaBoard(int xMax, int yMax, CoordinateType coordType)
	{
		this.xMax = xMax;
		this.yMax = yMax;
		this.coordType = coordType;
	}

	/**
	 * Populates the board with pieces and terrain according to the given hashmaps. The
	 * hashmap of terrain should only contain spaces that are not CLEAR or null.
	 * 
	 * @param pieces
	 *            A Hashmap of the pieces with which to populate the board.
	 * @param spaces
	 *            A Hashmap of special terrain on the board. LocationTypes should not be
	 *            CLEAR nor null.
	 */
	public void setBoard(HashMap<String, MyEscapePiece> pieces,
			HashMap<String, LocationType> spaces)
	{
		this.pieces = pieces;
		this.spaces = spaces;
	}

	/**
	 * Initializes this board's movement validator
	 * 
	 * @param validator
	 *            The movement validator that should be used to validate movement on this
	 *            board
	 */
	public void setValidator(MovementValidator validator)
	{
		this.validator = validator;
	}

	/**
	 * Attempts to move a piece from the given coordinate to the given coordinate. Returns
	 * true on success or throws an exception if the move is invalid. A valid move is (in
	 * the Alpha release) one that moves from an occupied coordinate to a vacant CLEAR
	 * coordinate.
	 * 
	 * @param from
	 *            The coordinate on which the target piece to move currently resides.
	 * @param to
	 *            The coordinate to which to move the target piece.
	 * @throws EscapeException
	 *             A message describing how the move given is invalid.
	 * @return true if the move given is valid. Otherwise, an exception is thrown.
	 */
	@Override
	public boolean move(MyCoordinate from, MyCoordinate to) throws EscapeException
	{
		FilledEscapeSpace fromSpace = coordToFilled(from);
		FilledEscapeSpace toSpace = coordToFilled(to);
		String fromString = StringManager.coordToString(from);
		String toString = StringManager.coordToString(to);

		if (isOffBoard(from) || isOffBoard(to)) {
			throw new EscapeException("Cannot perform movement beyond board from "
					+ fromSpace + " to " + toSpace);
		} else {

		}

		MovementResult result = this.validator.validate(fromSpace, toSpace);
		switch (result) {
			case EXIT:
				this.pieces.remove(fromString);
				return true;
			case CAPTURE:
				this.pieces.remove(toString);
				// Deliberate fall-through
			case MOVE:
				MyEscapePiece piece = this.pieces.get(fromString);
				this.pieces.remove(fromString);
				this.pieces.put(toString, piece);
				return true;
			default:
				throw new EscapeException("Movement not proerly validated");
		}
	}

	/**
	 * Preapres a FilledEscapeSpace for the given coordinate
	 * 
	 * @param coord
	 *            The coordinate for which to prepare a FilledEscapeSpace
	 * @return a FilledEscapeSpace corresponding to the given coordinate
	 */
	public FilledEscapeSpace coordToFilled(MyCoordinate coord)
	{
		String stringCoord = StringManager.coordToString(coord);
		LocationType type = LocationType.CLEAR;
		if (spaces.containsKey(stringCoord)) {
			type = spaces.get(stringCoord);
		}
		MyEscapePiece piece = null;
		if (pieces.containsKey(stringCoord)) {
			piece = pieces.get(stringCoord);
		}
		return new FilledEscapeSpace(type, piece, coord);
	}

	/**
	 * Returns true if the given coordinate is off the board, false otherwise
	 * 
	 * @param coord
	 *            The coordinate to check whether or not is on the board.
	 * @return true if the coordinate is on the board, false otherwise.
	 */
	public boolean isOffBoard(MyCoordinate coord)
	{
		if (this.xMax > 0) {
			if (coord.getX() < 1 || this.xMax < coord.getX()) {
				return true;
			}
		}
		if (this.yMax > 0) {
			if (coord.getY() < 1 || this.yMax < coord.getY()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the piece on the board located at the given coordinate. If the given
	 * coordinate has no piece, returns null.
	 * 
	 * @param coordinate
	 *            The coordinate of the target piece to return.
	 * @return The piece located at the given coordinate or null if no such piece exists.
	 */
	@Override
	public EscapePiece getPieceAt(MyCoordinate coordinate)
	{
		String coordString = StringManager.coordToString(coordinate);
		if (isOffBoard(coordinate) || !pieces.containsKey(coordString)) {
			return null;
		}
		return pieces.get(coordString);
	}

	/**
	 * Prints a sparse description of the board.
	 * 
	 * @return a multiline string that sparsely describes the board
	 */
	public String toString()
	{
		String print = "Pieces: {";
		for (String key : this.pieces.keySet()) {
			print += "\n  {" + key + ", " + this.pieces.get(key) + "}";
		}
		print += "\n}\nSpaces: {";
		for (String key : this.spaces.keySet()) {
			print += "\n  {" + key + ", " + this.spaces.get(key) + "}";
		}
		return print + "\n}";
	}

}
