package in.co.sunrays.bean;

/**
 * Marksheet Javabean contains marksheet attributes and their accessor methods.
 * 
 * @version 1.0
 * @since 01 Feb 2015
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class Marksheet {

	private String rollNo;

	private String name;

	private int physics;

	private int chemistry;

	private int maths;

	/**
	 * @return the chemistry
	 */
	public int getChemistry() {
		return chemistry;
	}

	/**
	 * @param chemistry
	 *            the chemistry to set
	 */
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	/**
	 * @return the maths
	 */
	public int getMaths() {
		return maths;
	}

	/**
	 * @param maths
	 *            the maths to set
	 */
	public void setMaths(int maths) {
		this.maths = maths;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the physics
	 */
	public int getPhysics() {
		return physics;
	}

	/**
	 * @param physics
	 *            the physics to set
	 */
	public void setPhysics(int physics) {
		this.physics = physics;
	}

	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo
	 *            the rollNo to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

}
