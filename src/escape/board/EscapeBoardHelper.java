/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Matthew St Louis
 *******************************************************************************/

package escape.board;

import java.util.*;
import escape.piece.*;
import escape.piece.EscapePiece.*;
import escape.util.*;

/**
 * This class is a helper that bundles together a few related functionalities to help
 * create the escape board. This class stores the piece type descriptors and produces a
 * properly configured escape piece on demand when given the piece name and player. This
 * class also generates the pieces and terrain used in creating a board for the given
 * location initializers.
 * 
 * @version Nov 18, 2020
 */
public class EscapeBoardHelper
{
	private final HashMap<PieceName, PieceTypeDescriptor> descriptors;

	/**
	 * Constructs an EscapeBoardHelper with the given piece type descriptors. These are
	 * used to help generate pieces with the proper configuration for the game.
	 * 
	 * @param descriptorList
	 *            A list of PieceTypeDescriptors relevant to the current game.
	 */
	public EscapeBoardHelper(List<PieceTypeDescriptor> descriptorList)
	{
		HashMap<PieceName, PieceTypeDescriptor> descriptors = new HashMap<PieceName, PieceTypeDescriptor>();
		for (PieceTypeDescriptor descriptor : descriptorList) {
			descriptors.put(descriptor.getPieceName(), descriptor);
		}
		this.descriptors = descriptors;
	}

	/**
	 * Generates an escape piece with the given name and player configured with this
	 * EscapeBoardHelper's descriptors.
	 * 
	 * @param piece
	 *            The name of the escape piece to generate.
	 * @param player
	 *            The player who owns the escape piece to be generated.
	 * @return An escape piece of the given name and owned by the given player configured
	 *         with this EscapeBoardHelper's descriptors.
	 */
	public MyEscapePiece generatePiece(PieceName piece, Player player)
	{
		PieceTypeDescriptor descriptor = descriptors.get(piece);
		HashMap<PieceAttributeID, Integer> attributes = new HashMap<PieceAttributeID, Integer>();
		for (PieceAttribute att : descriptor.getAttributes()) {
			attributes.put(att.getId(), att.getValue());
		}
		return new AlphaPiece(piece, player, descriptor.getMovementPattern(),
				attributes);
	}

	/**
	 * Generates a hashmap that represents a board's worth of escape pieces. This hashmap
	 * can be fed to a board to initialize the board's escape pieces.
	 * 
	 * @param locations
	 *            A list of LocationInitializers that contain escape pieces to extract
	 *            into a hashmap.
	 * @return A hashmap representing the given pieces that can be fed to a board.
	 */
	public HashMap<String, MyEscapePiece> extractPieces(
			List<LocationInitializer> locations)
	{
		HashMap<String, MyEscapePiece> pieces = new HashMap<String, MyEscapePiece>();
		for (LocationInitializer location : locations) {
			if (location.pieceName != null) {
				MyEscapePiece piece = generatePiece(location.pieceName,
						location.player);
				pieces.put(StringManager.coordToString(location.x, location.y),
						piece);
			}
		}
		return pieces;
	}

	/**
	 * Generates a hashmap that represents the special locations on an escape board. This
	 * can be fed to a board to initialize that board's terrain.
	 * 
	 * @param locationsList
	 *            A list of LocationInitializers that contain special terrain.
	 * @return A hashmap representing the given terrain that can be fed to a baord.
	 */
	public HashMap<String, LocationType> extractLocations(
			List<LocationInitializer> locationsList)
	{
		HashMap<String, LocationType> locations = new HashMap<String, LocationType>();
		for (LocationInitializer location : locationsList) {
			if (location.locationType != LocationType.CLEAR
					&& location.locationType != null) {
				locations.put(StringManager.coordToString(location.x, location.y),
						location.locationType);
			}
		}
		return locations;
	}
}
