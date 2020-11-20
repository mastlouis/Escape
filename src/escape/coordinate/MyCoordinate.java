/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.coordinate;

/**
 * This interface extends the base Coordinate interface to establish additional common
 * behavior for all coordinate implementations. This added functionality includes sharing
 * x and y coordinate values to assist in distance calculations.
 * 
 * @version Nov 15, 2020
 */
public interface MyCoordinate extends Coordinate
{
	/**
	 * Returns the x value of the coordinate on which it s called.
	 * 
	 * @return the x value of the coordinate on which is it called.
	 */
	public int getX();

	/**
	 * Returns the y value of the coordinate on which it s called.
	 * 
	 * @return the y value of the coordinate on which is it called.
	 */
	public int getY();

}
