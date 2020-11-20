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
 * An interface to represent any object that can serve as a validator for an Escape Board.
 * The validator is tasked with determining the outcome of a given escape piece's
 * attempted move.
 * 
 * @version Nov 19, 2020
 */
public interface MovementValidator
{
	/**
	 * Returns a MovementResult of how the requested move should play out according to the
	 * validator's rules, or throws an exception that explains why the requested move is
	 * invalid.
	 * 
	 * @param from
	 *            The FilledEscapeSpace on which the requested movement starts.
	 * @param to
	 *            The FilledEscapeSpace on which the requested movement ends.
	 * @return a MovementResult representing the outcome of the requested movement if the
	 *         requested movement is valid.
	 * @throws EscapeException
	 *             if the requested movement is not valid.
	 */
	public MovementResult validate(FilledEscapeSpace from, FilledEscapeSpace to)
			throws EscapeException;
}
