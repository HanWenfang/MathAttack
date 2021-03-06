/**
 * File name:	AbstractGroupLight.java
 * Version:		1.0
 * Date:		@date 13:13:33
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

package com.sawan.mathattack.scene2d;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.sawan.mathattack.settings.AppSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractGroupLight.
 */
public abstract class AbstractGroupLight extends Group {
	//
	/** The log tag. */
	protected final String logTag = "MtxActorLog";
	
	/** The log active. */
	public static boolean logActive = true;

	// Texture Region for actor (Not mandatory)
	/** The texture region. */
	private TextureRegion textureRegion;
	
	/** The is texture region active. */
	private boolean isTextureRegionActive = false;

	/**
	 * Instantiates a new abstract group light.
	 *
	 * @param textureRegion the texture region
	 * @param isTextureRegionActive the is texture region active
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param orgnX the orgn x
	 * @param orgnY the orgn y
	 * @param width the width
	 * @param height the height
	 */
	public AbstractGroupLight(TextureRegion textureRegion,
			boolean isTextureRegionActive, float posX, float posY, float orgnX,
			float orgnY, float width, float height) {
		super();
		this.textureRegion = textureRegion;
		this.isTextureRegionActive = isTextureRegionActive;
		setBounds(posX, posY, width, height);
		setPosition(posX, posY);
		setSize(width, height);
		setOrigin(orgnX, orgnY);
	}

	/**
	 * Instantiates a new abstract group light.
	 *
	 * @param textureRegion the texture region
	 * @param isTextureRegionActive the is texture region active
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param width the width
	 * @param height the height
	 */
	public AbstractGroupLight(TextureRegion textureRegion,
			boolean isTextureRegionActive, float posX, float posY, float width,
			float height) {
		super();
		this.textureRegion = textureRegion;
		this.isTextureRegionActive = isTextureRegionActive;
		setBounds(posX, posY, width, height);
		setPosition(posX, posY);
		setSize(width, height);
	}

	/**
	 * Instantiates a new abstract group light.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param width the width
	 * @param height the height
	 */
	public AbstractGroupLight(float posX, float posY, float width, float height) {
		super();
		setBounds(posX, posY, width, height);
		setPosition(posX, posY);
		setSize(width, height);
	}

	/**
	 * Instantiates a new abstract group light.
	 *
	 * @param width the width
	 * @param height the height
	 * @param DIPActive the DIP active
	 */
	public AbstractGroupLight(float width, float height, boolean DIPActive) {
		super();
		if (DIPActive) {
			float ratioSize = AppSettings.getWorldSizeRatio();
			setSize(width * ratioSize, height * ratioSize);
		} else {
			setSize(width, height);
		}

	}

	/**
	 * Instantiates a new abstract group light.
	 */
	public AbstractGroupLight() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.scenes.scene2d.Group#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch, float)
	 */
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		// For fade out/in effect
		batch.setColor(this.getColor().r, this.getColor().g, this.getColor().b,
				parentAlpha * this.getColor().a);

		// DRAW TEXTURE REGION (Draw only if set active and not null)
		// ##################################################################
		if (isTextureRegionActive && textureRegion != null) {
			// Draw it due to actors' settings
			batch.draw(textureRegion, getX(), getY(), getOriginX(),
					getOriginY(), getWidth(), getHeight(), getScaleX(),
					getScaleY(), getRotation());
		}
	}

	/**
	 * Translate actor in a direction of speed without stopping. Actor moves in
	 * constants speed set without acceleration
	 * 
	 * @param speedX
	 *            axis-X speed
	 * @param speedY
	 *            axis-Y speed
	 * @param delta
	 *            the delta time for accurate speed
	 * */
	public void translateWithoutAcc(float speedX, float speedY, float delta) {
		setPosition(getX() + (speedX * delta), getY() + (speedY * delta));
	}

	/**
	 * Get textureRegion of the actor.
	 *
	 * @return TextureRegion
	 */
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

	/**
	 * Set texture region for the actor, it will be drawn only if texture region
	 * is set and active.
	 *
	 * @param textureRegion            texture region of the actor
	 * @param isTextureRegionActive            set texture region active to be drawn or not
	 */
	public void setTextureRegion(TextureRegion textureRegion,
			boolean isTextureRegionActive) {
		this.textureRegion = textureRegion;
		this.isTextureRegionActive = isTextureRegionActive;
	}

	/**
	 * Checks if is texture region active.
	 *
	 * @return true, if is texture region active
	 */
	public boolean isTextureRegionActive() {
		return isTextureRegionActive;
	}

	/**
	 * Sets the texture region active.
	 *
	 * @param isTextureRegionActive the new texture region active
	 */
	public void setTextureRegionActive(boolean isTextureRegionActive) {
		this.isTextureRegionActive = isTextureRegionActive;
	}
}
