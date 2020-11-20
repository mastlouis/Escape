/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.piece;

/**
 * Custom interface for escape pieces to take advantage of my implementation thereof.
 * 
 * @version Nov 18, 2020
 */
public interface MyEscapePiece extends EscapePiece
{
	/**
	 * Gets the movement pattern of this MyEscapePiece.
	 * 
	 * @return the movement pattern of this MyEscapePiece.
	 */
	public MovementPattern getPattern();

	/**
	 * Gets the value of the attribute stored with the given PieceAttributeID.
	 * 
	 * @param att
	 *            The PieceAttributeID of the attribute to retrieve.
	 * @return the value corresponing to the given key.
	 */
	public int getAttribute(PieceAttributeID att);
}
