/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.util;

import escape.coordinate.MyCoordinate;

/**
 * A class for static methods to standardize important string representations of objects
 * across different classes and packages.
 * 
 * @version Nov 18, 2020
 */
public class StringManager
{
	/**
	 * Returns a standardized string representation of a coordinate with the given x and y
	 * indices.
	 * 
	 * @param x
	 *            The x value of the coordinate to stringify.
	 * @param y
	 *            The y value of the coordinate to stringify.
	 * @return a standardized string representation of a coordinate with the given x and y
	 *         indices.
	 */
	public static String coordToString(int x, int y)
	{
		return "[" + x + "," + y + "]";
	}

	/**
	 * Returns a standardized string representation of the given coordinate.
	 * 
	 * @param c
	 *            The coordinate to stringify.
	 * @return A standardized representation of the given coordinate.
	 */
	public static String coordToString(MyCoordinate c)
	{
		return coordToString(c.getX(), c.getY());
	}
}
