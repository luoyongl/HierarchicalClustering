package wtu.sj.ly;

import java.util.List;

/**
 * ��װÿһ������
 * 
 * @author m1887
 *
 */

public class Cluster {

	/**
	 * ��ڵ�
	 */
	private Cluster left;
	/**
	 * �ҽڵ�
	 */
	private Cluster right;
	/**
	 * data
	 */
	private List<Double> vector;
	/**
	 * id
	 */
	private int id;
	/**
	 * ����
	 */
	private double distance;
	/**
	 * ��ǩ��
	 */
	private String name;

	public Cluster() {
	}

	public Cluster(Cluster left, Cluster right, List<Double> vector, int id, double distance,String name) {
		this.left = left;
		this.right = right;
		this.vector = vector;
		this.id = id;
		this.distance = distance;
		this.name=name;
	}

	public Cluster getLeft() {
		return left;
	}

	public void setLeft(Cluster left) {
		this.left = left;
	}

	public Cluster getRight() {
		return right;
	}

	public void setRight(Cluster right) {
		this.right = right;
	}

	public List<Double> getVector() {
		return vector;
	}

	public void setVector(List<Double> vector) {
		this.vector = vector;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
