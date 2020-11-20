/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.board;

import escape.coordinate.MyCoordinate;
import escape.piece.MyEscapePiece;

/**
 * An object to bundle together all of the information that describes an escape space.
 * This includes the escape piece, the location type, and the coordinates.
 * 
 * @version Nov 19, 2020
 */
public class FilledEscapeSpace
{
	LocationType type;
	MyEscapePiece piece;
	MyCoordinate coord;

	/**
	 * Constructs a FilledEscapeSpace with the specified information.
	 * 
	 * @param type
	 *            The LocationType of this escape space.
	 * @param piece
	 *            The piece at this escape space or null of no such piece exists.
	 * @param coord
	 *            The coordinate of this escape space.
	 */
	public FilledEscapeSpace(LocationType type, MyEscapePiece piece,
			MyCoordinate coord)
	{
		this.type = type;
		this.piece = piece;
		this.coord = coord;
	}

	/**
	 * Returns the location type for this FilledEscapeSpace
	 * 
	 * @return the location type for this FilledEscapeSpace
	 */
	public LocationType getType()
	{
		return this.type;
	}

	/**
	 * Returns the escape piece for this FilledEscapeSpace
	 * 
	 * @return the escape piece for this FilledEscapeSpace, or null if no such piece
	 *         exists
	 */
	public MyEscapePiece getPiece()
	{
		return this.piece;
	}

	/**
	 * Returns the coordinate for this FilledEscapeSpace
	 * 
	 * @return the coordinate for this FilledEscapeSpace
	 */
	public MyCoordinate getCoordinate()
	{
		return this.coord;
	}

	/**
	 * Returns a convenient string representation of this FilledEscapeSpace for debugging
	 * 
	 * @return a convenient string representation of this FilledEscapeSpace for debugging
	 */
	public String toString()
	{
		return "{" + this.coord + ", " + this.type + ", " + this.piece + "}";
	}
}
