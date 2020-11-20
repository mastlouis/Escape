/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.coordinate;

import escape.coordinate.Coordinate.CoordinateType;
import escape.exception.EscapeException;

/**
 * A factory for coordinate objects of various types. This class is meant to abstract away
 * some amount of coordinate creation logic from other classes.
 * 
 * @version Nov 16, 2020
 */
public class CoordinateFactory
{

	/**
	 * Produces a coordinate of the given CoordinateType and values.
	 * 
	 * @param id
	 *            The CoordinateType for the new coordinate
	 * @param x
	 *            The x value of the new coordinate
	 * @param y
	 *            The y value of the new coordinate
	 * @return A coordinate of the given CoordinateType and values.
	 */
	public static MyCoordinate makeCoordinate(CoordinateType id, int x, int y)
	{
		switch (id) {
			case SQUARE:
				return new SquareCoordinate(x, y);
			case ORTHOSQUARE:
			case HEX:
			case TRIANGLE:
			default:
				throw new EscapeException(
						"Alpha Release can only implement Square coordinates");
		}
	}
}
