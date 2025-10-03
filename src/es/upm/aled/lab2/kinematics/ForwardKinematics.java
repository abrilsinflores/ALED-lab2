package es.upm.aled.lab2.kinematics;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {

	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	//MÉTODO FACHADA Public method: returns the root of the position tree
	public static Node computePositions(Segment root, double originX, double originY) { // TODO
		return ForwardKinematics.computePositions(root, originX, originY, 0);
	}

	//MÉTODO RECURSIVO Private helper method that implements the recursive algorithm
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) { //TODO
		//instrumentalización del método
		long startTime = System.nanoTime();
		
		//CASO BASE
		if(link.getChildren().isEmpty()) {
			double coordX = baseX + link.getLength()*Math.cos(accumulatedAngle+link.getAngle());
			double coordY = baseY + link.getLength()*Math.sin(accumulatedAngle+link.getAngle());
			Node newNode = new Node(coordX, coordY);
			
			//intrumentalización del método
			 long runningTime = System.nanoTime()- startTime;
			 System.out.println("Tiempo de computePositions para un segmento con "
					 + link.getChildren().size() + " hijos: "
					 + runningTime + " nanosegundos");
			
			return newNode;
		}
		//PASO RECURSIVO
		//creamos las coordenadas del nodo
		double anglePadre = accumulatedAngle+link.getAngle();
		double coordX = baseX + link.getLength()*Math.cos(anglePadre);
		double coordY = baseY + link.getLength()*Math.sin(anglePadre);
		Node newNode = new Node(coordX, coordY);
		//este nodo tiene hijos porq segment tiene hijos, hay q añadirlos antes d devolverlo
		for(Segment hijoSegementos : link.getChildren()) {
			Node hijo = ForwardKinematics.computePositions(hijoSegementos, coordX, coordY, anglePadre);
			newNode.addChild(hijo);
		}
		//intrumentalización del método
		 long runningTime = System.nanoTime()- startTime;
		 System.out.println("Tiempo de computePositions para un segmento con "
				 + link.getChildren().size() + " hijos: "
				 + runningTime + " nanosegundos");
		
		return newNode;
	}
}