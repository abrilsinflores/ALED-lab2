package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

// TODO: Implemente la clase
public class Segment {
	private double length; //longitud en cm
	private double angle; //ángulo q forma el segmento con su segmento padre
	private List<Segment> children;
	//no se almacena la posicc del punto inicial del segmento raíz.
	// se asume q es el origen d coords
	//caso contrario, qn implemente la clase debe proporcionarla
	
	public Segment (double length, double angle) {
		this.length = length;
		this.angle = angle;
		this.children = new ArrayList<Segment>();
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getAngle() {
		return this.angle;
	}
	
	public List<Segment> getChildren(){
		return this.children;
	}
	
	public void addChild(Segment child) {
		if(!this.children.contains(child)) {
			this.children.add(child);
		}
	}
	

}
