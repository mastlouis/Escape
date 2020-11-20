/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.board;

import escape.exception.EscapeException;

/**
 * An implementation of the validator interface for the Alpha release. This validator
 * produces the result of an attempted move using the guidelines set forth for the Alpha
 * release.
 * 
 * @version Nov 19, 2020
 */
public class AlphaMovementValidator implements MovementValidator
{
	/**
	 * Produces a MovementResult that describes the result of the given attempted movement
	 * or throws an exception if the attempted movement is invalid. This method determines
	 * movement outcome according to the rules set forth in the Alpha manual.
	 * 
	 * @param from
	 *            A FilledEscapeSpace representing the space from which the requested
	 *            movement begins.
	 * @param to
	 *            A FilledEscapeSpace representing the space on which the requested
	 *            movement ends.
	 * @return A MovementResult corresponding to the outcome of the movement or throws an
	 *         EscapeException if the requested movement is invalid.
	 */
	public MovementResult validate(FilledEscapeSpace from, FilledEscapeSpace to)
			throws EscapeException
	{
		if (pieceIsAbsent(from)) {
			throw new EscapeException("There is no piece on " + from + " to move");
		}
		if (isInvalidDestination(to)) {
			throw new EscapeException(
					"The space " + to + " is not a valid destination");
		}
		if (isSelfOccupied(from, to)) {
			throw new EscapeException("You cannot move the piece at " + from + " to "
					+ to + " because you already control the piece at " + to);
		}
		if (isValidExit(to)) {
			return MovementResult.EXIT;
		}
		if (isValidCapture(from, to)) {
			return MovementResult.CAPTURE;
		}

		return MovementResult.MOVE;
	}

	/**
	 * Returns true if there is no piece on the specified space.
	 * 
	 * @param from
	 *            The FilledEscapeSpace on which to check for a piece.
	 * @return true if there is no piece on the specified space, false otherwise.
	 */
	private boolean pieceIsAbsent(FilledEscapeSpace from)
	{
		return from.getPiece() == null;
	}

	/**
	 * Returns true if the given space is not a valid destination space for a piece to
	 * move to.
	 * 
	 * @param dest
	 *            The destination coordinate to check.
	 * @return true if the given space is not a valid destination space for a piece to
	 *         move to, false otherwise.
	 */
	private boolean isInvalidDestination(FilledEscapeSpace dest)
	{
		return dest.getType() == LocationType.BLOCK;
	}

	/**
	 * Returns true if both of the given spaces contain pieces controlled by the same
	 * player, false otherwise. For Alpha only, this returns false if a piece moves to its
	 * own coordinate.
	 * 
	 * @param from
	 *            The FilledEscapeSpace from which the requested move starts
	 * @param to
	 *            The FilledEscapeSpace on which the requested move ends
	 * @return true if both of the given spaces contain pieces controlled by the same
	 *         player, false otherwise.
	 */
	private boolean isSelfOccupied(FilledEscapeSpace from, FilledEscapeSpace to)
	{
		if (from.getPiece() == null || to.getPiece() == null) {
			return false;
		}
		if (from.getPiece().getPlayer() != to.getPiece().getPlayer()) {
			return false;
		}
		if (from.getCoordinate().getX() == to.getCoordinate().getX()
				&& from.getCoordinate().getY() == to.getCoordinate().getY()) {
			return false;
		}
		return true;
	}

	/**
	 * Returns true if the given space is an exit, false otherwise.
	 * 
	 * @param dest
	 *            The target FilledEscapeSpace to check.
	 * @return true if the given space is an exit, false otherwise.
	 */
	private boolean isValidExit(FilledEscapeSpace dest)
	{
		return dest.getType() == LocationType.EXIT;
	}

	private boolean isValidCapture(FilledEscapeSpace from, FilledEscapeSpace to)
	{
		if (from.getPiece() == null || to.getPiece() == null) {
			return false;
		}
		if (from.getPiece().getPlayer() == to.getPiece().getPlayer()) {
			return false;
		}
		return true;
	}
}
