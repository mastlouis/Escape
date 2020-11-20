/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.piece;

import java.util.HashMap;

/**
 * An implementation of a piece for the alpha release. Alpha Pieces maintain the piece's
 * name and player, as well as all attributes associated with pieces of the same name
 * within the escape game.
 * 
 * @version Nov 18, 2020
 */
public class AlphaPiece implements MyEscapePiece
{
	private final PieceName piece;
	private final Player player;
	private final MovementPattern pattern;
	private final HashMap<PieceAttributeID, Integer> attributes;

	/**
	 * Construct an AlphaPiece with the given information.
	 * 
	 * @param piece
	 *            The name of the AlphaPiece to construct.
	 * @param player
	 *            The player who owns the AlphaPiece to construct.
	 * @param pattern
	 *            The movement pattern of the AlphaPiece to construct.
	 * @param attributes
	 *            A hashmap of attributes associated with pieces of the same name as this
	 *            piece within this piece's escape game.
	 */
	public AlphaPiece(PieceName piece, Player player, MovementPattern pattern,
			HashMap<PieceAttributeID, Integer> attributes)
	{
		this.piece = piece;
		this.player = player;
		this.pattern = pattern;
		this.attributes = attributes;
	}

	/**
	 * Gets the name of this escape piece.
	 * 
	 * @return the name of this escape piece.
	 */
	public PieceName getName()
	{
		return this.piece;
	}

	/**
	 * Gets the player of this escape piece.
	 * 
	 * @return the player of this escape piece.
	 */
	public Player getPlayer()
	{
		return this.player;
	}

	/**
	 * Gets the movement pattern for this escape piece.
	 * 
	 * @return the movement pattern of this escape piece.
	 */
	public MovementPattern getPattern()
	{
		return this.pattern;
	}

	/**
	 * Gets the attribute value of the given ID for this piece.
	 * 
	 * @return the attribute value of the given ID for this piece.
	 */
	public int getAttribute(PieceAttributeID att)
	{
		return this.attributes.get(att);
	}

	/**
	 * Returns a convenient string representation of this piece.
	 * 
	 * @return a convenient string representation of this piece.
	 */
	public String toString()
	{
		return "Piece: [" + this.piece + ", " + this.player + "]";
	}

}
