package dragonsreign.character;

import java.io.StringReader;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import dragonsreign.util.xml.EnemyHandler;
import dragonsreign.util.xml.MinimizeXMLParser;

public class Enemy extends Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// Gold that the enemy gives
	protected int mGoldReward;

	// Experience that the enemy gives
	protected int mExperienceReward;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Enemy() {
		mGoldReward = 0;
		mExperienceReward = this.mExperience;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// Gold reward
	public int getGoldReward() {
		return mGoldReward;
	}

	public void setGoldReward(int pGoldReward) {
		this.mGoldReward = pGoldReward;
	}
	
	// Experience reward
	public int getExperienceReward() {
		return mExperienceReward;
	}

	public void setExperienceReward(int pExperienceReward) {
		this.mExperienceReward = pExperienceReward;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// Currently unused, should be referenced for items
	public void loadEnemies() throws Exception {
		try {
			MinimizeXMLParser parser = new MinimizeXMLParser();
			parser.setElementHandler(new EnemyHandler());
			parser.parse(new InputSource(new StringReader(
					"assets/xml/enemies.xml")));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
