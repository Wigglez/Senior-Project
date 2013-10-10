package dragonsreign.util;

import android.util.Log;
import dragonsreign.character.characterclass.ClericClass;
import dragonsreign.character.characterclass.RangerClass;
import dragonsreign.character.characterclass.WarriorClass;
import dragonsreign.scene.CharacterSelectionScene;

public class PartyContainer extends CharacterSelectionScene {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected WarriorClass mWarriorObj;
	protected RangerClass mRangerObj;
	protected ClericClass mClericObj;
	
	protected int mSelectedPlayer;
	
	// ===========================================================
	// Constructors
	// ===========================================================

	public PartyContainer() {
		
	}
	
	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public WarriorClass getWarriorObj() {
		return mWarriorObj;
	}

	public RangerClass getRangerObj() {
		return mRangerObj;
	}

	public ClericClass getClericObj() {
		return mClericObj;
	}

	public int getSelectedPlayer() {
		return mSelectedPlayer;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public void sendCharacterData(WarriorClass pWarrior, RangerClass pRanger, ClericClass pCleric, int pSelectedPlayer) {
		mWarriorObj = pWarrior;
		mRangerObj = pRanger;
		mClericObj = pCleric;
		mSelectedPlayer = pSelectedPlayer;
	}
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
