/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.coordinate;

import escape.exception.EscapeException;
import escape.util.StringManager;

/**
 * An implementation of a square coordinate.
 * 
 * @version Nov 15, 2020
 */
public class SquareCoordinate implements MyCoordinate
{

	private int x;
	private int y;

	/**
	 * Constructs a square coordinate with the given values.
	 * 
	 * @param x
	 *            X value of the new square coordinate.
	 * @param y
	 *            Y value of the new square coordinate.
	 */
	public SquareCoordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Calculates the distance from this square coordinate to the given square coordinate.
	 * 
	 * @param c
	 *            The coordinate to calculate the distance to from this coordinate.
	 * @return The square coordinate distance to the given coordinate.
	 */
	@Override
	public int DistanceTo(Coordinate c)
	{
		if (!(c instanceof SquareCoordinate)) {
			throw new EscapeException(
					"Invalid coordinate comparison between Square and "
							+ c.getClass().getName());
		}
		MyCoordinate mc = (SquareCoordinate) c;
		int absX = Math.abs(this.x - mc.getX());
		int absY = Math.abs(this.y - mc.getY());
		return Math.max(absX, absY);
	}

	/**
	 * Gets the x value of this coordinate
	 * 
	 * @return the x value of this coordinate
	 */
	@Override
	public int getX()
	{
		return this.x;
	}

	/**
	 * Gets the y value of this coordinate
	 * 
	 * @return the y value of this coordinate
	 */
	@Override
	public int getY()
	{
		return this.y;
	}

	/**
	 * Returns a string representation of this coordinate, convenient for debugging.
	 * 
	 * @return a string representation of this coordinate, convenient for debugging.
	 */
	public String toString()
	{
		return StringManager.coordToString(this);
	}

}
