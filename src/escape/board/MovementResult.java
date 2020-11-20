/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.board;

/**
 * An enum to describe the possible outcomes of an attempted move on the escape board.
 * This provides an interface between the movement validator and the board. STAY was
 * originally included as an option, but it was removed in favor of throwing and catching
 * exceptions to produce error messages.
 * 
 * @version Nov 19, 2020
 */
public enum MovementResult
{
	MOVE, CAPTURE, EXIT
}
