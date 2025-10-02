package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

// TODO: Implemente la clase

/**
 * clase que implementa los segementos del exoesqueleto
 * cada segmento se identifica por su longitud y el ángulo que forma con su segmento padre
 * cada segmento tiene una lista de sus segmentos hijos
 */

public class Segment {
	private double length; //longitud en cm
	private double angle; //ángulo q forma el segmento con su segmento padre
	private List<Segment> children;
	//no se almacena la posicc del punto inicial del segmento raíz.
	// se asume q es el origen d coords
	//caso contrario, qn implemente la clase debe proporcionarla
	
	/*
	 * construye un nuevo segemento
	 * 
	 * @param length la longitud del segmento
	 * @param angle ángulo q forma con su segmento padre
	 */
	
	public Segment (double length, double angle) {
		this.length = length;
		this.angle = angle;
		this.children = new ArrayList<Segment>();
	}
	
	/*
	 * @returns  length
	 */
	
	public double getLength() {
		return this.length;
	}
	
	/*
	 * @returns angle
	 */
	
	public double getAngle() {
		return this.angle;
	}
	
	/*
	 * @returns la lista de todos los segmentos hijos
	 */
	
	public List<Segment> getChildren(){
		return this.children;
	}
	
	/*
	 * añade un hijo segmento si no está ya incluído
	 * 
	 * @param child hijo a añadirs
	 */
	
	public void addChild(Segment child) {
		if(!this.children.contains(child)) {
			this.children.add(child);
		}
	}
	

}
