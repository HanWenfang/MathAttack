/**
 * File name:	ButtonLight.java
 * Version:		1.0
 * Date:		@date 13:14:29
 * Author:		Sawan J. Kapai Harpalani
 * Copyright:	Copyright 200X Sawan J. Kapai Harpalani
 *
 *				This file is part of Math Attack.
 *
 *				Math Attack is free software: you can redistribute it 
 *				and/or modify it under the terms of the GNU General
 *				Public License as published by the Free Software 
 *				Foundation, either version 3 of the License, 
 *				or (at your option) any later version.
 *
 *				Math Attack is distributed in the hope that it will 
 *				be useful, but WITHOUT ANY WARRANTY; without even 
 *				the implied warranty of MERCHANTABILITY or FITNESS 
 *				FOR A PARTICULAR PURPOSE. See the GNU General Public
 *			    License for more details.
 *
 *				You should have received a copy of the GNU General 
 *				Public License along with Math Attack. If not, see 
 *				http://www.gnu.org/licenses/.
 */
package com.sawan.mathattack.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sawan.mathattack.scene2d.AbstractGroupLight;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonLight.
 */
public class ButtonLight extends AbstractGroupLight {
	
	//
	/** The is toggle active. */
	private boolean isToggleActive;

	/**
	 * Instantiates a new button light.
	 *
	 * @param width the width
	 * @param height the height
	 * @param texture the texture
	 * @param DIPActive the DIP active
	 */
	public ButtonLight(float width, float height, TextureRegion texture,
			boolean DIPActive) {
		super(width, height, DIPActive);
		//
		setTextureRegion(texture, true);
		this.isToggleActive = false;
	}

	/**
	 * Checks if is toggle active.
	 *
	 * @return true, if is toggle active
	 */
	public boolean isToggleActive() {
		return isToggleActive;
	}

	/**
	 * Sets the toggle active.
	 *
	 * @param isToggleActive the new toggle active
	 */
	public void setToggleActive(boolean isToggleActive) {
		this.isToggleActive = isToggleActive;
	}

	/**
	 * Sets the toggle switch.
	 */
	public void setToggleSwitch() {
		if (isToggleActive) {
			isToggleActive = false;
		} else {
			isToggleActive = true;
		}
	}
}
