/**
 * File name:	WorldLayerBG.java
 * Version:		1.0
 * Date:		20/3/2015 10:04:11
 * Author:		Itop1
 * Copyright:	Copyright 200X Itop1
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
package com.sawan.mathattack.game.layers;

import java.util.Random;

import com.badlogic.gdx.utils.Scaling;
import com.sawan.jungle.assets.Assets;
import com.sawan.mathattack.game.managers.MAGameManager;
import com.sawan.mathattack.models.EmptyActorLight;
import com.sawan.mathattack.models.SmartActor;
import com.sawan.mathattack.scene2d.AbstractWorldScene2d;
import com.sawan.mathattack.settings.AppSettings;

/**
 * @author Itop1
 *
 */
public class WorldLayerBG extends AbstractWorldScene2d {
	MAGameManager gameManager;

	public WorldLayerBG(MAGameManager gameManager, float posX, float posY,
			float worldWidth, float worldHeight) {
		super(posX, posY, worldWidth, worldHeight);
		//
		this.gameManager = gameManager;
		//
		setUpBackround();
		setUpBottomSoils();
		setUpClouds();
	}

	private void setUpBackround() {
		setBackgroundTexture(Backgrounds, Scaling.stretch, true, false);
	}

	private void setUpBottomSoils() {
		float worldWidth = gameManager.getStage().getWidth();
		float soilWidth = 300f;
		float soilHeight = 100f;
		//
		int numberOfSoils = (int) ((worldWidth / (soilWidth * AppSettings
				.getWorldSizeRatio())) + 1);
		//
		for (int i = 0; i < numberOfSoils; i++) {
			EmptyActorLight currentSoil = new EmptyActorLight(
					soilWidth, soilHeight, true);
			//
			currentSoil.setTextureRegion(Assets.img_obj_soil_1_, true);
			float posX = (i * currentSoil.getWidth())
					- (4 * AppSettings.getWorldSizeRatio());
			currentSoil.setPosition(posX, 0);
			//
			addActor(currentSoil);
		}
	}

	private void setUpClouds() {
		Random rnd = new Random();
		//
		for (int i = 0; i < 8; i++) {
			//
			float rndSizeRatio = rnd.nextInt(80) + 20;
			//
			SmartActor currentCloud = new SmartActor(231 * rndSizeRatio / 100,
					128 * rndSizeRatio / 100, rnd, true);
			//
			currentCloud.setTextureRegion(Assets.img_obj_cloud, true);
			currentCloud.setPosition(-200,
					gameManager.getStage().getHeight() / 2);
			//
			float posY = rnd.nextInt((int) gameManager.getStage().getHeight())
					+ gameManager.getStage().getHeight() / 3;
			//
			currentCloud.startActionMoveSideToSideFreely(15, -200,
					(int) gameManager.getStage().getWidth() + 200, (int) posY,
					15f);
			//
			addActor(currentCloud);
		}
	}

}