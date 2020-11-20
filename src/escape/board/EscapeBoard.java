/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.board;

import java.util.HashMap;
import escape.coordinate.MyCoordinate;
import escape.exception.EscapeException;
import escape.piece.*;

/**
 * Interface for Escape Boards. An Escape Board is meant to keep track of the locations of
 * each piece and the locations of any special terrain on the board. An Escape Board is
 * also tasked with all direct modifications to the locations of these pieces.
 * 
 * @version Nov 16, 2020
 */
public interface EscapeBoard
{
	/**
	 * Sets the state of the board using a hashmap of the pieces on the board and the
	 * terrain of the board using a second hashmap.
	 * 
	 * @param pieces
	 *            A hashmap where the key is a string representation of coordinates (see
	 *            StringManager.coordToString) and the value is an Escape Piece. This
	 *            represents the pieces on the board.
	 * @param spaces
	 *            A hashmap where the key is a string representation of coordinates (see
	 *            StringManager.coordToString) and the value is a LocationType. This
	 *            represents the terrain of the board.
	 */
	public void setBoard(HashMap<String, MyEscapePiece> pieces,
			HashMap<String, LocationType> spaces);

	/**
	 * Sets the validator to be used for this board.
	 * 
	 * @param validator
	 *            The validtor that will be used to determine the outcome of moves
	 *            attempted on this board.
	 */
	public void setValidator(MovementValidator validator);

	/**
	 * Attempts to move an escape piece from the requested from coordinate to the
	 * requested to coordinate. Returns true if the movement succeeds; returns false or
	 * throws an EscapeException if the movement does not succeed.
	 * 
	 * @param from
	 *            The coordinate from which to attempt to move the target piece.
	 * @param to
	 *            The coordinate to which to attempt to move the target piece.
	 * @return true if the movement succeeds; returns false or throws an EscapeException
	 *         if the movement does not succeed.
	 * @throws EscapeException
	 *             Description of invalid movement (if applicable)
	 */
	public boolean move(MyCoordinate from, MyCoordinate to) throws EscapeException;

	/**
	 * Attempts to get the piece at the specified location. The EscapePiece will be
	 * returned if one exists. If there is no piece at the specified coordinate or if the
	 * specified coordinate is off the board, returns null.
	 * 
	 * @param coordinate
	 *            The location from which to attempt to retrieve an EscapePiece.
	 * @return The escape piece at the given location if such a piece exists. Otherwise,
	 *         null.
	 */
	public EscapePiece getPieceAt(MyCoordinate coordinate);

}
