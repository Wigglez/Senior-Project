package dragonsreign.util.xml;

import java.util.ArrayList;

import org.xml.sax.SAXException;

import dragonsreign.character.Enemy;

public class EnemyHandler extends TagHandler {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private ArrayList<Enemy> mEnemyList = new ArrayList<Enemy>();
	private Enemy mEnemy = null;

	// ===========================================================
	// Constructors
	// ===========================================================

	public EnemyHandler() {
		super("enemy");
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void handleStartDocument() throws SAXException {
		super.handleStartDocument();
	}

	@Override
	public void handleStartTag() throws SAXException {
		mEnemy = new Enemy();
		mEnemy.setID(getIntegerAttribute("id"));
		mEnemy.setName(getStringAttribute("name"));
		mEnemy.setLevel(getIntegerAttribute("level"));
		//mEnemy.setHaste(getIntegerAttribute("haste"));
		mEnemy.getBaseResources().setHealth(getIntegerAttribute("health"));
		mEnemy.setGoldReward(getIntegerAttribute("goldreward"));
		mEnemy.setExperience(getIntegerAttribute("experiencereward"));

		mEnemyList.add(mEnemy);
	}

	@Override
	public void handleEndTag() throws SAXException {
		super.handleEndTag();
	}

	@Override
	public void handleEndDocument() throws SAXException {
		super.handleEndDocument();
	}

	@Override
	public void handleCharacterData(String data) throws SAXException {
		super.handleCharacterData(data);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
